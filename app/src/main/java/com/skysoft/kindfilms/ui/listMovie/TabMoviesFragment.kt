package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentTabMoviesBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo

class TabMoviesFragment(position: Int) : Fragment() {

    private lateinit var binding: FragmentTabMoviesBinding
    private lateinit var adapter: ListMovieAdapter
    private lateinit var clickedMovie: Movie
    private var positionTabLayout: Int = 0
    private val KEY_POSITION_TAB = "KEY_POSITION_TAB"

    constructor (): this(0){

    }

    init {
        positionTabLayout = position
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_POSITION_TAB, positionTabLayout)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(savedInstanceState != null){
            positionTabLayout = savedInstanceState.getInt(KEY_POSITION_TAB)
        }
        binding = FragmentTabMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerForContextMenu(view)
        adapter = ListMovieAdapter()
        initRecyclerView()
        setAdapterData()
    }

    private fun initRecyclerView() {
        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        var gridLayoutManager = GridLayoutManager(context, 2)
        binding.let {
            it.recyclerViewListMovie.layoutManager = linearLayoutManager
//            it.recyclerViewListMovie.layoutManager = gridLayoutManager
            it.recyclerViewListMovie.adapter = adapter
        }
        adapter.setClickListener(
            object : ListMovieAdapter.onItemClickListener {
                override fun onItemClick(item: Movie?, position: Int) {
                    Toast.makeText(context, item?.getTitle(), Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setContextClickListener(
            object : ListMovieAdapter.onItemContextClickListener {
                override fun onItemContextClick(v: View?, item: Movie?, position: Int): Boolean {
                    v?.showContextMenu()
                    if (item != null) {
                        clickedMovie = item
                    }
                    return true
                }
            }
        )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.movies_list_context_menu, menu)
    }

    fun setAdapterData() {
        if (positionTabLayout == 0) {
            adapter.setData(MoviesRepo.getPopularMovies() as List<Movie>)
        } else if (positionTabLayout == 1) {
            adapter.setData(MoviesRepo.getTopRatedMovies() as List<Movie>)
        } else if (positionTabLayout == 2) {
            adapter.setData(MoviesRepo.getUpcomingMovies() as List<Movie>)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_note) {
            Toast.makeText(context, "Удаляем " + clickedMovie.getTitle(), Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onContextItemSelected(item)
    }
}