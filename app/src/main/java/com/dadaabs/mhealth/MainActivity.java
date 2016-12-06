package com.dadaabs.mhealth;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dadaabs.mhealth.Fragments.GeneralHealth;
import com.dadaabs.mhealth.Fragments.HygeneTips;
import com.dadaabs.mhealth.Fragments.MotherCare;
import com.dadaabs.mhealth.Fragments.TabsFragment;
import com.dadaabs.mhealth.UpdateDatabase.UpdateGeneralHealth;

public class MainActivity extends AppCompatActivity
        implements
        GeneralHealth.OnHomeTabFragListener, HygeneTips.OnHomeTabFragListener,
        MotherCare.OnHomeTabFragListener{


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;

    private TabsFragment tabsFragment;
    Fragment mfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Check whether the activity is using the layout version with
        // the container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                //return;
                //Restore the fragment's instance
                mfragment = getSupportFragmentManager().getFragment(savedInstanceState, "mfragment");
            }

            // Create an instance of TabsFragment
            tabsFragment = new TabsFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            tabsFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, tabsFragment).commit();
            //initInstances();
        }else {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of TabsFragment
            tabsFragment = new TabsFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            tabsFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, tabsFragment).commit();
            //initInstances();
        }



    }

    @Override
    public void onBackPressed() {

        if (!tabsFragment.onBackPressed()) {
            // container Fragment or its associates couldn't handle the back pressed task
            // delegating the task to super class
            super.onBackPressed();

        } else {
            // tabsFragment handled the back pressed task
            // do not call super
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void itemClicked(int pos, long id) {
        /*
        *  USAGES: LiveNewsFrag & NoticeBoardFrag
         */
    }

    /**
     * CODE FOR NAVIGATION DRAWER
     */

//    private void initInstances() {
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.welcome, R.string.welcome);
//        drawerLayout.addDrawerListener(drawerToggle);
//
//
//
//        //Initializing NavigationView
//        navigation = (NavigationView) findViewById(R.id.navigation_view);
//
//        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
//        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                switch (id) {
//                    case R.id.navigation_item_1:
//                        //Do some thing here
//                        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//                        startActivity(loginIntent);
//                        break;
//                    case R.id.navigation_item_5:
//                        //Do some thing here
//                        break;
//
//                    case R.id.navigation_item_3:
//                        //Do some thing here
//                        break;
//                    case R.id.navigation_item_4:
//                        //Do some thing here
//                        break;
////
//                    case R.id.nv_updatenoticeboard:
//                        //Do some thing here
//                        Intent noticeBoardIntent = new Intent(MainActivity.this, UpdateNoticeBoard.class);
//                        startActivity(noticeBoardIntent);
//                        break;
//                    case R.id.navigation_item_8:
//                        //Do some thing here
//                        Intent newsIntent = new Intent(MainActivity.this, UpdateNews.class);
//                        startActivity(newsIntent);
//                        break;
//
//                }
//                return false;
//            }
//        });//end oclick listener
//
//    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item))
//            return true;
//
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        } else if (id == R.id.action_addcamp) {
//            Intent addcampIntent = new Intent(MainActivity.this, UpdateNews.class);
//            startActivity(addcampIntent);
//            return true;
//        }else if(id == R.id.home){
//            onBackPressed();
//            return true;
//
//        }else if(id == R.id.action_helpdesk) {
//            Intent helpdeskIntent = new Intent(MainActivity.this, UpdateTownInfo.class);
//            startActivity(helpdeskIntent);
//            return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item))
//            return true;

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_gen_health) {
            Intent genHealthIntent = new Intent(MainActivity.this, AboutApp.class);
            startActivity(genHealthIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, "mfragment", tabsFragment);
    }


}// Ends Main Class