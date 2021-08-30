package com.example.pounds.ui.albumDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pounds.adapters.CommentAdapter
import com.example.pounds.adapters.CommentClickListener
import com.example.pounds.databinding.CommentsFragmentBinding
import com.example.pounds.repository.AlbumDetailsRepository
import com.example.pounds.viewModels.CommentsViewModel

class CommentsFragment : Fragment() {

    companion object {
        fun newInstance() = CommentsFragment()
    }

    private lateinit var viewModel: CommentsViewModel
    private lateinit var binding: CommentsFragmentBinding
    private lateinit var albumDetailsRepository: AlbumDetailsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= CommentsFragmentBinding.inflate(inflater)
        init()
        val albumId =requireArguments().get("albumId") as Int
        viewModel.albumIdFromBundlee(albumId)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rcyComennt.adapter= CommentAdapter(CommentClickListener())


    }


    private fun init(){
        albumDetailsRepository= AlbumDetailsRepository()
        val activity = requireNotNull(this.activity) {}
        viewModel = ViewModelProvider(this, CommentsViewModel.Factory(activity.application, albumDetailsRepository))
            .get(CommentsViewModel::class.java)
        binding.viewModel= viewModel
        binding.lifecycleOwner= this


    }



}