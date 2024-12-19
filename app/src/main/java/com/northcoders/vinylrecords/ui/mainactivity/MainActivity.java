package com.northcoders.vinylrecords.ui.mainactivity;

import android.app.Application;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.vinylrecords.R;
import com.northcoders.vinylrecords.databinding.ActivityMainBinding;
import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.model.AlbumRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecylerViewInterface {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;  // List??
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    private MainActivityClickHandler handler;


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


        getAllAlbums();


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

//        Application application = new Application();
//        AlbumRepository albumRepository = new AlbumRepository(application);
//
//        albumRepository.getMutableLiveData();
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
        albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        albumAdapter.notifyDataSetChanged();
    }

    public void onItemClick(int position) {

    }
}