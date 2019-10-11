package com.example.bubblepicker.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bubblepicker.Model.ListItemResponse
import com.example.bubblepicker.R
import com.example.bubblepicker.Room.AppDatabase
import kotlinx.android.synthetic.main.itemlistbypage.view.*

class ListItemByPageAdapter(var context: Context?, val callback: ((Any, String) -> Unit)?) : RecyclerView.Adapter<ListItemByPageAdapter.ListItemViewHolder>() {
    var listitem = mutableListOf<ListItemResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(LayoutInflater.from(context).inflate(R.layout.itemlistbypage, parent, false))
    }

    override fun getItemCount(): Int {
        return this.listitem.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {

        holder.bindView(listitem[position],callback)

    }
    fun addListItem(it: List<ListItemResponse>) {
        this.listitem.addAll(it)
    }

    inner class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindView(listitem: ListItemResponse,callback: ((Any, String) -> Unit)?) {
            val appDatabase = AppDatabase.getAppDatabase(context!!)
            if (appDatabase.favdao().getStudentByName(listitem.name).isNotEmpty()){
                Glide.with(context!!)
                    .load(R.drawable.menu1)
                    .centerCrop()
                    .into(itemView.favname)
            }
            itemView.tvname.text =listitem.name
            itemView.tvname.setOnClickListener {
                callback!!.invoke(listitem,"click")
            }
            itemView.favname.setOnClickListener {
                callback!!.invoke(listitem,"fav")
            }
        }
    }
}