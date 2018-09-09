package com.example.ajay.musicapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a ArrayList of Song objects
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_1), getString(R.string.artist_1)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_2), getString(R.string.artist_2)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_3), getString(R.string.artist_3)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_4), getString(R.string.artist_4)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_5), getString(R.string.artist_5)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_6), getString(R.string.artist_6)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_7), getString(R.string.artist_7)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_8), getString(R.string.artist_8)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_9), getString(R.string.artist_9)));
        songs.add(new Song(R.drawable.audio_jack, getString(R.string.song_name_10), getString(R.string.artist_10)));



        final SongAdapter adapter = new SongAdapter(this, songs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) adapter.getItem(position);
                Intent nowPlaying = new Intent(getApplicationContext(), SongPlaying.class);
                nowPlaying.putExtra("KEY_SONG", item.getSongName());
                //nowPlaying.putExtra(KEY_ALBUM, item.getAlbum());
                nowPlaying.putExtra("KEY_ARTIST", item.getSongArtist());
                startActivity(nowPlaying);
            }
        });
    }

}

