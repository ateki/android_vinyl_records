package com.northcoders.vinylrecords.ui.mainactivity;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.model.AlbumRepository;

import java.util.List;


public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = "MainActivityViewModel";

    AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application ) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        Log.i(TAG, "getAllAlbums");
        return albumRepository.getMutableLiveData();
    }

    public void addAlbum(Album album) {
        Log.i(TAG, "addAlbum");
        albumRepository.addAlbum(album);
    }


    public void updateAlbum(long id, Album album) {
        albumRepository.updateAlbum(id, album);
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteAlbum(id);
    }
}
