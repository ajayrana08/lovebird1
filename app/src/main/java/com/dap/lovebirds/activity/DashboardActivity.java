package com.dap.lovebirds.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dap.lovebirds.R;
import com.dap.lovebirds.enjoy.EnjoyFragment;
import com.dap.lovebirds.love.LoveFragment;
import com.dap.lovebirds.meet.MeetFragment;
import com.dap.lovebirds.more.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    private ImageView ivNavIcon;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar1;
    private TextView tvtoolbar, tvlogout, tvlove, tvmeet, tvenjoyee, tvmore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ivNavIcon = findViewById(R.id.navIcon);
        drawerLayout = findViewById(R.id.drawer);
        toolbar1 = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.navigationView);
        tvtoolbar = findViewById(R.id.tv_title);
        tvlogout = findViewById(R.id.logout);
        tvlove = findViewById(R.id.love);
        tvmeet = findViewById(R.id.meet);
        tvenjoyee = findViewById(R.id.enjoy);
        tvmore = findViewById(R.id.more);

        ivNavIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.openDrawer(Gravity.START);
                } else {
                    drawerLayout.closeDrawer(Gravity.START);
                }
            }
        });
        LoveFragmentOpen();
        tvlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvlove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer();
                LoveFragmentOpen();
                tvtoolbar.setText("Love");

            }
        });
        tvmeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer();
               MeetFragmentOpen();
                tvtoolbar.setText("MEET AT CHANDIGARH");

            }
        });
        tvenjoyee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer();
                EnjoyFragmentOpen();
                tvtoolbar.setText("ENJOY ALOT WITH BAE");

            }
        });
        tvmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer();
                MoreFragmentOpen();
                tvtoolbar.setText("MORE MASTI");

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_love:
                        tvtoolbar.setText("Love");
                        LoveFragmentOpen();
                        break;

                    case R.id.navigation_meet:
                        tvtoolbar.setText("MEET AT CHANDIGARH");
                        MeetFragmentOpen();
                        break;

                    case R.id.navigation_Enjoy:
                        tvtoolbar.setText("ENJOY ALOT WITH BAE");
                        EnjoyFragmentOpen();
                        break;
                    case R.id.navigation_More:
                        tvtoolbar.setText("MORE MASTI");
                       MoreFragmentOpen();
                        break;

                }
                return true;
            }

        });


    }

    private void LoveFragmentOpen() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoveFragment loveFragment = new LoveFragment();
        fragmentTransaction.replace(R.id.frame_container, loveFragment);
        fragmentTransaction.commit();
    }

    private void MeetFragmentOpen() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MeetFragment meetFragment = new MeetFragment();
        fragmentTransaction.replace(R.id.frame_container, meetFragment);
        fragmentTransaction.commit();
    }

    private void EnjoyFragmentOpen() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EnjoyFragment enjoyFragment = new EnjoyFragment();
        fragmentTransaction.replace(R.id.frame_container, enjoyFragment);
        fragmentTransaction.commit();
    }

    private void MoreFragmentOpen() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MoreFragment moreFragment = new MoreFragment();
        fragmentTransaction.replace(R.id.frame_container, moreFragment);
        fragmentTransaction.commit();
    }

    @SuppressLint("WrongConstant")
    public void openCloseDrawer() {
        if (!drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.openDrawer(Gravity.START);
        } else {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }
}
