package com.desafioventurus.presenters;

import com.desafioventurus.interfaces.presenters.IGallery;

public class GalleryPresenter implements IGallery.Presenter {

    private IGallery.View activityView;

    public GalleryPresenter(IGallery.View view){
        this.activityView = view;
    }

}
