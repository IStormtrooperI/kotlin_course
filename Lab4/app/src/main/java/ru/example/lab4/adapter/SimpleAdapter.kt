package ru.example.lab4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.example.lab4.R
import ru.example.lab4.model.SomethingData

class SimpleAdapter(
    val handleTap: (SomethingData) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    var items: List<SomethingData> = listOf()

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: SomethingData){
            itemView.apply {
                if(item.title.length > 15)
                    title_text_view.text = item.title.substring(0, 15) + "..."
                else
                    title_text_view.text = item.title
                if(item.subtitle.length > 70)
                    subtitle_text_view.text = item.subtitle.substring(0, 70) + "..."
                else
                    subtitle_text_view.text = item.subtitle
                setOnClickListener {
                    handleTap(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun set(items: List<SomethingData>) {
        this.items = listOf()
        this.items = items
        notifyDataSetChanged()
    }
}