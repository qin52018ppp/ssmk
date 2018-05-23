package com.baobao.framework.support.utility;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 保保网络科技-framework
 * com.baobao.framework.support.utility
 * 作者-秦岭(Tain)
 * 说明：
 * 2016/8/19 21:26
 * 2016保保网络-版权所有
 */
public class MobileUtility {

    private static  final String httpUrl = "http://apis.baidu.com/apistore/mobilephoneservice/mobilephone";
    private static Logger logger = Logger.getLogger(MobileUtility.class);

    /**
     *            :请求接口
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String mobile) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?tel=" + mobile;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "28bf4d1ffd72e00c192002e8e9957632");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getProvince(String mobile) {
        try {
            String result = request(httpUrl, mobile);
            logger.info("mobile:" + mobile + ",result" + result);
            JSONObject rr = JSONObject.parseObject(result);
            JSONObject r = (JSONObject) rr.get("retData");
            return r.get("province").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "未知";
        }
    }

    public static void main(String[] args) {
        System.out.print(getProvince("13406670672"));
    }
}
