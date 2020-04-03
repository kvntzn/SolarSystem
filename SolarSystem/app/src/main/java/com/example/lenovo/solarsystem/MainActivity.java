package com.example.lenovo.solarsystem;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    private DrawerLayout nDrawerLayout; //for drawerlayout
    private ActionBarDrawerToggle nToggle;//for thet toggle

    DatabaseHelper myDb;
    FloatingActionButton jbtnEdit;
    ImageButton jbtnSun;
    ImageButton btnMercury;
    ImageButton jbtnVenus;
    ImageButton jbtnEarth;
    ImageButton jbtnMars;
    ImageButton jbtnJupiter;
    ImageButton jbtnSaturn;
    ImageButton jbtnUranus;
    ImageButton jbtnNeptune;
    ImageButton jbtnPluto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);

        //variables
        jbtnEdit = (FloatingActionButton)findViewById(R.id.btnEdit);
        jbtnSun = (ImageButton)findViewById(R.id.btnSun);
        btnMercury = (ImageButton)findViewById(R.id.btnMercury);
        jbtnVenus = (ImageButton)findViewById(R.id.btnVenus);
        jbtnEarth = (ImageButton)findViewById(R.id.btnEarth);
        jbtnMars = (ImageButton)findViewById(R.id.btnMars);
        jbtnJupiter = (ImageButton)findViewById(R.id.btnJupiter);
        jbtnSaturn = (ImageButton)findViewById(R.id.btnSaturn);
        jbtnUranus = (ImageButton)findViewById(R.id.btnUranus);
        jbtnNeptune = (ImageButton)findViewById(R.id.btnNeptune);
        jbtnUranus = (ImageButton)findViewById(R.id.btnUranus);
        jbtnPluto = (ImageButton)findViewById(R.id.btnPluto);

        //to show toggle action
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //navigationview item
        NavigationView nv = (NavigationView)findViewById(R.id.nv1);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
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
                return true;
            }
        });



        jbtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(MainActivity.this,Edit.class);
                startActivity(edit);
            }
        });

        jbtnSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sun = new Intent(MainActivity.this,Sun.class);
                startActivity(sun);
            }
        });
        btnMercury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent mercury = new Intent(MainActivity.this,Mercury.class);
                startActivity(mercury);
            }
        });

        jbtnVenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent venus = new Intent(MainActivity.this,Venus.class);
                startActivity(venus);
            }
        });

        jbtnEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent earth = new Intent(MainActivity.this,Earth.class);
                startActivity(earth);
            }
        });

        jbtnMars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mars = new Intent(MainActivity.this,Mars.class);
                startActivity(mars);
            }
        });

        jbtnJupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jupiter = new Intent(MainActivity.this,Jupiter.class);
                startActivity(jupiter);
            }
        });

        jbtnSaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saturn = new Intent(MainActivity.this,Saturn.class);
                startActivity(saturn);
            }
        });

        jbtnUranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uranus = new Intent(MainActivity.this,Uranus.class);
                startActivity(uranus);
            }
        });

        jbtnNeptune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neptune = new Intent(MainActivity.this,Neptune.class);
                startActivity(neptune);
            }
        });

        jbtnPluto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pluto = new Intent(MainActivity.this,Pluto.class);
                startActivity(pluto);
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
