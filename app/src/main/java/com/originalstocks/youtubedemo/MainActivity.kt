package com.originalstocks.youtubedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {
    private val TAG = "MainActivity"
    /*Youtube*/
    private lateinit var mYoutubePlayerInitListener: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Initialising Youtube player Listener */
        mYoutubePlayerInitListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                youTubePlayer: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                /*if (!wasRestored) {

                }*/
                Log.i(TAG, "onInitializationSuccess: Done with Initialization")
                youTubePlayer?.loadVideo("2AQCCr6_PP4")

            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Log.e(TAG, "onInitializationFailure: some error occurred while Initialization")
            }
        }

        play_video_button.setOnClickListener {
            youtube_player_view.initialize(YoutubeConfig.apiKey, mYoutubePlayerInitListener)
        }

    }
}