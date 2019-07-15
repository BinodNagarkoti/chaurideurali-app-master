package com.example.chaurideuralimunicipality.Activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.chaurideuralimunicipality.Adaptors.GalleryAdaptor;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Gallery;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    GalleryAdaptor adaptor;
    List<Gallery> mlist;
    FirebaseDatabase database;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        //setting up toolbar
        toolbar = findViewById(R.id.gallery_toolbar);
        toolbar.setTitle("Gallery");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //setting up recyclerview
        recyclerView = findViewById(R.id.gallery_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(GalleryActivity.this,1));

        mlist = new ArrayList<>();
        loadImagefromDatabase();

        //getting data to recyclerview
        adaptor = new GalleryAdaptor(this,mlist);
        recyclerView.setAdapter(adaptor);
        progressDialog.dismiss();
    }

    private void loadImagefromDatabase() {

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Images");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //checking if list is empty or not ..to not make dublicate file while making real time update
                if(!mlist.isEmpty()){
                    mlist.clear();
                }

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Gallery gallery = dataSnapshot1.getValue(Gallery.class);
                    mlist.add(0,gallery);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(GalleryActivity.this,"Something occured",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
