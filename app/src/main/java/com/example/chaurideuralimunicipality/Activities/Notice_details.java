package com.example.chaurideuralimunicipality.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Notice;
import java.io.Serializable;


public class Notice_details extends AppCompatActivity implements Serializable {

    Toolbar toolbar;
    TextView title,information;
    Button showpdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_details);
        title = findViewById(R.id.notice_details_title);
        information = findViewById(R.id.notice_details_information);
        showpdf = findViewById(R.id.showpdf);

        // -----------setting up toolbar
        toolbar = findViewById(R.id.notice_details_toolbar);
        toolbar.setTitle("Notice Details");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //showing data getting from object (i.e title body and pdf to activity)
        title.setText(getNoticeData().getTitle());
        information.setText(getNoticeData().getBody()); //getting data from object that is sent from noticeactivity
        final String pdfurl = getNoticeData().getUrl();

        if(pdfurl != null) {

            showpdf.setVisibility(View.VISIBLE);
            showpdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfurl));
                    startActivity(intent);
                }
            });
        }else{
            showpdf.setVisibility(View.GONE);
        }


    }
    public Notice getNoticeData(){
        Notice notice = (Notice) getIntent().getSerializableExtra("notice");
        return notice;
    }

}

