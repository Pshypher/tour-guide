package com.example.ud839_tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private int mThumbnailImageResourceId;
    private int mImageResourceId;
    private String mName;
    private String mLocation;
    private int mDescriptionId;
    private String mContact;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mThumbnailImageResourceId);
        dest.writeInt(mImageResourceId);
        dest.writeString(mName);
        dest.writeString(mLocation);
        dest.writeInt(mDescriptionId);
        dest.writeString(mContact);
    }

    private Place(Parcel source) {
        mThumbnailImageResourceId = source.readInt();
        mImageResourceId = source.readInt();
        mName = source.readString();
        mLocation = source.readString();
        mDescriptionId = source.readInt();
        mContact = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Place> CREATOR
            = new Parcelable.Creator<Place>() {

        @Override
        public Place createFromParcel(Parcel source) {
            return new Place(source);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public Place(int thumbnail, int img, String name, String location, int description) {
        mThumbnailImageResourceId = thumbnail;
        mImageResourceId = img;
        mName = name;
        mLocation = location;
        mDescriptionId = description;
        mContact = null;
    }

    public Place(int thumbnail, int img, String name, String location, int description,
                 String contact) {
        this(thumbnail, img, name, location, description);
        mContact = contact;
    }

    public int getThumbnailResourceId() {
        return mThumbnailImageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getDescriptionId() {
        return mDescriptionId;
    }

    public String getContact() {
        return mContact;
    }
}
