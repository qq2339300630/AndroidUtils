package com.example.androidutils.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseQuickAdapter
import com.example.androidutils.databinding.ItemTypeBinding
import com.example.androidutils.model.Type

class TypeAdapter: BaseQuickAdapter<Type, TypeAdapter.ViewHolder>() {

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        item: Type?
    ) {
        holder.binding.tvMsg.text = item?.name
    }

    // 自定义ViewHolder类
    class ViewHolder(
        parent: ViewGroup,
        val binding: ItemTypeBinding = ItemTypeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): ViewHolder {
        // 返回一个 ViewHolder
        return ViewHolder(parent)
    }
}