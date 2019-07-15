package com.example.chaurideuralimunicipality.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.chaurideuralimunicipality.Adaptors.FullScreenImageViewPagerAdaptor;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;

import java.io.Serializable;

public class FullScreenActivity extends AppCompatActivity implements Serializable {

    ImageView fullimage;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        String image = getIntent().getStringExtra("imageuri");


        viewPager = findViewById(R.id.fullscreen_viewpager);
        Log.d("images ", getImages().getUrls().get(0));
        FullScreenImageViewPagerAdaptor adaptor = new FullScreenImageViewPagerAdaptor(FullScreenActivity.this,getImages().getUrls(),image);
        viewPager.setAdapter(adaptor);
        viewPager.setOffscreenPageLimit(getImages().getUrls().size());
    }
    public Gallery getImages(){
        Gallery gallery = (Gallery) getIntent().getSerializableExtra("imagecollection");
        return gallery;
    }
}
