package com.tahn.interndemo.Features.Play

import com.tahn.interndemo.Model.Movie

interface InterfacePlay{
    interface View{
        fun setPresenter(presenter: Presenter)
        fun setTrailer(source: String)
    }

    interface Presenter{
        fun getTrailer(id : String?)
    }
}