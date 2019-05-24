package com.tahn.interndemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.tahn.interndemo.Features.Adapter.MovieAdapter
import com.tahn.interndemo.Features.Main.InterfaceMovie
import com.tahn.interndemo.Features.Main.TopRatedPresenter
import com.tahn.interndemo.Model.Movie
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), InterfaceMovie.View{


    private var presenter: InterfaceMovie.Presenter? = null
    private var movies : MutableList<Movie>? = ArrayList()

    init {
        presenter = TopRatedPresenter(this)
    }

    private fun movieItemClicked(movie : Movie?){
        val showDetailActivity = Intent(this, DetailActivity::class.java)
        showDetailActivity.putExtra("EXTRA_MOVIE", movie)
        startActivity(showDetailActivity)
    }

    override fun setPresenter(presenter: InterfaceMovie.Presenter) {
        this.presenter = presenter
    }

    override fun onResponse(movies: MutableList<Movie>?) {
        this.movies = movies

        //arg1 : generate data
        //art2 : item click handle function
        recycleView.adapter = MovieAdapter(movies as ArrayList<Movie>, {movie : Movie? -> movieItemClicked(movie)})
    }

    override fun onFailure(t: Throwable) {
        //raise sth err in here
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        presenter!!.getTopRated()

        swipeContainer.setOnRefreshListener {
            presenter!!.getTopRated()
            swipeContainer.isRefreshing = false
        }
    }
}
