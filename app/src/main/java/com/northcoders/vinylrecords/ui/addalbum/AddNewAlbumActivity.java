package com.northcoders.vinylrecords.ui.addalbum;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.vinylrecords.R;
import com.northcoders.vinylrecords.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    private static final String TAG = "AddNewAlbumActivity";

    private ActivityAddNewAlbumBinding binding;
    private AddAlbumClickHandler handler;
    private Album album;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate called");
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_album
        );

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new AddAlbumClickHandler(album, this, viewModel);

        binding.setAlbum(album);
        
        binding.setClickHandler(handler);


    }
}