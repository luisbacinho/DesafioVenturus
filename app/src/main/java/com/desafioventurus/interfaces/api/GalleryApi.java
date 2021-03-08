package com.desafioventurus.interfaces.api;

import com.desafioventurus.models.Data;
import com.desafioventurus.models.Gallery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GalleryApi {
    @Headers({
            "Authorization: Client-ID 05fa9a161fc134d"
    })
    @GET("3/gallery/hot/top/week?showViral=true&mature=false&album_previews=true")
    Call<Data<List<Gallery>>> getGalleries();

}
