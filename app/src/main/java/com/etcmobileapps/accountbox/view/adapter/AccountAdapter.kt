package com.etcmobileapps.accountbox.view.adapter

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.accountbox.R
import com.etcmobileapps.accountbox.data.Account
import com.etcmobileapps.accountbox.data.Db
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlin.coroutines.coroutineContext
import kotlin.properties.Delegates


class AccountAdapter(private var data: MutableList<Account>) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    lateinit var context:Context;
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       context = p0.context
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.digital_account_item, p0, false))
    }
    override fun getItemCount(): Int=data.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         var showHideBoolan:Boolean = false

        when(data[position].application)
        {
            "Netflix" -> {
                Picasso.get().load(R.drawable.netlixlogo).into(holder.tvWebsiteLogo)
            }
            "Instagram" -> {
                Picasso.get().load(R.drawable.instagramlogo).into(holder.tvWebsiteLogo)
            }
            "Facebook" -> {
                Picasso.get().load(R.drawable.facebooklogo).into(holder.tvWebsiteLogo)
            }
            "Spotify" -> {
                Picasso.get().load(R.drawable.spotifylogo).into(holder.tvWebsiteLogo)
            }
            "Amazon" -> {
                Picasso.get().load(R.drawable.amazon).into(holder.tvWebsiteLogo)
            }
            "Twitter" -> {
                Picasso.get().load(R.drawable.twitter).into(holder.tvWebsiteLogo)
            }
            "Yahoo" -> {
                Picasso.get().load(R.drawable.yahoo).into(holder.tvWebsiteLogo)
            }
            "Reddit" -> {
                Picasso.get().load(R.drawable.reddit).into(holder.tvWebsiteLogo)
            }
            else ->{
                val drawable = TextIconDrawable().apply {
                    text = data[position].application.toString()
                    textColor = Color.BLACK
                }
                holder.tvWebsiteLogo.setImageDrawable(drawable);
            }
        }

        holder.tvWebsiteName?.text = data[position].application
        holder.tvUsername?.text = data[position].username
        holder.tvPassword?.text = data[position].password

        val popupMenu = PopupMenu(context, holder.popupBt)
        popupMenu.menu.add(Menu.NONE, 0, 0, R.string.item_copy);
        popupMenu.menu.add(Menu.NONE, 1, 1, R.string.item_delete);

        popupMenu.setOnMenuItemClickListener { menuItem -> //get id of the clicked item
            val id = menuItem.itemId

            //Get Values from R.string for Localization
            val websiteLocalValue: String =  context.getString(R.string.website_name)
            val usernameLocalValue =          context.getString(R.string.website_username)
            val passwordLocalValue =          context.getString(R.string.website_password)
            var accountBoxAdValue =          context.getString(R.string.copy_ad)

            //Get Values from TextView
            var websiteName = holder.tvWebsiteName.text
            var username = holder.tvUsername.text
            var password = holder.tvPassword.text

            val copiedValue =          context.getString(R.string.copied)

            //handle clicks
            if (id == 0) {
                val textToCopy =  "$websiteLocalValue: $websiteName \n$usernameLocalValue: $username \n$passwordLocalValue: $password \n \n $accountBoxAdValue "
                val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", textToCopy)
                clipboardManager.setPrimaryClip(clipData)
                Snackbar.make(context,holder.itemView, copiedValue, Snackbar.LENGTH_LONG).show()}
            else if (id == 1) {
                    val database = Db.getDatabase(context)!!
                    database.getManagerDao().deleteAccountById(data[position].uid)
                    data.removeAt(position)
                   notifyDataSetChanged()
            }
            false
        }


        holder.popupBt.setOnClickListener(View.OnClickListener { popupMenu.show() })
        holder.showHide.setOnClickListener(View.OnClickListener {
         if (showHideBoolan) {
             holder.tvPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
             showHideBoolan=false
         } else {
             holder.tvPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
             showHideBoolan=true
         }
        })
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvWebsiteLogo = itemView.findViewById<ImageView>(R.id.websiteLogo)
        val tvWebsiteName = itemView.findViewById<TextView>(R.id.websiteName)
        val tvUsername = itemView.findViewById<TextView>(R.id.username)
        val tvPassword= itemView.findViewById<TextView>(R.id.password)
        val popupBt= itemView.findViewById<ImageButton>(R.id.popupBt)
        val showHide= itemView.findViewById<ImageButton>(R.id.showHideBt)

    }


    class TextIconDrawable: Drawable() {
        private var textPaint = TextPaint().apply {
            textAlign = Paint.Align.CENTER
            isFakeBoldText = true
        }
        var text by Delegates.observable("") { _, _, _ -> invalidateSelf() }
        var textColor by Delegates.observable(Color.RED) { _, _, _ -> invalidateSelf() }

        private fun fitText(width: Int) {
            textPaint.textSize = 48f
            val widthAt48 = textPaint.measureText(text)
            textPaint.textSize = 30f / widthAt48 * width.toFloat()
        }

        override fun draw(canvas: Canvas) {
            val width = bounds.width()
            val height = bounds.height()

            fitText(width)
            textPaint.color = ColorUtils.setAlphaComponent(textColor, alpha)
            canvas.drawText(text, width / 2f, height / 2f, textPaint)
        }



        override fun setAlpha(alpha: Int) {
            this.alpha = 255
        }

        override fun setColorFilter(colorFilter: ColorFilter?) {
            textPaint.colorFilter = colorFilter
        }

        override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    }



}