package com.wendu.yjqtk.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loonandroid.pc.annotation.InBinder;
import com.loonandroid.pc.annotation.InHttp;
import com.loonandroid.pc.annotation.InLayer;
import com.loonandroid.pc.annotation.InView;
import com.loonandroid.pc.annotation.Init;
import com.loonandroid.pc.handler.Handler_SharedPreferences;
import com.loonandroid.pc.listener.OnClick;
import com.loonandroid.pc.util.MD5;
import com.wendu.yjqtk.App;
import com.wendu.yjqtk.R;
import com.wendu.yjqtk.base.BaseActivity;
import com.wendu.yjqtk.http.RequestSignUtil;
import com.wendu.yjqtk.utils.Constants;
import com.wendu.yjqtk.utils.DrawableUtils;

import java.util.HashMap;

@InLayer(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    @InView
    EditText et_count,et_psw;
    @InView(binder = @InBinder(listener = OnClick.class, method = "click"))
    Button buttontjdl,textwjmm,textzhuce;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Init
    private void init(){
        et_count.setBackground(DrawableUtils.createDrawable(Color.WHITE,Color.BLACK,10));
        et_psw.setBackground(DrawableUtils.createDrawable(Color.WHITE,Color.BLACK,10));
        buttontjdl.setBackground(DrawableUtils.createSeletorCGB(10));
    }

    private  void click(View view){
        switch (view.getId()){
            case R.id.buttontjdl:
                login();
                break;
            case R.id.textwjmm:
                break;
            case R.id.textzhuce:
                break;
            default:
                break;
        }
    }

    private void login(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("UserAccount", "kaifaceshi");
        map.put("PasswordMD5", MD5.Md5("123456"));
        map.put("OtherType", String.valueOf(0));
        map.put("OtherAccount", null);
        map.put("UserID",0+"");
        map.put("ProductID", "11");
        map.put("Sign", RequestSignUtil.signRequest(map, getSecretKey()));
        App.app.http.u(this).login(map);
    }
    @InHttp
    private void OnResult(){

    }


    /**
     * 获取本次secretkey
     *
     * @return
     *
     * @author Michael Zhang (zhangyi_0820@qq.com) <br>
     *         2015年5月18日上午10:58:24
     */
    public String getSecretKey() {
        String key = Handler_SharedPreferences.getValueByName("userinfo", Constants.DEFAULT_SECRETKEY, Handler_SharedPreferences.STRING);
        if (TextUtils.isEmpty(key)) {
            key = Constants.DEFAULT_SECRETKEY;
        }
        return key;
    }


}
