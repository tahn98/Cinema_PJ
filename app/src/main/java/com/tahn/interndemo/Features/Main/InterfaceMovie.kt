package com.tahn.interndemo.Features.Main
import com.tahn.interndemo.Model.Movie

interface InterfaceMovie{

    interface View{
        fun setPresenter(presenter : Presenter)

        fun onResponse(movies : MutableList<Movie>?)

        fun onFailure(t : Throwable)
    }

    interface Presenter{
        fun getTopRated()
    }

}
