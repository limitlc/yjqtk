package com.wendu.yjqtk.activity;

import android.widget.TextView;

import com.loonandroid.pc.annotation.InLayer;
import com.loonandroid.pc.annotation.InView;
import com.loonandroid.pc.annotation.Init;
import com.wendu.yjqtk.R;
import com.wendu.yjqtk.base.BaseActivity;

@InLayer(R.layout.layout_main_activity)
public class MainActivity extends BaseActivity {
    @InView
    private TextView textview;

    @Init
    private void init() {


    }

}
