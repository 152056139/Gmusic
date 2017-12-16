package com.gray.gmusic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.gray.gmusic.fragment.MineFragment;
import com.gray.gmusic.fragment.RecommendFragment;
import com.gray.gmusic.fragment.SearchFragment;
import com.gray.gmusic.fragment.TaogeFragment;


public class MainActivity extends FragmentActivity {

    //类
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        Fragment fragment = null;

        private MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment = new MineFragment();

                    break;
                case 1:
                    fragment = new TaogeFragment();

                    break;
                case 2:
                    fragment = new SearchFragment();

                    break;
                case 3:
                    fragment = new RecommendFragment();

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

    //声明
    MyFragmentPagerAdapter myFragmentPagerAdapterMain;
    ViewPager viewPagerMain;
    RadioGroup radioGroupMain;

    //初始化
    private void setupView() {
        myFragmentPagerAdapterMain = new MyFragmentPagerAdapter(getSupportFragmentManager());

        viewPagerMain = (ViewPager) findViewById(R.id.vp_main);

        radioGroupMain = (RadioGroup) findViewById(R.id.rg_main);
    }

    public void setAdapterOnViewPagerMain(){
        viewPagerMain.setAdapter(myFragmentPagerAdapterMain);
    }
    public void setOnCheckedChangeListenerOnRadioGroupMain(){
        radioGroupMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_mine:
                        viewPagerMain.setCurrentItem(0);
                        break;
                    case R.id.rb_taoge:
                        viewPagerMain.setCurrentItem(1);
                        break;
                    case R.id.rb_search:
                        viewPagerMain.setCurrentItem(2);
                        break;
                    case R.id.rb_recommend:
                        viewPagerMain.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    //生命周期
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setAdapterOnViewPagerMain();
        setOnCheckedChangeListenerOnRadioGroupMain();

    }
}
