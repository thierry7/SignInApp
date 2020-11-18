package edu.ai6613az.mnstate.project_mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FrameLayout frameLayout;
    NavigationView navigationView;
    TextView  textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawerlayout1);
        navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        frameLayout = findViewById(R.id.fragment_container);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_home);







    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        if (item.isChecked()){
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

        // Handle navigation view item clicks here.
        switch (item.getItemId())
        {
            case R.id.nav_list :
                Intent intent = new Intent(Home.this, List.class);
                String name = item.toString();
                intent.putExtra("activity_Name", name);
                startActivity(intent);

                break;


            case R.id.nav_home:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();


                break;
            }


            case R.id.nav_person_female:
            {
                Intent intent1 = new Intent(Home.this, Female.class);
                String name1 = item.getTitle().toString();
                intent1.putExtra("activity_Name", name1);
                startActivity(intent1);
                break;
            }

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);

        }
        else {


            super.onBackPressed();
        }
    }



}