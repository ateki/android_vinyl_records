package com.northcoders.vinylrecords.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.northcoders.vinylrecords.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {


    private static final String TAG = "MainActivityClickHandler";

    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddAlbumBtnClicked(View view) {
        Log.i(TAG, "onAddAlbumBtnClicked called");
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);
        context.startActivity(intent);
    }

}
