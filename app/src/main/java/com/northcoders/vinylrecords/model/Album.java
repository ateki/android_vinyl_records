package com.northcoders.vinylrecords.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.vinylrecords.BR;

public class Album extends BaseObservable implements Parcelable {

    private Long id;
    private String title;
    private String description;
    private String artist;
    private String genre;
    private String releaseDate;
    private int releaseYear;
    private String coverImg;
    private int stockQuantity;

    public Album() {
    }

    public Album(long id) {
        this.id = id;
    }


    public Album(long id, String title, String description, String artist, String genre, String releaseDate, int releaseYear, String coverImg, int stockQuantity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.releaseYear = releaseYear;
        this.coverImg = coverImg;
        this.stockQuantity = stockQuantity;
    }

    /**
     * Reads from Parcel when its receive in the destination activity,
     * passing the object data stored in the Parcel into an Album object.
     * @param in
     */
    protected Album(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        title = in.readString();
        description = in.readString();
        artist = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        releaseYear = in.readInt();
        coverImg = in.readString();
        stockQuantity = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        // notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }
    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
    @Bindable
    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
        notifyPropertyChanged(BR.coverImg);
    }
    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * When destination activity is launched, this method will write the object to a Parcel object
     * @param dest The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     * May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(artist);
        dest.writeString(genre);
        dest.writeString(releaseDate);
        dest.writeInt(releaseYear);
        dest.writeString(coverImg);
        dest.writeInt(stockQuantity);
    }
}
