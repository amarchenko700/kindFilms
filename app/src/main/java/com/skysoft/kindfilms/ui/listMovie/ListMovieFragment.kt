package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.databinding.FragmentListMovieBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo

class ListMovieFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentListMovieBinding
    private lateinit var adapter: ListMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListMovieBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListMovieAdapter()
        initRecyclerView()
        setAdapterData()
    }

    private fun initRecyclerView() {
        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.HORIZONTAL;
        binding?.let {
            it.recyclerViewListMovie.layoutManager = linearLayoutManager
            it.recyclerViewListMovie.adapter = adapter
        }
        adapter.setClickListener (
            object : ListMovieAdapter.onItemClickListener {
                override fun onItemClick(item: Movie?, position: Int) {
                    Toast.makeText(context, item?.getTitle(), Toast.LENGTH_SHORT).show()
                }
            }
        )


    }

    fun setAdapterData() {
        adapter.setData(MoviesRepo.getMovies() as List<Movie>)
    }
}