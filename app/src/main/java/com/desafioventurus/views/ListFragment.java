package com.desafioventurus.views;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.desafioventurus.R;
import com.desafioventurus.interfaces.api.GalleryApi;
import com.desafioventurus.interfaces.callbacks.RequestFailedCallback;
import com.desafioventurus.models.Data;
import com.desafioventurus.models.Gallery;
import com.desafioventurus.network.APIBase;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment implements Callback<Data<List<Gallery>>>{

    private GridView cardsGridView;
    private View view;
    private Context context;
    private SwipeRefreshLayout refreshLayout;
    private GalleryApi galleryApi;
    private final RequestFailedCallback requestFailedCallback;

    public ListFragment(RequestFailedCallback requestFailedCallback) {
        this.requestFailedCallback = requestFailedCallback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_list, container, false);
        this.galleryApi =  APIBase.getRepository(GalleryApi.class);
        this.refreshLayout = view.findViewById(R.id.refreshLayout);
        this.refreshLayout.setOnRefreshListener(this::getImages);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getImages();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.getImages();
    }

    private void getImages(){
        galleryApi.getGalleries().enqueue(this);
    }

    @Override
    public void onResponse(Call<Data<List<Gallery>>> call, Response<Data<List<Gallery>>> response) {
        this.refreshLayout.setRefreshing(false);
        if(this.context != null && view != null && response.isSuccessful() && response.body().isSuccess()){
            GalleryAdapter adapter = new GalleryAdapter((Activity)context, response.body().getData());
            cardsGridView = view.findViewById(R.id.gridViewCards);
            this.cardsGridView.setAdapter(adapter);
            return;
        }

        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(this).commit();
        requestFailedCallback.onRequestFailed();

    }

    @Override
    public void onFailure(Call<Data<List<Gallery>>> call, Throwable t) {
        this.refreshLayout.setRefreshing(false);

        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(this).commit();
        requestFailedCallback.onRequestFailed();
    }
}