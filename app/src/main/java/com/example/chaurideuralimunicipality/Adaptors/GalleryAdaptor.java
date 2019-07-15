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
import android.widget.TextView;

import com.example.chaurideuralimunicipality.Activities.GalleryDetails;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class GalleryAdaptor extends RecyclerView.Adapter<GalleryAdaptor.GalleryViewHolder> implements Serializable {
    Context mcontext;
    List<Gallery> mlist;   //gallery should have title and image of first index so that, that image could be use as background of gallery

    public GalleryAdaptor(Context mcontext, List<Gallery> mlist){
        this.mcontext = mcontext;
        this.mlist = mlist;
    }
    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.album_card,null);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int position) {

        final Gallery gallery = mlist.get(position);
        galleryViewHolder.title.setText(gallery.getTitle());
        Picasso.get().load(gallery.getUrls().get(0)).into(galleryViewHolder.thumbnail);

        //when user clicked one album it should take inside of that album
        galleryViewHolder.album_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext,GalleryDetails.class);
                intent.putExtra("galleryobject",gallery);
                mcontext.startActivity(intent);

            }
        });
        //thumbnail keeping decision yet to make
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;
        LinearLayout album_layout;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.album_name);
            thumbnail = itemView.findViewById(R.id.album_thumbnail);
            album_layout = itemView.findViewById(R.id.album_card_layout);
        }
    }
}
