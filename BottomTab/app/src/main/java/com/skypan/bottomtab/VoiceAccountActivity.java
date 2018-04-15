package com.skypan.bottomtab;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class VoiceAccountActivity extends Fragment {
    private Button mBtnButton_out;
    private HomeFragment mBvaFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_voice_account, container, false);
        mBtnButton_out = (Button) view.findViewById(R.id.va_return);
        mBtnButton_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewss) {
                if (mBvaFragment == null ){
                    mBvaFragment = new HomeFragment();
                }
                //切换页面
                getFragmentManager().beginTransaction().replace(R.id.fl_container,mBvaFragment).commitAllowingStateLoss();
            }
        });
        return view;
    }
}
