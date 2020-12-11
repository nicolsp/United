package com.example.united

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.united.entities.TodosReal
import kotlinx.android.synthetic.main.itemunited_list_view.view.*

class UnitedAdapter (val callback: CallbackInterface): RecyclerView.Adapter<UnitedAdapter.UnitedViewHolder>(){

    private var unitedinList = emptyList<TodosReal>()

    fun updateAdapter(mList: List<TodosReal>) {
        unitedinList = mList
        notifyDataSetChanged()
    }

    inner class UnitedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImg = itemView.textnombre
        val itemimage = itemView.textregion
        val algo = itemView.setOnClickListener {
            callback.passTheData(unitedinList[adapterPosition])
        }
    }
    override fun onBindViewHolder(holder: UnitedViewHolder,position: Int) {
        Glide.with(holder.itemView.context).load(unitedinList[position].name)

        holder.itemImg.text = unitedinList[position].name.toString()

    }

    override fun getItemCount() = unitedinList.size

    interface CallbackInterface {
        fun passTheData(todosReal: TodosReal)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): UnitedViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemunited_list_view,parent,false)
        return UnitedViewHolder(itemView)
    }
}