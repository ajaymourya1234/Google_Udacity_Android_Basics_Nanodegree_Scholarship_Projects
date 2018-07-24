package com.example.ajay.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        String playingSong = "";
        String playingArtist = "";
        String playingAlbum = "";

        Intent intent = getIntent();
        if (null != intent) {
            playingSong = intent.getStringExtra("KEY_SONG");
            playingArtist = intent.getStringExtra("KEY_ARTIST");
            playingAlbum = intent.getStringExtra("KEY_ALBUM");

            TextView playingSongText = (TextView) findViewById(R.id.now_playing_song);
            playingSongText.setText(playingSong);

            TextView songArtistText = (TextView) findViewById(R.id.playing_song_artist);
            songArtistText.setText(playingArtist);

            final ImageView playButton = (ImageView) findViewById(R.id.icon_play);

            // Sets tag to switch ImageView between play and pause buttons when clicked.
            // Reference: https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
            playButton.setTag(1);
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (playButton.getTag().equals(1)) {
                        playButton.setImageResource(R.drawable.ic_pause_black_48dp);
                        playButton.setTag(2);
                    } else {
                        playButton.setImageResource(R.drawable.ic_play_arrow_black_48dp);
                        playButton.setTag(1);
                    }

                }
            });
            // End reference
        }
    }
}
