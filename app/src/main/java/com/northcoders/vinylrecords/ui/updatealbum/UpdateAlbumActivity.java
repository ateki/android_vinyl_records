package com.northcoders.vinylrecords.ui.updatealbum;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.vinylrecords.R;
import com.northcoders.vinylrecords.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    private static final String TAG = "UpdateAlbumActivity";
    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandler handler;
    private Album album;

    private final static String ALBUM_KEY = "album";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate called");
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);

        // Setup data binding
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        // Setup view point
        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        // Setup handler
        handler = new UpdateAlbumClickHandler(album, this, viewModel);

        // Bind album data to view
        binding.setAlbum(album);

        // Bind click handler to view
        binding.setClickHandler(handler);
    }
}