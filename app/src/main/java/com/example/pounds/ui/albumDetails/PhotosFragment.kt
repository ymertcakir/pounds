package com.example.pounds.ui.albumDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pounds.adapters.PhotoAdapter
import com.example.pounds.adapters.PhotoClickListener
import com.example.pounds.databinding.PhotosFragmentBinding
import com.example.pounds.repository.AlbumDetailsRepository
import com.example.pounds.viewModels.PhotosViewModel

class PhotosFragment : Fragment() {



    private lateinit var viewModel: PhotosViewModel
    private lateinit var binding: PhotosFragmentBinding
    private lateinit var albumDetailsRepository: AlbumDetailsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= PhotosFragmentBinding.inflate(inflater)
        init()
        val albumId =requireArguments().get("albumId")
        viewModel.albumIdFromBundle(albumId as Int)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val manager = GridLayoutManager(activity, 2)
        binding.rcyPhoto.layoutManager= manager
        binding.rcyPhoto.adapter= PhotoAdapter(PhotoClickListener())





    }


    private fun init(){
        albumDetailsRepository= AlbumDetailsRepository()
        val activity = requireNotNull(this.activity) {}
        viewModel = ViewModelProvider(this,
            PhotosViewModel.Factory(activity.application, albumDetailsRepository)
        ).get(PhotosViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner = this
    }

}