package com.skypan.bottomtab;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 简书ID：天哥在奔跑
 * 原创Android教程：http://www.jianshu.com/p/9618c038135f
 * 教程答疑专用QQ群：667833258
 */
public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgTab;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgTab = (RadioGroup) findViewById(R.id.rg_main);
        mRgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        changeFragment(HomeFragment.class.getName());
                        break;
                    case R.id.rb_phone_book:
                        changeFragment(PhoneBookFragment.class.getName());
                        break;
                    case R.id.rb_me:
                        changeFragment(MeFragment.class.getName());
                        break;
                }
            }
        });
        if(savedInstanceState == null){
            changeFragment(HomeFragment.class.getName());
        }
    }

    /**
     * show target fragment
     *
     * @param tag
     */
    public void changeFragment(String tag) {
        hideFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            if (tag.equals(HomeFragment.class.getName())) {
                fragment = HomeFragment.newInstance();
            } else if (tag.equals(PhoneBookFragment.class.getName())) {
                fragment = PhoneBookFragment.newInstance();
            } else if (tag.equals(FindFragment.class.getName())) {
                fragment = FindFragment.newInstance();
            } else if (tag.equals(MeFragment.class.getName())) {
                fragment = MeFragment.newInstance();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.fl_container, fragment, fragment.getClass().getName());
        }
        transaction.commitAllowingStateLoss();

    }

    /**
     * hide all fragment
     */
    private void hideFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        for (Fragment f : mFragmentList) {
            ft.hide(f);
        }
        ft.commit();
    }
}
