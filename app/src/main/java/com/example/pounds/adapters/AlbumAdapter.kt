    package com.example.pounds.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pounds.databinding.ListItemAlbumBinding
import com.example.pounds.model.Album

class AlbumAdapter(private val clickListener: AlbumClickListener):androidx.recyclerview.widget.ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(
    AlbumDiffCallbacks()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder.from(parent)
    }


    class AlbumViewHolder(private val itemBinding:ListItemAlbumBinding):RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Album,clickListener: AlbumClickListener){
            itemBinding.listItemAlbum = data
            itemBinding.albumClickListener =clickListener
            itemBinding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup):AlbumViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAlbumBinding.inflate(layoutInflater, parent,false)
                return AlbumViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}

class AlbumDiffCallbacks : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}


class AlbumClickListener(val detailsClickListener: (album:Album)-> Unit){
    fun albumDetails(album: Album) = detailsClickListener(album)

}