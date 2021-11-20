package com.skysoft.kindfilms.ui.listMovie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentListMovieBinding
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.domain.MoviesRepo

class ListMovieFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentListMovieBinding
    private lateinit var adapter: ListMovieAdapter
    private lateinit var clickedMovie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListMovieBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerForContextMenu(view)
        adapter = ListMovieAdapter()
        initRecyclerView()
        setAdapterData()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.movies_list_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_note) {
            Toast.makeText(context, "Удаляем " + clickedMovie.getTitle(), Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onContextItemSelected(item)
    }

    private fun initRecyclerView() {
        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.HORIZONTAL;
        binding?.let {
            it.recyclerViewListMovie.layoutManager = linearLayoutManager
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

    fun setAdapterData() {
        adapter.setData(MoviesRepo.getMovies() as List<Movie>)
    }
}