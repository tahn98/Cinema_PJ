package com.tahn.interndemo.Features.Play

import com.tahn.interndemo.Model.Videos
import com.tahn.retrofit2demo.RetrofitAPI.API
import com.tahn.retrofit2demo.RetrofitAPI.ClientRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayPresenter(val view : InterfacePlay.View) : InterfacePlay.Presenter{
    override fun getTrailer(id: String?) {

        var client = ClientRetrofit()
        var api = client.getClient().create(API::class.java)
        var call = api.getVideoTrailer(id?.toInt(), "a07e22bc18f5cb106bfe4cc1f83ad8ed")

        call.enqueue(object : Callback<Videos> {
            override fun onFailure(call: Call<Videos>, t: Throwable) {

            }

            override fun onResponse(call: Call<Videos>, response: Response<Videos>) {
//                val source_key = response.body()?.results?.get(0)?.key.toString()
                val sourceKey = response.body()?.youtube?.get(0)?.source.toString()
                view.setTrailer(sourceKey)
            }
        })
    }
}