package com.wendu.yjqtk.base;

import android.app.Activity;

/**
 * Created by lichuang on 2017/5/18.
 */
public class BaseActivity extends Activity {

    //获取到前台进程的activity
    private static Activity mForegroundActivity = null;

    @Override
    protected void onResume() {
        super.onResume();
        this.mForegroundActivity = this;

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.mForegroundActivity = null;
    }

    public static  Activity getForegroundActivity(){
        return mForegroundActivity;
    }

}
