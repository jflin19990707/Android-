package com.example.exp1.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.exp1.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPagerWithTabActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 2;
    private ArrayList mTitle;
    private ArrayList mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_with_tab);
        ViewPager pager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        mTitle = new ArrayList<>();
        mTitle.add("热搜榜");
        mTitle.add("正能量");

        mFragment = new ArrayList<>();
        mFragment.add(new Myfragment());
        mFragment.add(new Myfragment2());

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return (Fragment) mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override

            public CharSequence getPageTitle(int position) {
                return (CharSequence) mTitle.get(position);
            }
        });
        tabLayout.setupWithViewPager(pager);
    }
}
