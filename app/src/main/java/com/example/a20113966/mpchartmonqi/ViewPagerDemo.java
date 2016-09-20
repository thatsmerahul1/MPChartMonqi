package com.example.a20113966.mpchartmonqi;

/**
 * Created by 20113966 on 10-09-2016.
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerDemo extends FragmentActivity
{

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    LinearLayout llPagerTab;

    // we are going to use a handler to be able to run in our TimerTask
    private final Handler handler = new Handler();

    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new LineChartFragment1());
        fragments.add(new LineChartFragment2());
        fragments.add(new LineChartFragment3());
        fragments.add(new LineChartFragment4());


        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        llPagerTab= (LinearLayout) findViewById(R.id.llPagerTab);
        mViewPager.setAdapter(mCustomPagerAdapter);
        refreshPageController();

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int postion)
            {


                for (int i = 0; i <= (mCustomPagerAdapter.getCount()-1); i++)
                {
                    ((ImageView)llPagerTab.getChildAt(i)).setImageResource(R.drawable.nonselecteditem_dot);
                }
                if(postion == 0)
                    ((ImageView)llPagerTab.getChildAt(postion)).setImageResource(R.drawable.selecteditem_blue_dot);
                else if(postion == 1)
                ((ImageView)llPagerTab.getChildAt(postion)).setImageResource(R.drawable.selecteditem_yellow_dot);
                else if(postion == 2)
                    ((ImageView)llPagerTab.getChildAt(postion)).setImageResource(R.drawable.selecteditem_blue_dot);
                else if(postion == 3)
                    ((ImageView)llPagerTab.getChildAt(postion)).setImageResource(R.drawable.selecteditem_purpple_dot);
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
            ((ImageView)llPagerTab.getChildAt(pagerPosition)).setImageResource(R.drawable.selecteditem_blue_dot);

    }


    private class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        List<Fragment> listFragments;

        public CustomPagerAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments) {
            super(fm);
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.listFragments = fragments;
        }



        @Override
        public int getCount() {
            if(listFragments != null)
                return listFragments.size();
            else
                return 4;
        }


        @Override
        public Fragment getItem(int pos) {

                return listFragments.get(pos);
        }
    }

}
