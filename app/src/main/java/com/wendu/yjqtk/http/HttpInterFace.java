package com.wendu.yjqtk.http;

import com.loonandroid.pc.annotation.InNet;
import com.loonandroid.pc.annotation.InPost;
import com.wendu.yjqtk.utils.Constants;

import java.util.HashMap;

/**
 * 网络接口范例 <br>
 * ----------------------------------------------- <br>
 * oooO............... <br>
 * (....) ... Oooo... <br>
 * .\..(.....(.....)....... <br>
 * ..\_)..... )../........ <br>
 * .......... (_/.......... <br>
 * 微信 gdpancheng <br>
 * -----------------------------------------------
 * 
 * @author gdpancheng@gmail.com 2015年1月7日 下午2:16:21
 * @param
 */
@InNet(Constants.HttpUrl.class)
public interface HttpInterFace {

	//---------------------------------------------------------------------------------------
	//同步
	@InPost
	public void login( HashMap<String, String> params);


}
