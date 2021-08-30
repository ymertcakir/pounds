package com.example.pounds.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pounds.adapters.AlbumAdapter
import com.example.pounds.adapters.AlbumClickListener
import com.example.pounds.databinding.AlbumsFragmentBinding
import com.example.pounds.model.Album
import com.example.pounds.repository.AlbumsRepository
import com.example.pounds.viewModels.AlbumsViewModel

class AlbumsFragment : Fragment() {


    companion object {
        fun newInstance() = AlbumsFragment()
    }

    private lateinit var viewModel: AlbumsViewModel
    private lateinit var binding: AlbumsFragmentBinding
    private lateinit var albumsRepository: AlbumsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AlbumsFragmentBinding.inflate(inflater)
        init()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.albumRcy.adapter= AlbumAdapter(AlbumClickListener { album ->
            findNavController().navigate(
                AlbumsFragmentDirections.actionAlbumsFragmentToAlbumDetailsFragment(albumId = album.id)
            )
        })






    }
    fun navigate(album:Album){}
    private fun init(){
        val activity = requireNotNull(this.activity){}
        albumsRepository = AlbumsRepository()
        viewModel = ViewModelProvider(this,
            AlbumsViewModel.Factory(activity.application,albumsRepository)
        ).get(AlbumsViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

}