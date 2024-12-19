package com.northcoders.vinylrecords.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivity;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {

    private final static String TAG = "UpdateAlbumClickHandler";
    private Album album;
    private long albumId;
    private Context context;
    private MainActivityViewModel viewModel;

    public UpdateAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
        Log.i(TAG, "constructor called");
    }

    
    public void onGoBackBtnClicked(View view) {
        Log.i(TAG, "::onGoBackBtnClicked");
        // Switch back to the MainActivity without any further actions
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    
    public void onUpdateBtnClicked(View view) {

        // Update album and switch back to MainActivity
        Log.i(TAG, "::onUpdateBtnClicked to update "+  album.toString());

        Album updatedAlbum = new Album(
            album.getId(),
            album.getTitle(), 
            album.getDescription(),
            album.getArtist(), 
            album.getGenre(), 
            album.getReleaseDate(),
            album.getReleaseYear(),
            album.getCoverImg(),
            album.getStockQuantity()
        ); 
        
        // TODO : validate releaseDate, Year once add to ui..
        if (Objects.equals(updatedAlbum.getTitle(), "") ||
                Objects.equals(updatedAlbum.getDescription(), "") ||
                Objects.equals(updatedAlbum.getArtist(), "") ||
                Objects.equals(updatedAlbum.getGenre(), "") ||
                Objects.equals(updatedAlbum.getCoverImg(), "") ) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (updatedAlbum.getStockQuantity() <0) {
            Toast.makeText(context, "Stock Quantity cannot be negative.", Toast.LENGTH_SHORT).show();
            
        } else {

            Intent intent = new Intent(context, MainActivity.class);

            long albumId = album.getId();

            viewModel.updateAlbum(albumId, updatedAlbum);

            context.startActivity(intent);
        }
    }

    public void onDeleteBtnClicked(View view) {
        Log.i(TAG, "::onDeleteBtnClicked");
        // Delete album and swithc back to MainActivity
        Intent intent = new Intent(context, MainActivity.class);

        viewModel.deleteAlbum(album.getId());

        context.startActivity(intent);
    }
    
}
