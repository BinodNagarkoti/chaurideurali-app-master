package com.example.chaurideuralimunicipality.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.chaurideuralimunicipality.Adaptors.GalleryDetailsAdaptor;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;

import java.io.Serializable;
import java.util.List;

public class GalleryDetails extends AppCompatActivity implements Serializable {

    Toolbar toolbar;
    TextView title,description;
    RecyclerView recyclerView;
    GalleryDetailsAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_details);
        //setting up toolbar
        toolbar = findViewById(R.id.photo_toolbar);
        toolbar.setTitle("Photos");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title = findViewById(R.id.gallery_title);
        description = findViewById(R.id.gallery_description);

        //setting title and description of whole gallery
        title.setText(getgalleryObject().getTitle());
        description.setText(getgalleryObject().getDescription());

        //setting up recycler view
        recyclerView = findViewById(R.id.photo_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //setting adaptor to recycler view
        adaptor = new GalleryDetailsAdaptor(this,getgalleryObject());
        recyclerView.setAdapter(adaptor);

    }

    public Gallery getgalleryObject(){
        Gallery gallery = (Gallery) getIntent().getSerializableExtra("galleryobject");
        return gallery;
    }
}
