package com.dataojo.putuo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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

    //获取返回值
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
    //消防请求
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
            httpConc.connect();
            result = readStreamToStr(httpConc);
//            log.info("response =" + respsonse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //图层get请求
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
    //图层post请求
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
        out.write(data.getBytes(StandardCharsets.UTF_8));
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

    //通用请求
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
            System.out.println(result);
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

    public static String get(String baseUrl,Map<String, String> queryMap){
        String result = null;
        try{
            String url = handleQuery(baseUrl, queryMap);
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("cd-token","IPhj81.qyUqPr.wWJDx6");
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            result = readStreamToStrGet(httpResponse);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
