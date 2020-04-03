package com.example.lenovo.solarsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Uranus extends AppCompatActivity {

    private DrawerLayout nDrawerLayout; //for drawerlayout
    private ActionBarDrawerToggle nToggle;//for thet toggle
    NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uranus);
        //bridging
        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        //to show toggle action
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //navigationview item
        nv = (NavigationView)findViewById(R.id.nv1);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case(R.id.nav_home):
                        Intent in = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_cusplanets):
                        in = new Intent(getApplicationContext(),CustomizedPlanets.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_stars):
                        in = new Intent(getApplicationContext(),Stars.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_member):
                        in = new Intent(getApplicationContext(),Members.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_overview):
                        in = new Intent(getApplicationContext(),Overview.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_moon):
                        in = new Intent(getApplicationContext(),Moon.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_location):
                        in = new Intent(getApplicationContext(),Location.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_asteroid):
                        in = new Intent(getApplicationContext(),Asteroid.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_comet):
                        in = new Intent(getApplicationContext(),Comet.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_blackhole):
                        in = new Intent(getApplicationContext(),Blackhole.class);
                        startActivity(in);
                        break;
                }
                return false;
            }
        });
    }

    //for the action toggle to work
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
