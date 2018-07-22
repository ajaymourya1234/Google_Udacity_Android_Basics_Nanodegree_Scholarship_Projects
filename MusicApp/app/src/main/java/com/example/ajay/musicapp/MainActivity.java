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

    private LinearLayout linearLayoutParent,linearLayoutChild;
    private ImageView image;
    private TextView songName,songArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a ArrayList of Song objects
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 1", "Artist 1"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 2", "Artist 2"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 3", "Artist 3"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 4", "Artist 4"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 5", "Artist 5"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 6", "Artist 6"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 7", "Artist 7"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 8", "Artist 8"));
        songs.add(new Song(R.drawable.audio_jack, "Tap to play song 1", "Artist 9"));


        SongAdapter adapter = new SongAdapter(this, songs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(adapter);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Getting the Container Layout of the ListView
                linearLayoutParent = (LinearLayout) view;

                // Getting the inner Linear Layout
                image = (ImageView) linearLayoutParent.getChildAt(0);

                // Getting the inner Linear Layout
                linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);

                // Getting the Country TextView
                songName = (TextView) linearLayoutChild.getChildAt(0);

                // Getting the Country TextView
                songArtist = (TextView) linearLayoutChild.getChildAt(1);

                Toast.makeText(getBaseContext(), songArtist.getText().toString(), Toast.LENGTH_SHORT).show();



            }
        };
        // Setting the item click listener for the listview
        listView.setOnItemClickListener(itemClickListener);

        /* Intent _intent = new Intent(this, SongPlaying.class);
        Bitmap _bitmap; // your bitmap
        ByteArrayOutputStream _bs = new ByteArrayOutputStream();
        _bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
        _intent.putExtra("byteArray", _bs.toByteArray());
        startActivity(i);*/

    }

}

