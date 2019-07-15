package com.example.chaurideuralimunicipality.Activities;

import android.support.v7.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaurideuralimunicipality.R;

public class WardDetailsActivity extends AppCompatActivity {
    String firstpost;
    String secondpost;

    String firstnumber;
    String secondnumber;
    String thirdnumber;
    String fourthnumber;
    String fifthnumber;

    String wardtitle;
    String poulation;
    String latlong;
    String contact;

    String firstname;
    String secondname;
    String thirdname;
    String fourthname;
    String fifthname;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward_details);

        //setting up toolbar
        toolbar = findViewById(R.id.ward_details_toolbar);
        toolbar.setTitle("Ward Details");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView a1 =  findViewById(R.id.a1);
        TextView a2 =  findViewById(R.id.a2);
        TextView a3 =  findViewById(R.id.a3);
        TextView b1 =  findViewById(R.id.b1);
        TextView b2 =  findViewById(R.id.b2);
        TextView b3 =  findViewById(R.id.b3);
        TextView c1 =  findViewById(R.id.c1);
        TextView c2 =  findViewById(R.id.c2);
        TextView c3 =  findViewById(R.id.c3);
        TextView d1 =  findViewById(R.id.d1);
        TextView d2 =  findViewById(R.id.d2);
        TextView d3 =  findViewById(R.id.d3);
        TextView e1 =  findViewById(R.id.e1);
        TextView e2 =  findViewById(R.id.e2);
        TextView e3 =  findViewById(R.id.e3);

        TextView ward =  findViewById(R.id.wardtitle);
        TextView population =  findViewById(R.id.population);
        TextView contact =  findViewById(R.id.contact);
        TextView latlong =  findViewById(R.id.latlong);

        ImageView img1 =  findViewById(R.id.ward_people1);
        ImageView img2 =  findViewById(R.id.ward_people2);
        ImageView img3 = findViewById(R.id.ward_people3);
        ImageView img4 =  findViewById(R.id.ward_people4);
        ImageView img5 =  findViewById(R.id.ward_people5);

        this.firstpost=getString(R.string.post_1);
        this.secondpost=getString(R.string.post_2);

        Intent intent = getIntent();
        String wardNumber = intent.getStringExtra("Data");

        switch (wardNumber){
            case "1":
                img1.setImageDrawable(getResources().getDrawable(R.drawable.rajuolitamang));
                this.contact=getString(R.string.ward_1_contact_number);
                this.latlong="";
                this.poulation=getString(R.string.ward_1_population);
                this.wardtitle=getString(R.string.ward_1_name);

                this.firstname=getString(R.string.name_11);
                this.secondname=getString(R.string.name_12);
                this.thirdname=getString(R.string.name_13);
                this.fourthname=getString(R.string.name_14);
                this.fifthname=getString(R.string.name_15);
                this.firstnumber=getString(R.string.number_11);
                this.secondnumber=getString(R.string.number_12);
                this.thirdnumber=getString(R.string.number_13);
                this.fourthnumber=getString(R.string.number_14);
                this.fifthnumber=getString(R.string.number_15);
                break;
            case "2":
                this.contact=getString(R.string.ward_2_contact_number);
                this.latlong=getString(R.string.lan2)+", "+getString(R.string.lon2);
                this.poulation=getString(R.string.ward_2_population);
                this.wardtitle=getString(R.string.ward_2_name);
                this.firstname=getString(R.string.name_21);
                this.secondname=getString(R.string.name_22);
                this.thirdname=getString(R.string.name_23);
                this.fourthname=getString(R.string.name_24);
                this.fifthname=getString(R.string.name_25);
                this.firstnumber=getString(R.string.number_21);
                this.secondnumber=getString(R.string.number_22);
                this.thirdnumber=getString(R.string.number_23);
                this.fourthnumber=getString(R.string.number_24);
                this.fifthnumber=getString(R.string.number_25);

                break;
            case "3":
                this.contact=getString(R.string.ward_3_contact_number);
                this.latlong=getString(R.string.lan3)+", "+getString(R.string.lon3);
                this.poulation=getString(R.string.ward_3_population);
                this.wardtitle=getString(R.string.ward_3_name);
                img1.setImageDrawable(getResources().getDrawable(R.drawable.binodghising));
                this.firstname=getString(R.string.name_31);
                this.secondname=getString(R.string.name_32);
                this.thirdname=getString(R.string.name_33);
                this.fourthname=getString(R.string.name_34);
                this.fifthname=getString(R.string.name_35);
                this.firstnumber=getString(R.string.number_31);
                this.secondnumber=getString(R.string.number_32);
                this.thirdnumber=getString(R.string.number_33);
                this.fourthnumber=getString(R.string.number_34);
                this.fifthnumber=getString(R.string.number_35);

                break;
            case "4":
                this.contact=getString(R.string.ward_4_contact_number);
                this.latlong=getString(R.string.lan4)+", "+getString(R.string.lon4);
                this.poulation=getString(R.string.ward_4_population);
                this.wardtitle=getString(R.string.ward_4_name);
                this.firstname=getString(R.string.name_41);
                this.secondname=getString(R.string.name_42);
                this.thirdname=getString(R.string.name_43);
                this.fourthname=getString(R.string.name_44);
                this.fifthname=getString(R.string.name_45);
                this.firstnumber=getString(R.string.number_41);
                this.secondnumber=getString(R.string.number_42);
                this.thirdnumber=getString(R.string.number_43);
                this.fourthnumber=getString(R.string.number_44);
                this.fifthnumber=getString(R.string.number_45);

                break;
            case "5":
                this.contact=getString(R.string.ward_5_contact_number);
                this.latlong=getString(R.string.lan5)+", "+getString(R.string.lon5);
                this.poulation=getString(R.string.ward_5_population);
                this.wardtitle=getString(R.string.ward_5_name);
                img1.setImageDrawable(getResources().getDrawable(R.drawable.rajkumargautum));
                this.firstname=getString(R.string.name_51);
                this.secondname=getString(R.string.name_52);
                this.thirdname=getString(R.string.name_53);
                this.fourthname=getString(R.string.name_54);
                this.fifthname=getString(R.string.name_55);
                this.firstnumber=getString(R.string.number_51);
                this.secondnumber=getString(R.string.number_52);
                this.thirdnumber=getString(R.string.number_53);
                this.fourthnumber=getString(R.string.number_54);
                this.fifthnumber=getString(R.string.number_55);

                break;
            case "6":
                this.contact=getString(R.string.ward_6_contact_number);
                this.latlong=getString(R.string.lan6)+", "+getString(R.string.lon6);
                this.poulation=getString(R.string.ward_6_population);
                this.wardtitle=getString(R.string.ward_6_name);
                this.firstname=getString(R.string.name_61);
                this.secondname=getString(R.string.name_62);
                this.thirdname=getString(R.string.name_63);
                this.fourthname=getString(R.string.name_64);
                this.fifthname=getString(R.string.name_65);
                this.firstnumber=getString(R.string.number_61);
                this.secondnumber=getString(R.string.number_62);
                this.thirdnumber=getString(R.string.number_63);
                this.fourthnumber=getString(R.string.number_64);
                this.fifthnumber=getString(R.string.number_65);

                break;
            case "7":
                this.contact=getString(R.string.ward_7_contact_number);
                this.latlong=getString(R.string.lan7)+", "+getString(R.string.lon7);
                this.poulation=getString(R.string.ward_7_population);
                this.wardtitle=getString(R.string.ward_7_name);
                this.firstname=getString(R.string.name_71);
                this.secondname=getString(R.string.name_72);
                this.thirdname=getString(R.string.name_73);
                this.fourthname=getString(R.string.name_74);
                this.fifthname=getString(R.string.name_75);
                this.firstnumber=getString(R.string.number_71);
                this.secondnumber=getString(R.string.number_72);
                this.thirdnumber=getString(R.string.number_73);
                this.fourthnumber=getString(R.string.number_74);
                this.fifthnumber=getString(R.string.number_75);

                break;
            case "8":
                this.contact=getString(R.string.ward_7_contact_number);
                this.latlong=getString(R.string.lan7)+", "+getString(R.string.lon7);
                this.poulation=getString(R.string.ward_7_population);
                this.wardtitle=getString(R.string.ward_7_name);
                this.firstname=getString(R.string.name_81);
                this.secondname=getString(R.string.name_82);
                this.thirdname=getString(R.string.name_83);
                this.fourthname=getString(R.string.name_84);
                this.fifthname=getString(R.string.name_85);
                this.firstnumber=getString(R.string.number_81);
                this.secondnumber=getString(R.string.number_82);
                this.thirdnumber=getString(R.string.number_83);
                this.fourthnumber=getString(R.string.number_84);
                this.fifthnumber=getString(R.string.number_85);

                break;
            case "9":
                this.contact=getString(R.string.ward_9_contact_number);
                this.latlong=getString(R.string.lan9)+", "+getString(R.string.lon9);
                this.poulation=getString(R.string.ward_9_population);
                this.wardtitle=getString(R.string.ward_9_name);
                img1.setImageDrawable(getResources().getDrawable(R.drawable.rambdhlama));
                this.firstname=getString(R.string.name_91);
                this.secondname=getString(R.string.name_92);
                this.thirdname=getString(R.string.name_93);
                this.fourthname=getString(R.string.name_94);
                this.fifthname=getString(R.string.name_95);
                this.firstnumber=getString(R.string.number_91);
                this.secondnumber=getString(R.string.number_92);
                this.thirdnumber=getString(R.string.number_93);
                this.fourthnumber=getString(R.string.number_94);
                this.fifthnumber=getString(R.string.number_95);
                break;
        }

        ward.setText(this.wardtitle);
        contact.setText(this.contact);
        population.setText(this.poulation);
        latlong.setText(this.latlong);

        a1.setText(this.firstname);
        a2.setText(this.firstpost);
        a3.setText(this.firstnumber);

        b1.setText(this.secondname);
        b2.setText(this.secondpost);
        b3.setText(this.secondnumber);

        c1.setText(this.thirdname);
        c2.setText(this.secondpost);
        c3.setText(this.thirdnumber);

        d1.setText(this.fourthname);
        d2.setText(this.secondpost);
        d3.setText(this.fourthnumber);

        e1.setText(this.fifthname);
        e2.setText(this.secondpost);
        e3.setText(this.fifthnumber);



    }
}
