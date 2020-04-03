package com.example.lenovo.solarsystem;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CustomizedPlanets extends AppCompatActivity {

    FloatingActionButton jbtnEdit;
    DatabaseHelper myDb;
    TextView text;
    private DrawerLayout nDrawerLayout; //for drawerlayout
    private ActionBarDrawerToggle nToggle;//for thet toggle
    NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_planets);

        jbtnEdit = (FloatingActionButton)findViewById(R.id.btnEdit);
        text = (TextView)findViewById(R.id.planet);
        myDb = new DatabaseHelper(this);
        //bridging
        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        //to show toggle action
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Cursor res = myDb.getAllData();
        if(res.getCount()==0)
        {
            //no data
            text.setText("Error Nothing found");

        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            //show all data
            text.append("ID:" + res.getString(0) + " \n");
            text.append("Planet Name: \t" + res.getString(1) + " \n");
            text.append("Planet Description : \t " + res.getString(2) + "\n\n");


        }



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

        jbtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(CustomizedPlanets.this,Edit.class);
                startActivity(edit);
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
