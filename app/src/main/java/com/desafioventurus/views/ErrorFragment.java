package com.desafioventurus.views;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.desafioventurus.R;
import com.desafioventurus.interfaces.callbacks.EstablishedConnectionCallback;
import com.desafioventurus.interfaces.api.GalleryApi;
import com.desafioventurus.models.Data;
import com.desafioventurus.models.Gallery;
import com.desafioventurus.network.APIBase;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ErrorFragment extends Fragment implements Callback<Data<List<Gallery>>> {

    private final EstablishedConnectionCallback establishedConnectionCallback;
    private boolean tryingToReconnect = false;

    public ErrorFragment(EstablishedConnectionCallback establishedConnectionCallback) {
        this.establishedConnectionCallback = establishedConnectionCallback;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_error, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView reloadButton = getView().findViewById(R.id.reload_button);
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               tryReconnect();
            }
        });
    }

    private void tryReconnect(){
        if(tryingToReconnect)
            return;

        tryingToReconnect = true;
        APIBase.getRepository(GalleryApi.class).getGalleries().enqueue(this);
    }

    @Override
    public void onResponse(Call<Data<List<Gallery>>> call, Response<Data<List<Gallery>>> response) {
        tryingToReconnect = false;
        if(response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(this).commit();
            establishedConnectionCallback.onEstablishedConnection();
        }
    }

    @Override
    public void onFailure(Call<Data<List<Gallery>>> call, Throwable t) {
        tryingToReconnect = false;
    }
}