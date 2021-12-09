package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentTabMoviesBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo
import com.skysoft.kindfilms.ui.main.MainActivity
import com.skysoft.kindfilms.ui.main.MainPresenter

class TabMoviesFragment() : Fragment() {

    private lateinit var binding: FragmentTabMoviesBinding
    private lateinit var adapter: ListMovieAdapter
    private var positionTabLayout: Int = 0
    private val KEY_POSITION_TAB = "KEY_POSITION_TAB"
    private lateinit var presenter: MainPresenter

    constructor (position: Int) : this() {
        this.positionTabLayout = position
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_POSITION_TAB, positionTabLayout)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (savedInstanceState != null) {
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
        presenter = (requireActivity() as MainActivity).getPresenter()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        var gridLayoutManager = GridLayoutManager(context, 2)
        binding.let {
            it.recyclerViewListMovie.layoutManager = linearLayoutManager
//            it.recyclerViewListMovie.layoutManager = gridLayoutManager
            it.recyclerViewListMovie.adapter = adapter
        }
        adapter.setClickListener(
            object : ListMovieAdapter.OnItemClickListener {
                override fun onItemClick(item: Movie?, position: Int) {
                    presenter.onMovieClick(item!!)
                }
            }
        )
        adapter.setContextClickListener(
            object : ListMovieAdapter.OnItemContextClickListener {
                override fun onItemContextClick(v: View?, item: Movie?, position: Int): Boolean {
                    v?.showContextMenu()
                    if (item != null) {
                        presenter.setClickedMovie(item)
                    }
                    return true
                }
            }
        )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.movies_list_context_menu, menu)
    }

    private fun setAdapterData() {
        when (positionTabLayout) {
            0 -> adapter.setData(MoviesRepo.getPopularMovies() as List<Movie>)
            1 -> adapter.setData(MoviesRepo.getTopRatedMovies() as List<Movie>)
            2 -> adapter.setData(MoviesRepo.getUpcomingMovies() as List<Movie>)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_note) {
            presenter.onContextMovieClick()
            return true
        }
        return super.onContextItemSelected(item)
    }
}