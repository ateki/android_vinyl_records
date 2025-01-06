package com.northcoders.vinylrecords.ui.mainactivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.vinylrecords.R;
import com.northcoders.vinylrecords.databinding.AlbumItemv3Binding;
import com.northcoders.vinylrecords.model.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private final static String TAG = "AlbumAdapter";
    List<Album> albumList;
    // ArrayList<Album> albumList;
    // TODO: A context object?
    // TODO: Constructor should refer to this? as per Task 7?


    private final RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList, RecyclerViewInterface recyclerViewInterface) {
        this.albumList = albumList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    /**
     * Creates new ViewHolders for the items and deals with the inflation of the card layout as an item to be displayed in the RecylerView.
     */
    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemv3Binding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_itemv3,
                parent,
                false
        );
        return new AlbumViewHolder(binding, recyclerViewInterface);
    }

    /**
     * Deals with the setting of different data and methods related to particular items of the RecyclerView.
     */
    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.binding.setAlbum(album);

    }
    /**
     * Returns  the length of the RecyclerView in relation to the size of the list of data being displayed.
     */
    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public void setFilteredAlbumList(ArrayList<Album> filteredAlbumList) {

        Log.i(TAG, "filterAlbumList::filteredAlbumList setFilteredAlbumList = " +filteredAlbumList);
        this.albumList = filteredAlbumList;
        // Notify any observers of data change
        // TODO: Be more specific on who to be notified
        notifyDataSetChanged();
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private AlbumItemv3Binding binding;

        public AlbumViewHolder(AlbumItemv3Binding albumItemBinding, RecyclerViewInterface recylerViewInterface) {
            super(albumItemBinding.getRoot());
            this.binding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                        if (recylerViewInterface != null) {
                            int position = getAdapterPosition();

                            if (position != RecyclerView.NO_POSITION) {
                                recylerViewInterface.onItemClick(position);
                            }
                        }
                      }
            });

        }

    }

}
