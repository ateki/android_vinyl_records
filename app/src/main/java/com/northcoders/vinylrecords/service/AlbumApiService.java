package com.northcoders.vinylrecords.service;

import com.northcoders.vinylrecords.model.Album;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();


    @POST("albums")
    Call<Album> addAlbum(@Body Album album);

    //    Call is a Retrofit class which allows the application to make asynchronous HTTP requests and get the response from the server.
    //    This is typically executed on a background thread, which managed by Retrofit, and the response is delivered to the main thread of the application.

    @PUT("albums/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<Album> deleteAlbum(@Path("id") long id);


}
