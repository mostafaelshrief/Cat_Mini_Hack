package com.azapps.moviesreviewer.repository;

import android.graphics.Bitmap;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

public interface ImageService {
    String ENDPOINT = "HTTP://api.themoviedb.org/3/movie/popular?api_key=49066942591aa4286806177d1fc935a0&page=1";

    @GET
    @Streaming
    Observable<Bitmap> getThumbs(@Url String filepath);

    /********
     * Helper class that sets up a new services
     *******/
    class Instance {

        static ImageService instance;

        public static ImageService get() {
            if (instance == null)
                instance = newImageService();
            return instance;
        }

        public static ImageService newImageService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ImageService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(ImageService.class);
        }
    }
}

