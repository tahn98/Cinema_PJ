package com.tahn.interndemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tahn.interndemo.Features.Detail.DetailPresenter
import com.tahn.interndemo.Features.Detail.InterfaceDetailMovie
import com.tahn.interndemo.Model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), InterfaceDetailMovie.View{

    private var presenter: InterfaceDetailMovie.Presenter? = null
    private var movie_id: String? = null

    init {
        presenter = DetailPresenter(this)
    }

    override fun setPresenter(presenter: InterfaceDetailMovie.Presenter) {
        this.presenter = presenter
    }

    override fun setDetail(movie: Movie?) {
        movie_id = movie?.id

        dt_txtName.text = movie?.title
        dt_txtDesc.text = movie?.overview
        dt_rlday.text = movie?.release_date

        dt_ratingBar.rating = movie?.vote_average!!.toFloat()
        Glide.with(dt_imgView).load("https://image.tmdb.org/t/p/w500" + "${movie?.backdrop_path}")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(90)))
            .into(dt_imgView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent?.extras?.getSerializable("EXTRA_MOVIE") as? Movie
        presenter?.getDetail(movie)

        dt_btnTrailer.setOnClickListener{
            Toast.makeText(this, "We don't have this feature :)", Toast.LENGTH_LONG).show()
        }

        dt_imgPlay.setOnClickListener {
            val ytIntent = Intent(this, YoutubeViewActivity::class.java)
            ytIntent.putExtra("EXTRA_YOUTUBE", movie_id)
            startActivity(ytIntent)
        }
    }
}
