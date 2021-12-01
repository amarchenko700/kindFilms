package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentListMovieBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo
import com.skysoft.kindfilms.ui.SampleFragmentPagerAdapter

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

        val viewPager = requireActivity().findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = SampleFragmentPagerAdapter(requireActivity().supportFragmentManager, requireContext())

        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.sliding_tabs)
        tabLayout.setupWithViewPager(viewPager)

    }
}