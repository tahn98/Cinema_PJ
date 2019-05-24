package com.tahn.interndemo.Model
import com.google.gson.annotations.SerializedName

class MoviesResponse{
    @SerializedName("results")
    val results: MutableList<Movie>? = null
}