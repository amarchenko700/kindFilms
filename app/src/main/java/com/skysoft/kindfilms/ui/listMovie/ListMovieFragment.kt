package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentListMovieBinding

class ListMovieFragment : Fragment() {

    private lateinit var binding: FragmentListMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adap = TabLayoutAdapter(requireActivity())

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewpager)

        viewPager.adapter = adap

        val tabLayout: TabLayout = requireActivity().findViewById<TabLayout>(R.id.sliding_tabs)
        val tabLayoutMediator = TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position -> tab.text = adap.getPageTitle(position) }
        tabLayoutMediator.attach()
    }
}