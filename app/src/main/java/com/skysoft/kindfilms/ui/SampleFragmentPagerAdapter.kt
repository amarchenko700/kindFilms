package com.skysoft.kindfilms.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment
import com.skysoft.kindfilms.ui.listMovie.TabMoviesFragment

class SampleFragmentPagerAdapter(fm: FragmentManager?, private val context: Context) :
    FragmentPagerAdapter(
        fm!!
    ) {

    val PAGE_COUNT = 3
    private val tabTitles = arrayOf("Popular", "Tab2", "Tab3")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        //return PageFragment.newInstance(position + 1);
        return TabMoviesFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // генерируем заголовок в зависимости от позиции
        return tabTitles[position]
    }

}