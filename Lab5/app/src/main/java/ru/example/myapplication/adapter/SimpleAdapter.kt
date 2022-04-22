package ru.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.example.data.models.MessageDB
import ru.example.myapplication.databinding.ItemLayoutBinding
import ru.example.myapplication.R
import ru.example.myapplication.model.MessageData

class SimpleAdapter: RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    var items: List<MessageDB> = listOf()

    inner class ViewHolder(
        private val binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MessageDB) {
            itemView.apply {
                message_text_view.text = item.message
                full_name_text_view.text = item.fullName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun set(items: List<MessageDB>) {
        this.items = listOf()
        this.items = items
        notifyDataSetChanged()
    }
}