package com.example.chaurideuralimunicipality.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.chaurideuralimunicipality.Activities.FullScreenActivity;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class GalleryDetailsAdaptor extends RecyclerView.Adapter<GalleryDetailsAdaptor.GalleryDetailsViewHolder> implements Serializable{

    Context mcontext;
    Gallery gallery;

    public GalleryDetailsAdaptor(Context context,Gallery gallery) {
        this.mcontext = context;
        this.gallery = gallery;
    }

    @NonNull
    @Override
    public GalleryDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.photo_card,null);
        return new GalleryDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryDetailsViewHolder galleryDetailsViewHolder, int i) {
    final int position = i;
     Picasso.get().load(gallery.getUrls().get(i)).into(galleryDetailsViewHolder.photo);
     galleryDetailsViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(mcontext, FullScreenActivity.class);
             intent.putExtra("imageuri",gallery.getUrls().get(position));
             intent.putExtra("imagecollection", gallery);
             mcontext.startActivity(intent);

         }
     });

    }

    @Override
    public int getItemCount() {
        return gallery.getUrls().size();
    }

    public class GalleryDetailsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageView photo;


        public GalleryDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.photo_layout);
            photo =itemView.findViewById(R.id.photos);

        }
    }
}
