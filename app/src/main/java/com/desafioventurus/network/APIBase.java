package com.desafioventurus.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class APIBase {

    public static  <T> T getRepository(Class<T> object){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(object);
    }
}
