package com.dataojo.putuo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.entity.HttpGetWithEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InterTest {

    /**
     * 城操数据组post请求
     * @param baseUrl
     * @param data
     * @return
     */
    public static String getResponse(String baseUrl,String data){
        String result = null;
        try {
            String clientId = "633291c2e4b0463194b04c73";
            String clientSecret = "PE4f4IoYbphN21zPhL4HdLu7rXRO8qf7q9Rx5leDpuQ";
            String secretKey = "";
            Map<String, String> queryMap = new HashMap();
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("X-OS-Client-Id", "633291c2e4b0463194b04c73");
            long timestamp = System.currentTimeMillis();
            httpConc.setRequestProperty("X-OS-Timestamp", String.valueOf(timestamp));
            httpConc.setRequestProperty("X-OS-Signature", signature(clientId, clientSecret, timestamp));
            String encryptedData = data;
            result = doPost(httpConc, encryptedData);
//            log.info("response =" + respsonse);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 无请求头get请求
     * @param baseUrl
     * @param queryMap
     * @return
     */
    public static String getResponseByGet(String baseUrl,Map<String, String> queryMap){
        String result = null;
        try {
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestMethod("GET");
            httpConc.setRequestProperty("accept", "*/*");
            httpConc.setRequestProperty("Content-Type","application/json");
            httpConc.connect();
            result = readStreamToStr(httpConc);
//            log.info("response =" + respsonse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 地图-get请求
     * @param baseUrl
     * @param queryMap
     * @param headers
     * @return
     */
    public static String getResponseByMap(String baseUrl,Map<String, String> queryMap,String headers){
        String result = null;
        try {
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestMethod("GET");
            httpConc.setRequestProperty("accept", "*/*");
            httpConc.setRequestProperty("cd-token",headers);
            httpConc.connect();
            result = readStreamToStr(httpConc);
//            log.info("response =" + respsonse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 地图-post请求
     * @param baseUrl
     * @param data
     * @param headers
     * @return
     */
    public static String getResponseByMap(String baseUrl,String data,String headers){
        String result = null;
        try {
            Map<String, String> queryMap = new HashMap();
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("cd-token",headers);
            String encryptedData = data;
            result = doPost(httpConc, encryptedData);
//            log.info("response =" + respsonse);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //处理url
    public static String handleQuery(String url, Map<String, String> quertMap) {
        StringBuilder sb = new StringBuilder(url);
        boolean firstQuery = true;
        for (String key : quertMap.keySet()) {
            if (firstQuery) {
                sb.append("?");
                firstQuery = false;
            } else {
                sb.append("&");
            }
            String val = quertMap.get(key);
            sb.append(key).append("=").append(val == null ? "" : val);
        }
        return sb.toString();
    }

    //流转字符串
    private static String readStreamToStr(HttpURLConnection httpConc){
        try{
            int responseCode = httpConc.getResponseCode();
//            log.info("responseCode = " + responseCode);
            BufferedReader reader = null;
            if(responseCode == 200){
                reader = new BufferedReader(new InputStreamReader(httpConc.getInputStream()));
            }else{
                reader = new BufferedReader(new InputStreamReader(httpConc.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder(); String lines;
            while((lines = reader.readLine()) != null){
                sb.append(lines);
            }
            String resStr = sb.toString();
            return resStr;
        }catch(Exception e){
            e.printStackTrace(); return null;
        }
    }

    //流转字符串
    private static String readStreamToStrGet(HttpResponse response){
        try{
            int responseCode = response.getStatusLine().getStatusCode();
            // 获取响应消息实体
            HttpEntity httpEntity = response.getEntity();
//            log.info("responseCode = " + responseCode);
            BufferedReader reader = null;
            if(responseCode == 200){
                reader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
            }else{
                reader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
            }
            StringBuilder sb = new StringBuilder(); String lines;
            while((lines = reader.readLine()) != null){
                sb.append(lines);
            }
            String resStr = sb.toString();
            return resStr;
        }catch(Exception e){
            e.printStackTrace(); return null;
        }
    }
    //发送POST请求
    private static String doPost(HttpURLConnection httpConc, String data) throws IOException {
        httpConc.setRequestMethod("POST");
        httpConc.setDoOutput(true);
        httpConc.connect();
        DataOutputStream out = new DataOutputStream(httpConc.getOutputStream());
        if (data != null && !"".equals(data)){
            out.write(data.getBytes(StandardCharsets.UTF_8));
        }
        out.flush();
        out.close();
        String response = readStreamToStr(httpConc);
        return response;
    }

    //传入body值
    private static String deliveryBody(HttpURLConnection httpConc, String data) throws IOException {
        httpConc.setDoOutput(true);
        httpConc.connect();
        DataOutputStream out = new DataOutputStream(httpConc.getOutputStream());
//        List<Field> fields = new ArrayList<>() ;
//        Class tempClass = conn.getClass();
//        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
//            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
//            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
//        }
//        for (Field field : fields) {
//            if ("method".equals(field.getName())){
//                field.setAccessible(true);
//                field.set(conn,"GET");
//            }
//        }
        if (data != null && !"".equals(data)){
            out.write(data.getBytes(StandardCharsets.UTF_8));
        }

        out.flush();
        out.close();
        String response = readStreamToStr(httpConc);
        return response;
    }

    //SHA256转码
    private static String signature(String clientId, String clientSecret, long timestamp) throws NoSuchAlgorithmException {
        String strToSignature = String.format("%s&%s&%d", clientId, clientSecret, timestamp);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); messageDigest.update(strToSignature.getBytes());
        byte byteBuffer[] = messageDigest.digest();
        StringBuffer strHexString = new StringBuffer();
        for (int i = 0; i < byteBuffer.length; i++) {
            String hex = Integer.toHexString(0xff & byteBuffer[i]);
            if (hex.length() == 1) {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        String signature = strHexString.toString();
        return signature;
    }

    /**
     * 视频流post请求
     * @param baseUrl
     * @param data
     * @return
     */
    public static String post(String baseUrl,String data){
        String result = null;
        try{
            Map<String, String> queryMap = new HashMap();
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJaTFBUIiwidXNlck5hbWUiOiLmmbrogZTmma7lubPlj7AiLCJvcmdJZCI6IumZiOeri-W-tyIsIm9yZ05hbWUiOiIxODUyMTM1MTkwMCIsImNyZWF0ZVRpbWUiOjE2Mjg2NzAwMzAwOTksImV4cCI6NDEwMjQxNjAwMDAwMH0.4wKMAvnJWV9GWc7q0jX3Ytwkyfst-yFYbjlCVt7elLA");
            httpConc.setRequestProperty("PERSON-ID", "f9c5ab6843fa49fee12aa83432a3959f");
            httpConc.setRequestProperty("Connection", "close");
            httpConc.setRequestProperty("client_ip", "31.1.227.85");
            String encryptedData = data;
            result = doPost(httpConc, encryptedData);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
    * @program:
    * @description:读取请求流
    * @author: hlh
    * @date: 2022/10/25 20:43
    */
    public static String readRequestStream(HttpServletRequest request){
        String context = null;
        String data = null;
        try{
            BufferedReader bufferedReader = request.getReader();
            while ((context = bufferedReader.readLine()) != null){
                data = context;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 鉴权post请求
     * @param baseUrl
     * @param queryMap
     * @return
     */
    public static String identityByGet(String baseUrl,Map<String, String> queryMap){
        String result = null;
        try {
            String clientId = "633291c2e4b0463194b04c73";
            String clientSecret = "PE4f4IoYbphN21zPhL4HdLu7rXRO8qf7q9Rx5leDpuQ";
            String secretKey = "";
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("authType", "ClientAuth");
            httpConc.setRequestProperty("appId", "633291c2e4b0463194b04c73");
            long timestamp = System.currentTimeMillis();
            httpConc.setRequestProperty("timestamp", String.valueOf(timestamp));
            httpConc.setRequestProperty("signature", signature(clientId, clientSecret, timestamp));
            result = readStreamToStr(httpConc);
//            log.info("response =" + respsonse);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 参数中存在中文字符get请求
     * @param baseUrl
     * @param queryMap
     * @return
     */
    public static String chineseByGet(String baseUrl,Map<String, String> queryMap){
        String result = null;
        try{
            String url = handleQuery(baseUrl, queryMap);
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            result = readStreamToStrGet(httpResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 明珠POST请求
     */
    public static String getResponseByMingzhu(String baseUrl,String data){
        String result = null;
        try {
            URL url = new URL(baseUrl);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("n", "mingzhu");
            long timestamp = System.currentTimeMillis();
            httpConc.setRequestProperty("r", String.valueOf(timestamp));
            httpConc.setRequestProperty("k", Transition.getPK());
            String encryptedData = data;
            result = doPost(httpConc, encryptedData);
//            log.info("response =" + respsonse);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 智搜POST请求
     */
    public static String getResponseByZhiSou(String baseUrl,String data){
        String result = null;
        try {
            URL url = new URL(baseUrl);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestProperty("Content-Type", "application/json");
            httpConc.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZSI6MSwiand0VHlwZSI6InVzZXIiLCJ1c2VySWQiOiI0MiIsInRlbmFudElkIjoiMSIsInVzZXJuYW1lIjoicHV0dW9CcmFpbiIsInNlc3Npb25Ub2tlbiI6IjljZWQ2YzQ5Njg5ZDRlMmQ4MDBiYzdhZmRhZDU2MTE2IiwiaXNzIjoiZHJpZ2h0Iiwic3ViIjoiYWNjZXNzVG9rZW4iLCJpYXQiOjE2NzUwNDg1MjYsIm5iZiI6MTY3NTA0ODQ2Nn0.ZQaE6flsPyLj2StwK6St58UZFQwuIQGt2mDFEVENX5o");
            String encryptedData = data;
            result = doPost(httpConc, encryptedData);
//            log.info("response =" + respsonse);
            httpConc.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 智搜-get请求
     * @param baseUrl
     * @param queryMap
     * @return
     */
    public static String getResponseByZhiSouGet(String baseUrl,Map<String, String> queryMap){
        String result = null;
        try {
            String _url = handleQuery(baseUrl, queryMap);
            URL url = new URL(_url);
//            log.info("url: " + url);
            HttpURLConnection httpConc = (HttpURLConnection) url.openConnection();
            httpConc.setConnectTimeout(60000);
            httpConc.setReadTimeout(300000);
            httpConc.setRequestMethod("GET");
            httpConc.setRequestProperty("accept", "*/*");
            httpConc.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZSI6MSwiand0VHlwZSI6InVzZXIiLCJ1c2VySWQiOiI0MiIsInRlbmFudElkIjoiMSIsInVzZXJuYW1lIjoicHV0dW9CcmFpbiIsInNlc3Npb25Ub2tlbiI6IjljZWQ2YzQ5Njg5ZDRlMmQ4MDBiYzdhZmRhZDU2MTE2IiwiaXNzIjoiZHJpZ2h0Iiwic3ViIjoiYWNjZXNzVG9rZW4iLCJpYXQiOjE2NzUwNDg1MjYsIm5iZiI6MTY3NTA0ODQ2Nn0.ZQaE6flsPyLj2StwK6St58UZFQwuIQGt2mDFEVENX5o");
            httpConc.connect();
            result = readStreamToStr(httpConc);
//            log.info("response =" + respsonse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 智搜GET请求
     */
    /**
     * 发送get请求，参数为json
     * @param url
     * @param param 参数
     * @return
     * @throws Exception
     */
    public static JSONObject sendJsonByGetReq(String url, String param){
        try {
            String encoding = "UTF-8";
            String body = "";
            //创建httpclient对象
            HttpGetWithEntity httpGetWithEntity = new HttpGetWithEntity(url);
            HttpEntity httpEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
            httpGetWithEntity.setEntity(httpEntity);
            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(httpGetWithEntity);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            //释放链接
            response.close();
            return JSONObject.parseObject(body);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
