package com.example.android.charityruns;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomBar();
    }



    void setupBottomBar(){
        OnTabSelectListener onTabSelectListener = new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                Fragment fragment = null;
                Class fragmentClass = null;
                if(tabId==R.id.tab_map){


                    fragmentClass = MapFragment.class;
                }
                else if(tabId==R.id.tab_info){
                    fragmentClass = InfoFragment.class;
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        };

        ((BottomBar)findViewById(R.id.bottomBar)).setOnTabSelectListener(onTabSelectListener);

    }

}
