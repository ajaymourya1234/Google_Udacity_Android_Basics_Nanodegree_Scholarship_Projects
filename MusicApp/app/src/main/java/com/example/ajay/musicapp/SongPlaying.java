package com.example.ajay.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SongPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        String s = getIntent().getStringExtra("user");

        TextView songName = (TextView) findViewById(R.id.song_name1);
        songName.setText(s);
    }
}
