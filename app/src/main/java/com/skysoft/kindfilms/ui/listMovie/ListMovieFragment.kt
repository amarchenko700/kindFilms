package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.*
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentListMovieBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo
import com.skysoft.kindfilms.ui.SampleFragmentPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy


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

        val adap = TabAdap(requireActivity())

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewpager)
//        viewPager.adapter = SampleFragmentPagerAdapter(requireActivity().supportFragmentManager, requireContext())

        viewPager.adapter = adap

//        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.sliding_tabs)
//        tabLayout.setupWithViewPager(viewPager)

        val tabLayout: TabLayout = requireActivity().findViewById<TabLayout>(R.id.sliding_tabs)
        val tabLayoutMediator = TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position -> tab.text = "Страница " + (position + 1) }
        tabLayoutMediator.attach()
    }
}