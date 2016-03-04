package com.example.timetable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class ScrollActivity extends FragmentActivity implements TabListener {

    ViewPager viewPager = null;
    int currentItem=0;
    ActionBar actionBar;
    SimpleDateFormat format;
    String day;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_scroll);

        actionBar = getActionBar();
        actionBar.setTitle("");
        actionBar.setIcon(android.R.color.transparent);


        FragmentManager fragmentManager = getSupportFragmentManager();

        Bundle bundle;

        bundle = getIntent().getExtras();

        if(bundle!= null)
            list = bundle.getStringArrayList("List");







        format = new SimpleDateFormat("EEE");
        Date date = new Date();

        day = format.format(date.getTime());

        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

                currentItem=viewPager.getCurrentItem();

                actionBar.setSelectedNavigationItem(arg0);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Monday");
        tab1.setTabListener(this);
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Tuesday");
        tab2.setTabListener(this);
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Wednesday");
        tab3.setTabListener(this);
        actionBar.addTab(tab3);


        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(0xff212121);
        actionBar.setBackgroundDrawable(colorDrawable);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        ActionBar.Tab tab4 = actionBar.newTab();
        tab4.setText("Thursday");
        tab4.setTabListener(this);
        actionBar.addTab(tab4);

        ActionBar.Tab tab5 = actionBar.newTab();
        tab5.setText("Friday");
        tab5.setTabListener(this);
        actionBar.addTab(tab5);

        ActionBar.Tab tab6 = actionBar.newTab();
        tab6.setText("Saturday");
        tab6.setTabListener(this);
        actionBar.addTab(tab6);

        ActionBar.Tab tab7 = actionBar.newTab();
        tab7.setText("Sunday");
        tab7.setTabListener(this);
        actionBar.addTab(tab7);

        // setting the launcher fragment as the day shown in mobile
        if (day.equalsIgnoreCase("MON"))
        {
            actionBar.setSelectedNavigationItem(0);
        }

        else if (day.equalsIgnoreCase("TUE")) {
            actionBar.setSelectedNavigationItem(1);
        }

        else if (day.equalsIgnoreCase("WED")) {
            actionBar.setSelectedNavigationItem(2);
        }

        else if (day.equalsIgnoreCase("THU")) {
            actionBar.setSelectedNavigationItem(3);
        }

        else if (day.equalsIgnoreCase("FRI")) {
            actionBar.setSelectedNavigationItem(4);
        }

        else if (day.equalsIgnoreCase("SAT")) {
            actionBar.setSelectedNavigationItem(5);
        }

        else if (day.equalsIgnoreCase("SUN")) {

            actionBar.setSelectedNavigationItem(6);
        }


        Intent intent=getIntent();
        int count=intent.getIntExtra("Position", 0);
        boolean state=intent.getBooleanExtra("TrueVal", false);
        if(state)
        {
            actionBar.setSelectedNavigationItem(count);
        }




    }

    public int getCurrentItem()
    {

        return viewPager.getCurrentItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scroll, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.add) {

            int a = viewPager.getCurrentItem();

            Intent i = new Intent(this, SujectEntryActivity.class);
            i.putExtra("Position", viewPager.getCurrentItem());
            Bundle bundlePassList = new Bundle();
            bundlePassList.putStringArrayList("List", list);
            i.putExtras(bundlePassList);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //super.onBackPressed();
        onShowQuitDialog();

    }

    public void onShowQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        builder.setMessage("Do You Want To Quit?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }


}

class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        Fragment fragment = null;

        if (arg0 == 0) {
            fragment = new FragmentMonday();
        }

        if (arg0 == 1) {
            fragment = new FragmentTuesday();
        }

        if (arg0 == 2) {
            fragment = new FragmentWednesday();
        }

        if (arg0 == 3) {
            fragment = new FragmentThursday();
        }

        if (arg0 == 4) {
            fragment = new FragmentFriday();
        }

        if (arg0 == 5) {
            fragment = new FragmentSaturday();
        }

        if (arg0 == 6) {
            fragment = new FragmentSunday();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 7;
    }



}