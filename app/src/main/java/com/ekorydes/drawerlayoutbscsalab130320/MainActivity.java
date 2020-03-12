package com.ekorydes.drawerlayoutbscsalab130320;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView objectNavigationView;
    private ImageView headerIV;

    private DrawerLayout objectDrawerLayout;
    private Toolbar objectToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedObjects();
    }

    private void getStartedObjects()
    {
        try
        {
            objectNavigationView=findViewById(R.id.navigationView);
            View navHeader=objectNavigationView.getHeaderView(0);

            headerIV=navHeader.findViewById(R.id.header_profileIV);
            objectDrawerLayout=findViewById(R.id.drawerLayout);

            objectToolbar=findViewById(R.id.ourToolBar);
            headerIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Image is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            objectNavigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            if(item.getItemId()==R.id.item_songs)
                            {
                                Toast.makeText(MainActivity.this, "Songs here", Toast.LENGTH_SHORT).show();
                                closeMyDrawer();
                                return true;
                            }
                            else if(item.getItemId()==R.id.item_search)
                            {
                                Toast.makeText(MainActivity.this, "Search here", Toast.LENGTH_SHORT).show();
                                closeMyDrawer();
                                return true;
                            }
                            return false;
                        }
                    }
            );

            setUpHamBurgerIcon();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "getStartedObjects:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void closeMyDrawer()
    {
       try {
           objectDrawerLayout.closeDrawer(GravityCompat.START);
       }
       catch (Exception e)
       {
           Toast.makeText(this, "closeMyDrawer:"+e.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }

    private void setUpHamBurgerIcon()
    {
        try
        {
            ActionBarDrawerToggle objectActionBarDrawerToggle=new ActionBarDrawerToggle(
                    this,
                    objectDrawerLayout,
                    objectToolbar,
                    R.string.open
                    ,R.string.close
            );

            objectActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.
                    color.colorPrimary));

            objectActionBarDrawerToggle.syncState();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
