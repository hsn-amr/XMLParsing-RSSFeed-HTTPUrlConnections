package com.example.xmlparsingrssfeedhttpurlconnections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.Item
import kotlinx.android.synthetic.main.item_row.view.*

class RVNews(var news: ArrayList<Item>): RecyclerView.Adapter<RVNews.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var new = news[position]

        holder.itemView.apply {
            tvTitle.text = new.title
//            tvLink.text = new.url
            tvDescription.text = new.description
        }
    }

    override fun getItemCount() = news.size
}