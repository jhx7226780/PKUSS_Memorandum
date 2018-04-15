package com.skypan.bottomtab;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LocationAccountActivity extends Fragment {

    private Button mBtnButton_save;
    private Button mBtnButton_out;
    private HomeFragment mBwaFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_location_account, container, false);

        mBtnButton_save = (Button) view.findViewById(R.id.la_safe_button);
        mBtnButton_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                Toast.makeText(getActivity(), "保存成功" , Toast.LENGTH_LONG).show();
                if (mBwaFragment == null ){
                    mBwaFragment = new HomeFragment();
                }
                //切换页面
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBwaFragment).commitAllowingStateLoss();
            }
        });
        mBtnButton_out = (Button) view.findViewById(R.id.la_return);
        mBtnButton_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewss) {
                if (mBwaFragment == null ){
                    mBwaFragment = new HomeFragment();
                }
                //切换页面
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBwaFragment).commitAllowingStateLoss();
            }
        });
        return view;
    }
}
