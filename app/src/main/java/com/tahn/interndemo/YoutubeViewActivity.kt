package com.tahn.interndemo

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.tahn.interndemo.Features.Play.InterfacePlay
import com.tahn.interndemo.Features.Play.PlayPresenter
import kotlinx.android.synthetic.main.activity_youtube_view.*


class YoutubeViewActivity : YouTubeBaseActivity(), InterfacePlay.View{

    val YT_API_KEY = "AIzaSyDwwdvNUHzfFt7Y6L-TA8I_7Cc8y4wKa9M"

    private var presenter : InterfacePlay.Presenter? = null
    private var movie_id : String? = null

    init {
        presenter = PlayPresenter(this)
    }

    override fun setPresenter(presenter: InterfacePlay.Presenter) {
        this.presenter = presenter
    }

    override fun setTrailer(source: String) {
        yt_player.initialize(YT_API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider,
                    youTubePlayer: YouTubePlayer, b: Boolean
                ) {
                    // do any work here to cue video, play video, etc.
                    // or to play immediately

                    youTubePlayer.cueVideo(source)
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider,
                    youTubeInitializationResult: YouTubeInitializationResult
                ) {
                    Toast.makeText(this@YoutubeViewActivity, "Youtube Failed!", Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_view)

        movie_id = intent?.getStringExtra("EXTRA_YOUTUBE")
        presenter!!.getTrailer(movie_id)
    }
}
