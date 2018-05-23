/*

package com.baobao.framework.support.utility;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class IpUtility {

    private static String TAOBAO_IP_API = "http://ip.taobao.com/service/getIpInfo.php?ip=";
    private static String BAIDU_IP_API = "http://api.map.baidu.com/location/ip?ak=nVSNqA1myBrEhj4LkyZ8hM6E&coor=bd09ll&ip=";
    private static Logger logger = Logger.getLogger(IpUtility.class);

    */
/**
     * 根据地址类型获取ip响应信息
     *
     * @param ip
     * @param url
     * @return
     *//*

    private static String getIpCityInfo(String ip, String url) {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        try {
            URI base = new URI(url + ip, false);
            method.setURI(base);
            int result = client.executeMethod(method);
            if (result == HttpStatus.SC_OK) {
                InputStream in = method.getResponseBodyAsStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                return URLDecoder.decode(baos.toString(), "UTF-8");
            }
            return null;
        } catch (Exception ex) {
            logger.error("IP API查询异常，异常原因：" + ex.toString());
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    */
/**
     * 转码Unicode转中文
     *
     * @param theString
     * @return
     *//*

    private static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    */
/**
     * 获取百度IP地址信息
     *
     * @param ip
     * @return
     *//*

    public static String getBaiduIpCityInfo(String ip) {
        String ipInfo = getIpCityInfo(ip, BAIDU_IP_API);
        if (StringUtils.isNotBlank(ipInfo)) {
            Map<String, Object> ipJsonMap = JSONObject.parseObject(decodeUnicode(ipInfo));
            if ("0".equals(ipJsonMap.get("status").toString())) {
                return convertIpInfo(ip, ipJsonMap, 0);
            }
        }
        return null;
    }

    */
/**
     * 获取淘宝IP地址信息
     *
     * @param ip
     * @return
     *//*

    public static String getTaobaoIpCityInfo(String ip) {
        String ipInfo = getIpCityInfo(ip, TAOBAO_IP_API);
        if (StringUtils.isNotBlank(ipInfo)) {
            Map<String, Object> ipJsonMap = JSONObject.parseObject(decodeUnicode(ipInfo));
            if ("0".equals(ipJsonMap.get("code").toString())) {
                return convertIpInfo(ip, ipJsonMap, 1);
            }
        }
        return null;
    }

    */
/**
     * 根据请求类型转换ip信息
     *
     * @param ip
     * @param ipJsonMap
     * @param type
     * @return
     *//*

    private static String convertIpInfo(String ip, Map<String, Object> ipJsonMap, int type) {
        Map<String, Object> ipInfoMap = new HashMap<String, Object>();
        switch (type) {
            case 0:
                Map<String, Object> contentMap = (Map<String, Object>) ipJsonMap.get("content");
                Map<String, Object> detailMap = (Map<String, Object>) contentMap.get("address_detail");
                ipInfoMap.put("ip", ip);
                ipInfoMap.put("ipSource", "baidu");
                ipInfoMap.put("addressInfo", ipJsonMap.get("address"));
                ipInfoMap.put("province", detailMap.get("province"));
                ipInfoMap.put("city", detailMap.get("city"));
                ipInfoMap.put("cityCode", detailMap.get("city_code"));
                ipInfoMap.put("district", detailMap.get("district"));
                ipInfoMap.put("street", detailMap.get("street"));
                ipInfoMap.put("streetNumber", detailMap.get("street_number"));
                return JSONObject.toJSONString(ipInfoMap);
            case 1:
                return JSONObject.toJSONString(ipJsonMap);
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(IpUtility.getBaiduIpCityInfo("124.160.75.205"));
        System.out.println(IpUtility.getTaobaoIpCityInfo("124.160.75.205"));
    }
}
*/
