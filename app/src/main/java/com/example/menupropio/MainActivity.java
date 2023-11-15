package com.example.menupropio;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbarView = findViewById(R.id.toolbar);
        DrawerLayout drawerLayoutView = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbarView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayoutView, toolbarView, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayoutView.addDrawerListener(toggle);
        toggle.syncState();
    }
}