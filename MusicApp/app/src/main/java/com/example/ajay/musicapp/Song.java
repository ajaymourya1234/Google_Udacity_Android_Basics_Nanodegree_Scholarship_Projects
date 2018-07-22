package com.example.ajay.musicapp;

/**
 * Created by Dell on 20-07-2018.
 */

public class Song {

    // Drawable resource ID
    private int mImageResourceId;

    // Name of the Android version (e.g. Gingerbread, Honeycomb, Ice Cream Sandwich)
    private String mSongName;

    // Android version number (e.g. 2.3-2.7, 3.0-3.2.6, 4.0-4.0.4)
    private String mSongArtist;

    /*
    * Create a new AndroidFlavor object.
    *
    * @param vName is the name of the Android version (e.g. Gingerbread)
    * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public Song(int imageResourceId, String vSongName, String vSongArtist) {
        mImageResourceId = imageResourceId;
        mSongName = vSongName;
        mSongArtist = vSongArtist;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the name of the Android version
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the Android version number
     */
    public String getSongArtist() {
        return mSongArtist;
    }


}
