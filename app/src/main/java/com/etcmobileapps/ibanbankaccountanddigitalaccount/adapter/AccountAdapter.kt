package com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import com.squareup.picasso.Picasso


class AccountAdapter(private val data: List<Account>, val context: Context) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.digital_account_item, p0, false))
    }
    override fun getItemCount(): Int=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(data[position].application)
        {
            "Netflix" -> Picasso.get().load(R.drawable.netlixlogo).into(holder.tvWebsiteLogo)
            "Instagram" -> Picasso.get().load(R.drawable.instagramlogo).into(holder.tvWebsiteLogo)
            "Facebook" -> Picasso.get().load(R.drawable.facebooklogo).into(holder.tvWebsiteLogo)
            "Spotify" -> Picasso.get().load(R.drawable.spotifylogo).into(holder.tvWebsiteLogo)
        }

        holder.tvWebsiteName?.text = data[position].application
        holder.tvUsername?.text = data[position].username
        holder.tvPassword?.text = data[position].password

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvWebsiteLogo = itemView.findViewById<ImageView>(R.id.websiteLogo)
        val tvWebsiteName = itemView.findViewById<TextView>(R.id.websiteName)
        val tvUsername = itemView.findViewById<TextView>(R.id.username)
        val tvPassword= itemView.findViewById<TextView>(R.id.password)

    }
}