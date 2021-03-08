package com.desafioventurus.interfaces.api;

import com.desafioventurus.models.Data;
import com.desafioventurus.models.Image;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ImageApi {
    @Headers({
            "Authorization: Client-ID 05fa9a161fc134d"
    })
    @GET("image/{imageId}")
    Call<Data<Image>> getImageFromId(@Path("imageId") String imageId);
}
