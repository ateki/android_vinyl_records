package com.northcoders.vinylrecords.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.vinylrecords.service.AlbumApiService;
import com.northcoders.vinylrecords.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private static String TAG="AlbumRepository";

    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<List<Album>>();
    // to get application conte t
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        Log.i(TAG,"getMutableLiveData called");

        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.i("GET request", t.getMessage());
            }
        });

        return mutableLiveData;
    }


    public void addAlbum(Album album) {
        Log.i(TAG,"addAlbum called with album : " + album.toString());

        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<Album> callback = albumApiService.addAlbum(album);

        // Callback to be invoked on receipt of server response and communicate responses from server: one by one
        callback.enqueue(new Callback<Album>() {

            @Override
            // Invoked for a received HTTP response
            public void onResponse(Call<Album> call, Response<Album> response) {
                Log.i("POST onResponse: response.message:", response.message());
                Toast.makeText(application.getApplicationContext(), "Album added to database", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            // Invoked when network exception occurred communicating with server,
            // or when unexpected exception occurred creating the request/processing the response
            public void onFailure(Call<Album> call, Throwable t) {
                // TODO: give more details as to wh
                Toast.makeText(application.getApplicationContext(), "Unable to add album to database", Toast.LENGTH_SHORT)
                        .show();
                Log.e("POST onFailure", t.getMessage());
            }
        });


    }


    public void updateAlbum(long id, Album album) {
            Log.i(TAG,"updateAlbum called");

            AlbumApiService albumApiService = RetrofitInstance.getService();

            Call<Album> callback = albumApiService.updateAlbum(id,album);

            // Used to initiate an asynchronous HTTP request and get the response from the server.
            // Is typically used to execute the request on a background thread, which is internally managed by Retrofit.
            // The response is delivered on the main thread. The Callback is invoked when the request is completed.

            callback.enqueue(new Callback<Album>() {

                @Override
                // Invoked for a received HTTP response
                public void onResponse(Call<Album> call, Response<Album> response) {
                    // TODO Handle diff responses - how can they be handled here. Add extra
                    // code to do alt with response.code()?
                    // ie
                    //  if (response.code() == 200) ...do this..
                    //  if didn't get response wanted but did not fail do something...

                    Toast.makeText(application.getApplicationContext(), "Album updated ", Toast.LENGTH_SHORT)
                            .show();
                }

                @Override
                // Invoked when network exception occurred communicating with server,
                // or when unexpected exception occurred creating the request/processing the response
                public void onFailure(Call<Album> call, Throwable t) {
                    Toast.makeText(application.getApplicationContext(), "Unable to update album to database", Toast.LENGTH_SHORT)
                            .show();
                    Log.e("PUT onFailure", t.getMessage());
                }
            });
    }

        // TODO: repeating much code here so could refactor to make DRY

    public void deleteAlbum(long id ) {
        Log.i(TAG,"deleteAlbum called");

        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<String> callback = albumApiService.deleteAlbum(id);

        // Callback to be invoked on receipt of server response and communicate responses from server: one by one
        // use string get back..
        callback.enqueue(new Callback<String>() {

            @Override
            // Invoked for a received HTTP response
            public void onResponse(Call<String> call, Response<String> response) {
                // TODO Handle diff responses - how can they be handled here. Add extra
                // successful on update, send popup
                // We could do other things
                // if (response.code() == 200) ...do this..
                // if didnt get response wanted but did not fail do something...
                Toast.makeText(application.getApplicationContext(), response.body(), Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            // Invoked when network exception occurred communicating with server,
            // or when unexpected exception occurred creating the request/processing the response
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Unable to update album to database", Toast.LENGTH_SHORT)
                        .show();
                Log.e("DELETE onFailure", t.getMessage());
            }
        });
    }

}
