package com.example.lenovo.solarsystem;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Edit extends AppCompatActivity {




    DatabaseHelper myDb;
    EditText jetName,jetDesc,jetID;
    Button jbtnAdd;
    Button jbtnView;
    Button jbtnUpdate;
    Button jbtnDelete;


    private DrawerLayout nDrawerLayout; //for drawerlayout
    private ActionBarDrawerToggle nToggle;//for thet toggle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        //call the dbhelper class
        myDb = new DatabaseHelper(this);


        //variables for view
        jetName = (EditText)findViewById(R.id.etName);
        jetDesc = (EditText)findViewById(R.id.etDesc);
        jetID = (EditText)findViewById(R.id.etID);
        jbtnAdd = (Button)findViewById(R.id.btnAdd);
        jbtnView = (Button)findViewById(R.id.btnView);
        jbtnUpdate = (Button)findViewById(R.id.btnUpdate);
        jbtnDelete = (Button)findViewById(R.id.btnDelete);



        //call the method
        AddData();
        viewAll();
        UpdateData();
        DeleteData();


        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);

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

    }



    public void AddData()
    {




        jbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              boolean isInserted =   myDb.insertData(jetName.getText().toString(),jetDesc.getText().toString());
                if(isInserted)
                {
                    Toast.makeText(Edit.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }else
                    {
                        Toast.makeText(Edit.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }

    public void UpdateData(){
        jbtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = myDb.updateData(jetID.getText().toString(),jetName.getText().toString(),jetDesc.getText().toString());
            if(isUpdate){
                Toast.makeText(Edit.this,"Data Updated",Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(Edit.this,"Data Not Updated",Toast.LENGTH_LONG).show();
            }
            }
        });
    }

    public void DeleteData()
    {
        jbtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will delete the id
                    Integer deletedRows = myDb.deleteData(jetID.getText().toString());
                if(deletedRows > 0){
                    Toast.makeText(Edit.this,"Data Deleted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(Edit.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void viewAll()
    {
        jbtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Cursor res = myDb.getAllData();
                if(res.getCount()==0)
                {
                    //no data
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    //append all data
                    buffer.append("ID:" + res.getString(0) + " \n");
                    buffer.append("Planet Name:" + res.getString(1) + " \n");
                    buffer.append("Planet Description : \n " + res.getString(2) + "\n\n");


                }
                //show all data
                showMessage("Planets",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
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
