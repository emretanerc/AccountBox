package com.etcmobileapps.accountbox.view.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.accountbox.R
import com.etcmobileapps.accountbox.data.IconModel
import com.squareup.picasso.Picasso


class IconAdapter(private val data: ArrayList<IconModel>, val context: Context) : RecyclerView.Adapter<IconAdapter.ViewHolder>() {
    var currentPos:Int=-1
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.icon_item, p0, false))

            }
    override fun getItemCount(): Int=data.size


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawble = data[position].imageId
        Picasso.get().load(drawble).into(holder.image)



      holder.image.setOnClickListener {
          holder.tick.visibility = View.VISIBLE
          currentPos = position
      }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = itemView.findViewById<ImageView>(R.id.iconButton)
        val tick = itemView.findViewById<ImageView>(R.id.tickView)
    }



}