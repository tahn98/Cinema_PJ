package com.tahn.interndemo.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie : Serializable{
    @SerializedName("id")
    val id : String = ""

    @SerializedName("title")
    val title : String = ""

    @SerializedName("overview")
    val overview : String = ""

    @SerializedName("poster_path")
    val poster : String = ""

    @SerializedName("release_date")
    val release_date = ""

    @SerializedName("vote_average")
    val vote_average = ""

    @SerializedName("backdrop_path")
    val backdrop_path = ""
}