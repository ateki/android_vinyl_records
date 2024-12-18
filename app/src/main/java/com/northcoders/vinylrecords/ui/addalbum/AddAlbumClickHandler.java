package com.northcoders.vinylrecords.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivity;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandler {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAlbumClickHandler(Album ablum, Context context, MainActivityViewModel viewModel) {
        this.album = ablum;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onAddBtnClickec(View view) {
        // condition check whether fields are empty
        // TODO: Whilst debugging removed releaseDate
        //album.getReleaseDate()==null ||
        if (album.getTitle() == null || album.getArtist()==null || album.getDescription()==null ||
        album.getGenre()==null ||  album.getCoverImg()==null) {

            Toast.makeText(context, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();

            // TODO: Any other validation
            // TODO: Perhaps allow some fields to be empty
            // Confirm stockQuantity >= 0
        } else if (album.getStockQuantity()<0) {

            Toast.makeText(context, "Stock Quantity must not negative number.", Toast.LENGTH_SHORT).show();

        } else {
            // Add new album and
            // switch back to the MainActivity to show updated album data

            Intent intent = new Intent(context, MainActivity.class);

            viewModel.addAlbum(album);

            context.startActivity(intent);
        }
    }


    public void onGoBackBtnClicked(View view) {
        // Switch back to the MainActivity without any further actions
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
