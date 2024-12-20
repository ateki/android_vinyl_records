package com.northcoders.vinylrecords.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
//import android.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.vinylrecords.R;
import com.northcoders.vinylrecords.databinding.ActivityMainBinding;
import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private static final String TAG = "MainActivity";
    private ArrayList<Album> albumList;  // List??

    private ArrayList<Album> filteredAlbumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    private MainActivityClickHandler handler;
    
    // UI Widgets

    private RecyclerView recyclerView;
    private SearchView searchView;
    

    private final static String ALBUM_KEY = "album";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new MainActivityClickHandler(this);

        binding.setClickHandler(handler);

        // Setup album list recycler view and search view
        // TODO: Rename  setupAlbumRecyclerView
        getAllAlbums();

        setupSearchView();

    }


    private void setupSearchView() {
        // Clear search view
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAlbumList(newText);
                return true;
            }
        });
    }

    private void filterAlbumList(String newText) {
        Log.i(TAG, "filterAlbumList searchText = " +newText);
        filteredAlbumList = new ArrayList<>();

        // Search for albums with newText somewhere in the title
        for (Album album : albumList) {
            if (album.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                Log.i(TAG, "filteredAlbumList : adding album " + album.getTitle());
                filteredAlbumList.add(album);
            }
        }

        if (filteredAlbumList.isEmpty()) {
            Toast.makeText(this, "No albums found!", Toast.LENGTH_SHORT).show();
        } else {
            Log.i(TAG, "filterAlbumList::filteredAlbumList filteredAlbumList= " +filteredAlbumList);
            albumAdapter.setFilteredAlbumList(filteredAlbumList);
        }
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                // albums refers to the variable name of your List of Album objects
                // albumsFromLiveData is cast to this type
                albumList = (ArrayList<Album>) albumsFromLiveData;

                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.recyclerview;  // Needed android:id="@+id/recyclerview" in activity_main.xml else compile error or recyclerview
        albumAdapter = new AlbumAdapter(albumList, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        albumAdapter.notifyDataSetChanged();
        // TODO Use more specific change events rather than notifyDataSetChanged,
        //  so that LayoutManager does not need to rebind everything and layout all visible views
    }

    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, UpdateAlbumActivity.class);

        if (filteredAlbumList == null || filteredAlbumList.isEmpty()) {
            // Display all albums
            intent.putExtra(ALBUM_KEY, albumList.get(position));
        } else {
            // Display filtered albums only
            intent.putExtra(ALBUM_KEY, filteredAlbumList.get(position));
        }

        startActivity(intent);
    }
}