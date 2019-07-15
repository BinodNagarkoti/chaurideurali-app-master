package com.example.chaurideuralimunicipality.Activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaurideuralimunicipality.Adaptors.ProgramAdaptor;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Program;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {

    List<Program> mlist;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    TextView noprogram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        noprogram = findViewById(R.id.noprogram);
        toolbar = findViewById(R.id.program_toolbar);
        toolbar.setTitle("Program");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        //setting recyclerview
        recyclerView = findViewById(R.id.program_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(ProgramActivity.this,1));

        //getting data from database
        mlist = new ArrayList<>();
        getProgramData();

            //keeping data into recyclerview via adaptor
            ProgramAdaptor adaptor = new ProgramAdaptor(this, mlist);
            recyclerView.setAdapter(adaptor);
            progressDialog.dismiss();

    }

    private void getProgramData() {

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Programs");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!mlist.isEmpty()){
                    mlist.clear();
                }
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Program program = dataSnapshot1.getValue(Program.class);
                    mlist.add(0, program);
                }
                if(mlist.isEmpty()){
                    noprogram.setText("No Program Available");
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProgramActivity.this,"Something Happened",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
