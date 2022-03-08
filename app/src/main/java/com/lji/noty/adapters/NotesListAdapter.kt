package com.lji.noty.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.lji.noty.databinding.NotesRecyclerlistRowBinding
import com.lji.noty.roomdata.Note

class NodeListAdapter :
    RecyclerView.Adapter<NodeListAdapter.MyViewHolder>() {

    var items: List<Note> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val withDataBinding = NotesRecyclerlistRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return MyViewHolder(withDataBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.title.text = items[position].title
            it.noteDesc.text = items[position].noteDesc
        }
    }

    class MyViewHolder(val viewDataBinding: NotesRecyclerlistRowBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

}