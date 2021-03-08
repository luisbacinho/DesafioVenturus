package com.desafioventurus.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;

import com.desafioventurus.R;
import com.desafioventurus.interfaces.callbacks.EstablishedConnectionCallback;
import com.desafioventurus.interfaces.presenters.IGallery;
import com.desafioventurus.interfaces.callbacks.RequestFailedCallback;
import com.desafioventurus.presenters.GalleryPresenter;

public class GalleryActivity extends AppCompatActivity implements IGallery.View, RequestFailedCallback, EstablishedConnectionCallback {

    private IGallery.Presenter Presenter;
    private ListFragment listFragment;
    private ErrorFragment errorFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.Presenter = new GalleryPresenter(this);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        listFragment = new ListFragment(this);
        errorFragment = new ErrorFragment(this);

        fragmentTransaction.replace(R.id.container, listFragment).commit();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onRequestFailed() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, errorFragment).commit();
    }

    @Override
    public void onEstablishedConnection() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, listFragment).commit();
    }
}