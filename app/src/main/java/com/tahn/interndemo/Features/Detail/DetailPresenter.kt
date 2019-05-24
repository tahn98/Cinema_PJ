package com.tahn.interndemo.Features.Detail

import com.tahn.interndemo.Model.Movie

class DetailPresenter(val view : InterfaceDetailMovie.View) : InterfaceDetailMovie.Presenter{
    init {
        view.setPresenter(this)
    }

    override fun getDetail(movie: Movie?) {
        view.setDetail(movie)
    }
}