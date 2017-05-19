/**
 * Copyright (C) 2015 Michael Zhang (zhangyi_0820@qq.com) 2015年5月4日 下午4:58:42
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wendu.yjqtk.http;

import com.wendu.yjqtk.utils.Constants;

import org.apache.http.protocol.HTTP;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;



/**
 * 接口提交字段加密
 * 
 * @author Michael Zhang (zhangyi_0820@qq.com) <br>
 *         2015年5月4日下午4:58:42
 */
public class RequestSignUtil {
	/**
	 * 生成数字签名
	 * 
	 * @param params
	 * @param secret
	 * @return
	 * 
	 * @author Michael Zhang (zhangyi_0820@qq.com) <br>
	 *         2015年5月6日下午5:52:33
	 */
	public static String signRequest(Map<String, String> params, String secret) {
		String[] keys = null;

		if (null != params && params.size() > 0) {
			// 第一步：检查参数是否已经排序
			keys = params.keySet().toArray(new String[0]);
			Arrays.sort(keys);
		}

		// 第二步：把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		query.append(secret); // 头加密钥
		if (null != keys && keys.length > 0) {
			for (String key : keys) {
				String value = params.get(key);
				query.append(key).append(value);
			}
		}
		query.append(secret); // 尾加密钥
		// 第三步：使用MD5加密
		byte[] bytes = encodeMD5(query.toString());
		// 第四步：转化为大写的十六进制
		return byte2hex(bytes);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * 
	 * @author Michael Zhang (zhangyi_0820@qq.com) <br>
	 *         2015年5月6日下午5:55:05
	 */
	private static byte[] encodeMD5(String data) {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance(Constants.SECRET_MD5);
			bytes = md.digest(data.getBytes(HTTP.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(bytes[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bytes;
	}

	/**
	 * 转化为大写的十六进制
	 * 
	 * @param bytes
	 * @return
	 * 
	 * @author Michael Zhang (zhangyi_0820@qq.com) <br>
	 *         2015年5月6日下午5:55:11
	 */
	private static String byte2hex(byte[] bytes) {
		if (null != bytes) {
			StringBuilder sign = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(bytes[i] & 0xFF);
				if (hex.length() == 1) {
					sign.append("0");
				}
				sign.append(hex.toUpperCase());
			}
			return sign.toString();
		}

		return null;
	}
}
