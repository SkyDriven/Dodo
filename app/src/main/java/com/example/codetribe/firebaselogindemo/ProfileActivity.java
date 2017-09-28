package com.example.codetribe.firebaselogindemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

/**
 * Created by codetribe on 9/15/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment fragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.syncState();

        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new ProfileFragment();
        fragmentTransaction.replace(R.id.main_container_wrapper,fragment);
        fragmentTransaction.commit();

        NavigationView navigationView = findViewById(R.id.nav_view);
        disableNavigationViewScrollbars(navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();

               if(id==R.id.nav_profile)
               {
                   fragment = new ProfileFragment();
               }else if(id == R.id.nav_chat)
               {

               }else if(id == R.id.nav_contact)
               {

               }else if(id == R.id.nav_online)
               {

               }else if(id == R.id.nav_settings)
               {

               }else if(id == R.id.nav_logout)
               {

               }

               FragmentTransaction transaction = fragmentManager.beginTransaction();
               transaction.replace(R.id.main_container_wrapper,fragment);
               transaction.commit();

               DrawerLayout drawer = findViewById(R.id.drawer_layout);
               assert drawer != null;
               drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        private void disableNavigationViewScrollbars( NavigationView navigationView)
    {
        if(navigationView!=null)
        {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if(navigationMenuView!=null)
            {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }

    }
    }
}
