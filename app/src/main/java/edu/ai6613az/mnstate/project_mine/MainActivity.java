/**
 * Name: Thierry Oke
 * Project 1
 * description: The following program is a android prgram intend to sign people information and save it to a list and show the list of all signed
 * Date: Feb 23 2020
 * Updated: April 5, 2020
 *
 **/
package edu.ai6613az.mnstate.project_mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);

        drawer = findViewById(R.id.drawerlayout1);

        frameLayout = findViewById(R.id.fragment_container);

        navigationView.setNavigationItemSelectedListener(MainActivity.this);
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
                Intent intent2 = new Intent(MainActivity.this, List.class);
                String name2 = item.getTitle().toString();
                intent2.putExtra("activity_Name", name2);
                startActivity(intent2);
                break;


            case R.id.nav_home:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();


                break;
            }


            case R.id.nav_person_female:
            {
                Intent intent1 = new Intent(MainActivity.this, Female.class);
                String name1 = item.getTitle().toString();
                intent1.putExtra("activity_Name", name1);
                startActivity(intent1);
                break;
            }
            case R.id.nav_message: {
                Toast.makeText(getApplicationContext(), "Thanks for using Our program!", Toast.LENGTH_LONG).show();
                break;

            }

            case R.id.nav_share:
            {

                Toast.makeText(getApplicationContext(), "Shard!", Toast.LENGTH_LONG).show();


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