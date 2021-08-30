package com.example.pounds.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pounds.databinding.PhotoListItemBinding
import com.example.pounds.model.Photo

class PhotoAdapter(private val clickListener: PhotoClickListener):androidx.recyclerview.widget.ListAdapter<Photo,PhotoAdapter.PhotoViewHolder>(
    PhotoDiffCallbacks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.from(parent)
    }


    class PhotoViewHolder(private val itemBinding: PhotoListItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data:Photo, clickListener: PhotoClickListener){
            itemBinding.photoListItem= data
            itemBinding.photoClickListeners= clickListener
            itemBinding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup):PhotoViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PhotoListItemBinding.inflate(layoutInflater, parent, false)
                return PhotoViewHolder(binding)
            }
        }

    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }


}

class PhotoDiffCallbacks : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}
class PhotoClickListener(){

}