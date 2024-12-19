package com.northcoders.vinylrecords.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.vinylrecords.model.Album;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivity;
import com.northcoders.vinylrecords.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {
    private Album album;
    private MainActivityViewModel mainActivityViewModel;
    private long albumId;
    private Context context;

    public UpdateAlbumClickHandler(Album album, MainActivityViewModel mainActivityViewModel, Context context) {
        this.album = album;
        this.mainActivityViewModel = mainActivityViewModel;
        this.context = context;
    }

    
    public void onBackBtnClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    
    public void onUpdateBtnClicked(View view) {

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

            mainActivityViewModel.updateAlbum(albumId, updatedAlbum);

            context.startActivity(intent);
        }
    }

    public void onDeleteBtnClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);

        mainActivityViewModel.deleteAlbum(album.getId());

        context.startActivity(intent);
    }
    
}
