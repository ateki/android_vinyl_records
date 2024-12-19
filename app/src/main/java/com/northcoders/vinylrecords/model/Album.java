package com.northcoders.vinylrecords.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.vinylrecords.BR;

import java.time.LocalDate;

public class Album extends BaseObservable {

    private long id;
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

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
