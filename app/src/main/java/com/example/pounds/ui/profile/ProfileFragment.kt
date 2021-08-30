package com.example.pounds.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pounds.R
import com.example.pounds.databinding.ProfileFragmentBinding
import com.example.pounds.repository.ProfileRepository
import com.example.pounds.viewModels.ProfileViewModel

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: ProfileFragmentBinding
    private lateinit var profileRepository: ProfileRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater)
        init()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.imageButton.setOnClickListener {
            shareSuccess()

        }


    }
    private fun getShareIntent() : Intent {

        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.shareText))
            .setType("text/plain")
            .intent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


    private fun init(){
        val activity = requireNotNull(this.activity) {}
        profileRepository = ProfileRepository()
        viewModel = ViewModelProvider(this,
            ProfileViewModel.Factory(activity.application,profileRepository)
        ).get(ProfileViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

}