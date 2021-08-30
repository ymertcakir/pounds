package com.example.pounds.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pounds.databinding.CommentListItemBinding
import com.example.pounds.model.Comment


class CommentAdapter(private val commentClickListener: CommentClickListener):androidx.recyclerview.widget.ListAdapter<Comment, CommentAdapter.CommentViewHolder>(
    CommentDiffCallbacks()) {

    override fun submitList(list: List<Comment>?) {
        super.submitList(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder.from(parent)
    }


    class CommentViewHolder(private val itemBinding: CommentListItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Comment, commentClickListener: CommentClickListener ){
            itemBinding.commentListItem= data
            itemBinding.commentClickListeners= commentClickListener
            itemBinding.executePendingBindings()
            }
        companion object{
            fun from(parent: ViewGroup):CommentViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CommentListItemBinding.inflate(layoutInflater, parent, false)
                return CommentViewHolder(binding)
            }
        }

        }
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item, commentClickListener)
        }
    }

class CommentDiffCallbacks : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }
}
class CommentClickListener
