package com.example.menupropio;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbarView;
    DrawerLayout drawerLayoutView;
    BottomNavigationView bottomNavigationMenuView;

    private Home homeFragment = new Home();
    private Apps appsFragment = new Apps();
    private Settings settingsFragment = new Settings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        toolbarView = findViewById(R.id.toolbar);
        drawerLayoutView = findViewById(R.id.drawer_layout);


        setSupportActionBar(toolbarView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayoutView, toolbarView, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayoutView.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavigationMenuView = findViewById(R.id.bottom_navigation);

        bottomNavigationMenuView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.menu_item_home) {
                cambiarFragment(homeFragment);
                return true;
            } else if (item.getItemId() == R.id.menu_item_apps) {
                cambiarFragment(appsFragment);
            } else if (item.getItemId() == R.id.menu_item_settings) {
                cambiarFragment(settingsFragment);
            }
            return true;
        });
    }

    private void cambiarFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_layout, fragment);
        transaction.commit();
    }
}