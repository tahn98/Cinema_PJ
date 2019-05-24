package com.tahn.interndemo.Features.Detail

import com.tahn.interndemo.Model.Movie

interface InterfaceDetailMovie {
    interface View{
        fun setPresenter(presenter: Presenter)
        fun setDetail(movie: Movie?)
    }

    interface Presenter{
        fun getDetail(movie: Movie?)
    }
}