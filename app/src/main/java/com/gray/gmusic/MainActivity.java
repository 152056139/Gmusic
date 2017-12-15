package com.gray.gmusic;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.gray.gmusic.fragment.MineFragment;
import com.gray.gmusic.fragment.RecommendFragment;
import com.gray.gmusic.fragment.SearchFragment;
import com.gray.gmusic.fragment.TaogeFragment;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends FragmentActivity {

    //声明
    MyFragmentPagerAdapter myFragmentPagerAdapter;
    ViewPager viewPager;
    RadioGroup radioGroupMain;

    //类
    class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        Fragment fragment = null;

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    fragment = new MineFragment();
                    radioGroupMain.check(R.id.rb_mine);
                    break;
                case 1:
                    fragment = new TaogeFragment();
                    radioGroupMain.check(R.id.rb_taoge);
                    break;
                case 2:
                    fragment = new SearchFragment();
                    radioGroupMain.check(R.id.rb_search);
                    break;
                case 3:
                    fragment = new RecommendFragment();
                    radioGroupMain.check(R.id.rb_recommend);
                    break;
                default:
                    break;
            }
            return fragment;
        }
        @Override
        public int getCount() {
            return 4;
        }
    }


    //初始化
    private void setupView(){
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.vp_main);
        radioGroupMain = (RadioGroup) findViewById(R.id.rg_main);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        viewPager.setAdapter(myFragmentPagerAdapter);

    }
}
