package com.tahn.interndemo.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Videos{
    @SerializedName("id")
    @Expose
    var id : Int? = null
    @SerializedName("youtube")
    @Expose
    var youtube : List<Video>? = null

    class Video{
        @SerializedName("source")
        var source : String? = null
    }
}