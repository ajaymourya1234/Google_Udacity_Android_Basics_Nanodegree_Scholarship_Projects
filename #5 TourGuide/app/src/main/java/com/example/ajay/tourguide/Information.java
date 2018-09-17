package com.example.ajay.tourguide;

public class Information {

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Place Name
     */
    private String mPlaceName;
    /**
     * Place Description
     */
    private String mPlaceDescription;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Information(String placeName, String placeDescription, int imageResourceId) {
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
        mImageResourceId = imageResourceId;
    }

    public String getmPlaceName() {

        return mPlaceName;
    }

    public String getmPlaceDescription() {

        return mPlaceDescription;
    }

    public int getImageResourceId() {

        return mImageResourceId;
    }

    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
