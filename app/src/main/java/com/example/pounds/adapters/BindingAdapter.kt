package com.example.pounds.adapters


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pounds.R
import com.example.pounds.model.Album
import com.example.pounds.model.Comment
import com.example.pounds.model.Photo
import com.squareup.picasso.Picasso


@BindingAdapter("imgUrl")
fun setImage(imageView: ImageView, url: String?) {
    url?.let {


        Glide.with(imageView.context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground)
            )
            .into(imageView)
    }
}
@BindingAdapter("imgUrlPicasso")
fun setImageWhitPicasso(imageView: ImageView, url: String?) {
    url?.let {


        Picasso.get().load(url)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
@BindingAdapter("submitNewList")
fun setRecyclerViewItem(recyclerView: RecyclerView, items: List<Any>?) {

    if (items != null) {
        if (items.isNotEmpty()) {

            items.let {
                when (it.first()) {
                    is Comment -> {
                        val adapter: CommentAdapter = recyclerView.adapter as CommentAdapter
                        adapter.submitList(items as List<Comment>)
                    }
                    is Photo -> {
                        val adapter = recyclerView.adapter as PhotoAdapter
                        adapter.submitList(items as List<Photo>)
                    }
                    is Album -> {
                        val adapter = recyclerView.adapter as AlbumAdapter
                        adapter.submitList(items as List<Album>)
                    }
                }
            }
        }
    }

}

