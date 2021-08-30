package com.example.pounds.ui.albumDetails


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.pounds.R
import com.example.pounds.adapters.ViewPagerAdapter
import com.example.pounds.repository.AlbumDetailsRepository
import com.example.pounds.viewModels.AlbumDetailsViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class AlbumDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = AlbumDetailsFragment()
    }

    private lateinit var viewModel: AlbumDetailsViewModel

    private lateinit var albumDetailsRepository: AlbumDetailsRepository
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.album_details_fragment, container, false)
        init()

        val fragmentList = arrayListOf<Fragment>(
            PhotosFragment(),
            CommentsFragment(),
        )
        val args=Bundle().apply {

            putInt("albumId", viewModel.albumId)
        }
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle,
            args
        )
        viewPager2 =view.findViewById(R.id.viewPager)
        viewPager2.adapter=adapter
        tabLayout = view.findViewById(R.id.tablayout)
        val tabNames = arrayOf("Photos","Comments")
        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            tab.text = tabNames[position]
        }.attach()





        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)




        // TODO: Use the ViewModel
    }

    private fun initViewPager(){

    }
    private fun init(){
        albumDetailsRepository= AlbumDetailsRepository()
        val activity = requireNotNull(this.activity) {}
        val arguments = AlbumDetailsFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(this,
            AlbumDetailsViewModel.Factory(arguments.albumId,activity.application, albumDetailsRepository)
        ).get(AlbumDetailsViewModel::class.java)

    }

}