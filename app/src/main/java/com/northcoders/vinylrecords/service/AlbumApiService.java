package com.northcoders.vinylrecords.service;

import com.northcoders.vinylrecords.model.Album;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();


    @POST("albums")
    Call<List<Album>> addAlbum(@Body Album album);

    //    Call is a Retrofit class which allows the application to make asynchronous HTTP requests and get the response from the server.
    //    This is typically executed on a background thread, which managed by Retrofit, and the response is delivered to the main thread of the application.

}
