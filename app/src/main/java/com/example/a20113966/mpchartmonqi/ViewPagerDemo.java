package com.example.a20113966.mpchartmonqi;

/**
 * Created by 20113966 on 10-09-2016.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ViewPagerDemo extends FragmentActivity
{

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    LinearLayout llPagerTab;

    // we are going to use a handler to be able to run in our TimerTask
    private final Handler handler = new Handler();
    private ArrayList<String> imageArray = new ArrayList<String>();

    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0; i<4 ; i++)
            imageArray.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2015/04/india-wallpaper-7.jpg");


        List<Fragment> fragments = new Vector<Fragment>();

//for each fragment you want to add to the pager
        Bundle page = new Bundle();
        page.putString("url", "Hello India");
        fragments.add(Fragment.instantiate(this,MyFragment.class.getName(),page));


        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        llPagerTab= (LinearLayout) findViewById(R.id.llPagerTab);
        mViewPager.setAdapter(mCustomPagerAdapter);
        refreshPageController();
        startViewPager();

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int postion)
            {


                for (int i = 0; i <= (mCustomPagerAdapter.getCount()-1); i++)
                {
                    ((ImageView)llPagerTab.getChildAt(i)).setImageResource(R.drawable.nonselecteditem_dot);
                }
                ((ImageView)llPagerTab.getChildAt(postion)).setImageResource(R.drawable.selecteditem_dot);

            }

            @Override
            public void onPageScrolled(int postion, float arg1, int arg2)
            {
            }

            @Override
            public void onPageScrollStateChanged(int postion)
            {


            }
        });


    }

    private void refreshPageController()
    {
        int pagerPosition = 0;
        llPagerTab.removeAllViews();
        for (int i = 0; i <= (mCustomPagerAdapter.getCount()-1); i++)
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            final ImageView imgvPagerController = new ImageView(ViewPagerDemo.this);
            imgvPagerController.setPadding(7,8,7,8);

            imgvPagerController.setImageResource(R.drawable.nonselecteditem_dot);


            llPagerTab.addView(imgvPagerController);
        }

        pagerPosition = mViewPager.getCurrentItem();

        if(((ImageView)llPagerTab.getChildAt(pagerPosition)) != null)
            ((ImageView)llPagerTab.getChildAt(pagerPosition)).setImageResource(R.drawable.selecteditem_dot);

    }


    private class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        List<Fragment> fragments;


        public CustomPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragments) {
            super(fm);
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.fragments = fragments;
        }


        @Override
        public int getCount() {
            return imageArray.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        Display display = getWindowManager().getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();

        public Fragment getItem(int pos) {

            switch (pos) {

                case 0:
                    return LineChartFragment.newInstance("FirstFragment, Instance 1");
                case 1:
                    return LineChartFragment.newInstance("SecondFragment, Instance 1");
                case 2:
                    return LineChartFragment.newInstance("ThirdFragment, Instance 1");
                case 3:
                    return LineChartFragment.newInstance("ThirdFragment, Instance 2");
                case 4:
                    return LineChartFragment.newInstance("ThirdFragment, Instance 3");
                default:
                    return LineChartFragment.newInstance("ThirdFragment, Default");
            }
        }

    }

    private void startViewPager() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while (j <= mCustomPagerAdapter.getCount()) {
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(j, true);
                            if (j >= mCustomPagerAdapter.getCount())
                                j = 0;
                            else
                                j++;

                        }
                    });


                }
            }
        };
        new Thread(runnable).start();
    }



}
