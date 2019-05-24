package com.tahn.interndemo.Features.Main

import com.tahn.interndemo.Model.MoviesResponse
import com.tahn.retrofit2demo.RetrofitAPI.API
import com.tahn.retrofit2demo.RetrofitAPI.ClientRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedPresenter(val view : InterfaceMovie.View) :
    InterfaceMovie.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun getTopRated() {
        var client = ClientRetrofit()
        var api = client.getClient().create(API::class.java)
        var call = api.getTopRatedMovies("a07e22bc18f5cb106bfe4cc1f83ad8ed")

        call.enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                view.onFailure(t)
            }

            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                view.onResponse(response.body()?.results)
            }
        })
    }
}