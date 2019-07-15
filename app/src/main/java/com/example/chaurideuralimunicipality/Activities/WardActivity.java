package com.example.chaurideuralimunicipality.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.chaurideuralimunicipality.R;

public class WardActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward);
        toolbar = findViewById(R.id.ward_list_toolbar);
        toolbar.setTitle("Wards");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void Ward1(View V){
        getClass(WardDetailsActivity.class,"1");
    }
    public void Ward2(View v){
        getClass(WardDetailsActivity.class,"2");
    }
    public void Ward3(View v){
        getClass(WardDetailsActivity.class,"3");
    }
    public void Ward4(View v){
        getClass(WardDetailsActivity.class,"4");
    }
    public void Ward5(View v){
        getClass(WardDetailsActivity.class,"5");
    }
    public void Ward6(View v){
        getClass(WardDetailsActivity.class,"6");
    }
    public void Ward7(View v){
        getClass(WardDetailsActivity.class,"7");
    }
    public void Ward8(View v){
        getClass(WardDetailsActivity.class,"8");
    }
    public void Ward9(View v){
        getClass(WardDetailsActivity.class,"9");
    }

    public void getClass(Class c, String message){
        Intent intent = new Intent(this,c);
        intent.putExtra("Data", message);
        startActivity(intent);
    }
}
