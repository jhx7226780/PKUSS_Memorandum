package com.skypan.bottomtab;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 简书ID：天哥在奔跑
 * 原创Android教程：http://www.jianshu.com/p/9618c038135f
 * 教程答疑专用QQ群：667833258
 */
public class HomeFragment extends Fragment {
    private Button mBtnWButton;
    private Button mBtnVButton;
    private Button mBtnLButton;
    private Button mBtnAButton;
    private WriteAccountActivity mBFragment_2;
    private VoiceAccountActivity mBFragment_3;
    private LocationAccountActivity mBFragment_4;
    private AutoAccountActivity mBFragment_5;
    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        mBtnWButton = (Button) view.findViewById(R.id.fh_WrittenAcc);
        mBtnWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                if (mBFragment_2 == null ){
                    mBFragment_2 = new WriteAccountActivity();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBFragment_2).commitAllowingStateLoss();

            }
        });
        mBtnVButton = (Button) view.findViewById(R.id.fh_VoiceAcc);
        mBtnVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                if (mBFragment_3 == null ){
                    mBFragment_3 = new VoiceAccountActivity();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBFragment_3).commitAllowingStateLoss();

            }
        });
        mBtnLButton = (Button) view.findViewById(R.id.fh_LocationAcc);
        mBtnLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                if (mBFragment_4 == null ){
                    mBFragment_4 = new LocationAccountActivity();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBFragment_4).commitAllowingStateLoss();

            }
        });
        mBtnAButton = (Button) view.findViewById(R.id.fh_AutoAccount);
        mBtnAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                if (mBFragment_5 == null ){
                    mBFragment_5 = new AutoAccountActivity();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBFragment_5).commitAllowingStateLoss();

            }
        });
        return view;
    }

}
