package com.skysoft.kindfilms.ui.bottomNavigationFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentAboutBinding
import com.skysoft.kindfilms.domain.Country
import com.skysoft.kindfilms.domain.MoviesRepo

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    private val newRepo: MoviesRepo = MoviesRepo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.extraButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val country = Country("iso2021", "Russia")
                val newCountry = country.copy("")
            }
        })
    }
}