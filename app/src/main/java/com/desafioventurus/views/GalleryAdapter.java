package com.desafioventurus.views;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.desafioventurus.R;
import com.desafioventurus.interfaces.api.ImageApi;
import com.desafioventurus.models.Data;
import com.desafioventurus.models.Gallery;
import com.desafioventurus.models.Image;
import com.desafioventurus.network.APIBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryAdapter extends ArrayAdapter<Gallery>{

    private Activity context;
    private List<Gallery> galleryList;

    public GalleryAdapter(Activity context, List<Gallery> list) {
        super(context, R.layout.card_layout, list);
        this.context = context;
        this.galleryList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        Gallery gallery = galleryList.get(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.card_layout, null);
            holder = new ViewHolder();
            holder.upsCount = (TextView) convertView.findViewById(R.id.ups_number);
            holder.commentsCount = (TextView) convertView.findViewById(R.id.comment_number);
            holder.viewsCount = (TextView) convertView.findViewById(R.id.eye_number);
            holder.coverImage = (ImageView) convertView.findViewById(R.id.card_cover_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.upsCount.setText(String.valueOf(gallery.getUps()));
        holder.commentsCount.setText(String.valueOf(gallery.getComment_count()));
        holder.viewsCount.setText(String.valueOf(gallery.getViews()));

        String link = gallery.getLinkForDownload();

        if(link == null){
            downloadImage(gallery, holder);
            return convertView;
        }

        this.setImage(link, holder.coverImage);

        return convertView;
    }

    private void downloadImage(Gallery gallery, ViewHolder holder){
        ImageApi imageApi = APIBase.getRepository(ImageApi.class);
        imageApi.getImageFromId(gallery.getCover()).enqueue(new Callback<Data<Image>>() {
            @Override
            public void onResponse(Call<Data<Image>> call, Response<Data<Image>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    setImage(response.body().getData().getLinkForDownload(), holder.coverImage);
                    return;
                }
                onFailure(call, null);
            }

            @Override
            public void onFailure(Call<Data<Image>> call, Throwable t) {
                //Remover essa Thread caso crashe sem motivo
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        downloadImage(gallery, holder);
                    }
                }).start();
            }
        });
    }

    private void setImage(String link, ImageView imageView){
        Glide
                .with(context)
                .load(link)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.ic_refresh).centerCrop())
                .into(imageView);
    }


    static class ViewHolder{
        TextView upsCount;
        TextView commentsCount;
        TextView viewsCount;
        ImageView coverImage;
    }


    @Override
    public int getCount() {
        return galleryList.size();
    }

    @Nullable
    @Override
    public Gallery getItem(int position) {
        return galleryList.get(position);
    }

}
