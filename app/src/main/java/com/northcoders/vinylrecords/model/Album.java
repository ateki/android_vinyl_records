package com.northcoders.vinylrecords.model;

import java.time.LocalDate;

public class Album {

    private long id;
    private String title;
    private String description;
    private String artist;
    private String genre;
    private LocalDate releaseDate;
    private int releaseYear;
    private String coverImg;
    private int stockQuantity;

    public Album(long id) {
        this.id = id;
    }

    public Album(long id, String title, String description, String artist, String genre, LocalDate releaseDate, int releaseYear, String coverImg, int stockQuantity) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
