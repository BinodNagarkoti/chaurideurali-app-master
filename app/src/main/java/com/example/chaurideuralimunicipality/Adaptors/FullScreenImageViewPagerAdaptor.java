package com.example.chaurideuralimunicipality.Adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FullScreenImageViewPagerAdaptor extends PagerAdapter {

    private Context context;
    private List<String> urls;
    String image;

    public FullScreenImageViewPagerAdaptor(Context context, List<String> urls, String image) {
        this.context = context;
        this.urls = urls;
        this.image = image;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);

            Picasso.get().load(urls.get(position)).into(imageView);
            container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
