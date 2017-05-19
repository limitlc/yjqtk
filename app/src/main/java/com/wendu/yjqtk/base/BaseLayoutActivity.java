package com.wendu.yjqtk.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.loonandroid.pc.annotation.InAll;
import com.loonandroid.pc.annotation.InBinder;
import com.loonandroid.pc.annotation.InLayer;
import com.loonandroid.pc.annotation.Init;
import com.loonandroid.pc.listener.OnClick;
import com.wendu.yjqtk.R;
import com.wendu.yjqtk.utils.DrawableUtils;
import com.wendu.yjqtk.utils.UIUtils;

/**
 * Created by lichuang on 2017/5/19.
 */
@InLayer(R.layout.layout_baselayout_activity)
public class BaseLayoutActivity extends BaseActivity{
    @InAll
    private Views title_content;
    static class Views{
        @InBinder(listener = OnClick.class,method = "click")
        Button btn_right;
        @InBinder(listener = OnClick.class,method = "click")
        ImageButton ibtn_left,ibtn_right,ibtn_delete;
        @InBinder(listener = OnClick.class,method = "click")
        TextView tv_left,tv_title,tv_notice;
        View view_new_status_bar;
        EditText ed_search;
    }

    /**
     * 初始化title 将通用的title中控件设置背景色
     *
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Init
    private void initTitle(){
        title_content.ibtn_left.setBackground(DrawableUtils.createSeletorTB(5));
        title_content.ibtn_right.setBackground(DrawableUtils.createSeletorTB(5));
        title_content.ibtn_delete.setBackground(DrawableUtils.createSeletorTB(5));
        title_content.btn_right.setBackground(DrawableUtils.createSeletorTB(5));
        title_content.ed_search.setBackground(DrawableUtils.createDrawable(UIUtils.getColor(R.color.base_green_deep),UIUtils.getColor(R.color.base_white),10));
    }

    private void click(View view){
        
    }

}
