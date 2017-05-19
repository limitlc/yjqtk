package com.wendu.yjqtk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by lichuang on 2017/5/18.
 */
public class NoTouchScrollView extends ScrollView {
    public NoTouchScrollView(Context context) {
        super(context);
    }

    public NoTouchScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoTouchScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
