package com.example.mad_instragram;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mad_instragram.ui.dashboard.DashboardFragment;
import com.example.mad_instragram.ui.home.HomeFragment;
import com.example.mad_instragram.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Home extends AppCompatActivity {
    Fragment selectedFragment;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListner);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListner=
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        selectedFragment=new HomeFragment();
                        break;

                    case R.id.search:
                        selectedFragment=new DashboardFragment();
                        break;
                    case R.id.plus:

                        break;
                    case R.id.heart:
                        break;
                    case R.id.profile:
                        selectedFragment=new NotificationsFragment();
                        break;
                }
                if (selectedFragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,selectedFragment).commit();
                }
                return true;
            }
        };
}
// Passing each menu ID as a set of Ids because each
// menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.search, R.id.plus,R.id.heart,R.id.profile)
//                .build();
//        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        NavController navController=navHostFragment.getNavController();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//NavigationUI.setupWithNavController(navView, navController);