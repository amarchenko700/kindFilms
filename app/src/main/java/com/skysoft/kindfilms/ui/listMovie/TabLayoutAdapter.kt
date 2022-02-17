package com.skysoft.kindfilms.ui.listMovie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val tabTitles = arrayOf("Popular", "Top rated", "Uncoming")

    override fun createFragment(position: Int): Fragment {
        return TabMoviesFragment(position)
    }

    override fun getItemCount(): Int {
        return tabTitles.size
    }

    fun getPageTitle(position: Int): CharSequence? {
        // генерируем заголовок в зависимости от позиции
        return tabTitles[position]
    }
}