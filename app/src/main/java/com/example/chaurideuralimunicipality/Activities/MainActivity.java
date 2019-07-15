package com.example.chaurideuralimunicipality.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.chaurideuralimunicipality.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ----------setting up custom toolbar

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");


        //-----------------setting up navigation drawer-----------------------

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout ,toolbar,
                R.string.drawer_open,R.string.drawer_close); //draweropen and drawerclose is hardcoded in string and making drawer responsive

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();  //syncstate links drawer icon in toolbar with drawerlayout

    }

    public void showNotice(View v){
        startingActivity(NoticeActivity.class);

    }
    public void showAbout(View v){
        startingActivity(About_us.class);

    }

    public void showGallery(View v){
        startingActivity(GalleryActivity.class);

    }
    public void showProgram(View v){
        startingActivity(ProgramActivity.class);

    }
    public void showWard(View v){
        startingActivity(WardActivity.class);
    }
    public void showContact(View v){
        startingActivity(Contact_us.class);
    }

    public void startingActivity(Class classname) {
        Intent intent = new Intent(MainActivity.this, classname);
        startActivity(intent);
    }

    //drawer item click listener setting up
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                hideDrawer();
                break;
            case R.id.nav_notice:
                startingActivity(NoticeActivity.class);
                break;

            case R.id.nav_wards:
                startingActivity(WardActivity.class);
                break;

            case R.id.nav_aboutus:
                startingActivity(About_us.class);
                break;

            case R.id.nav_contactus:
                startingActivity(Contact_us.class);
                break;

            case R.id.nav_gallery:
                startingActivity(GalleryActivity.class);
                break;

            case R.id.nav_program:
                startingActivity(ProgramActivity.class);
                break;
        }
        return true;
    }

    //opening drawer
    private void showDrawer(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //close Drawer
    private void hideDrawer(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            hideDrawer();
        }else {
            super.onBackPressed();
        }
    }

}
