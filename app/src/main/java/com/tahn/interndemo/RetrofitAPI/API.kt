package com.tahn.retrofit2demo.RetrofitAPI

import com.tahn.interndemo.Model.MoviesResponse
import com.tahn.interndemo.Model.Videos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    //urls
    @GET("movie/now_playing")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>

    @GET("movie/{id}/trailers")
    fun getVideoTrailer(@Path("id") movieId: Int?, @Query("api_key") apiKey: String): Call<Videos>
}