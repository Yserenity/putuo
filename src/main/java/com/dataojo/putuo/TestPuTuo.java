//package com.dataojo.putuo;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.dataojo.putuo.util.InterTest;
//import com.sun.org.glassfish.gmbal.ManagedObjectManagerFactory;
//import org.springframework.util.StringUtils;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: putuo
// * @description:
// * @author: hui
// * @create: 2023-01-05 21:23
// **/
//
//public class TestPuTuo {
//    public static void main(String[] args) {// pu_tuo
//        Map<String,String> param = new HashMap<>();
//        param.put("moduleCode","2");
//        String responseByZhiSouGet =
//                InterTest.getResponseByZhiSouGet("http://localhost:8282/AI-Searching/drop-down-list", param);
//        Map map = JSONObject.parseObject(responseByZhiSouGet, Map.class);
//        List<Map> o = (List<Map>)map.get("data");
//        List<Map> res = new ArrayList<>();
//        for (Map m :o){
//            Map<String,Object> resSon = new HashMap<>();
//            String code = (String)m.get("code");
//            String desc = (String)m.get("desc");
//            Map<String,Object> param2 = new HashMap<>();
//            List<String> sb = new ArrayList<>();
//            sb.add(code);
//            String o2 = JSONObject.toJSONString(param2);
//            param2.put("filterIotDeviceTypeCodeList",sb);
//            param2.put("keyword","");
//            String responseByZhiSou = InterTest.getResponseByZhiSou("http://localhost:8282/AI-Searching/full-text-search", JSON.toJSONString(param2));
//            Map map2 = JSONObject.parseObject(responseByZhiSou, Map.class);
//            List<Map> data = (List<Map>) map2.get("data");
//            Map map1 = data.get(0);
//            List<Map> o3 = (List<Map>)map1.get("collapseData");
//            Map map3 = o3.get(0);
//            resSon.put("code",code);
//            resSon.put("collapseData",map3.toString());
//            resSon.put("desc",desc);
//            res.add(resSon);
//
//        }
//        Boolean pu_tuo = TestPuTuo.insertData(res, "pu_tuo");
//    }
//
//    public static Boolean insertData(List<Map> realData, String tableName){
//        boolean execute = false;
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            // 获得表结构
//            connection = DriverManager.getConnection("jdbc:mysql://123.57.89.151:30072/xxl_job","root","aliyun@2022");
//                    // JdbcUtil.getConnection("self_db");
//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet rs = metaData.getColumns(null, null, tableName, null);
//            List<String> columnNames = new ArrayList<>();
//            //  Map<String, Object> remarkToName = new HashMap<>();
//            while (rs.next()) {
//                String column_name = rs.getString("COLUMN_NAME");
//                columnNames.add(column_name);
//            }
//            String colName = "";
//            StringBuilder colValue = new StringBuilder();
//            for (Map map : realData) {
//                colValue.append("(");
//                for (String s : columnNames) {
//                    String value = map.get(s).toString();
//                    colValue.append("'").append(StringUtils.hasText(value) ? value : "").append("'").append(",");
//                }
//                colValue.deleteCharAt(colValue.length() - 1);
//                colValue.append("),");
//            }
//            colName = TestPuTuo.getStringCommaToList(columnNames);
//
//            String substring1 = colValue.substring(0, colValue.lastIndexOf(","));
//            StringBuilder sql = new StringBuilder();
//            sql.append("insert into " + tableName + " (").append(colName).append(")")
//                    .append("values ").append(substring1);
////            while (rs.next()) {
////                String column_name = rs.getString("COLUMN_NAME");
////                columnNames.add(column_name);
////            }
////            String colName = "";
////            StringBuilder colValue = new StringBuilder();
////            for (Map map:realData){
////                for (String s : columnNames) {
////                    String value = map.get(s).toString();
////                    colValue.append("'").append(StringUtils.hasText(value) ? value : "").append("'").append(",");
////                }
////            }
////            colName = TestPuTuo.getStringCommaToList(columnNames);
////
////            String substring1 = colValue.substring(0, colValue.lastIndexOf(","));
////            StringBuilder sql = new StringBuilder();
////            sql.append("insert into "+tableName+" (").append(colName).append(")").append("values (").append(substring1).append(")");
//            System.out.println(sql.toString());
//            preparedStatement = connection.prepareStatement(sql.toString());
//            preparedStatement.execute();
//            execute =true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.out.println(throwables.getMessage());
//            execute = false;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//           // JdbcUtil.close(connection, preparedStatement, null);
//            try {
//                preparedStatement.close();
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return execute;
//    }
//
//
//    /**
//     * list转逗号拼接的字符串
//     * @param test
//     * @param <T>
//     * @return
//     */
//    public static <T> String getStringCommaToList(List<T> test){
//        String testStrings = "";
//        for (Object object : test) {
//            if (object != null) {
//                String s = "`"+object+"`";
//               // testStrings = "`"+s+"`";
//                testStrings += s + ",";
//            }
//        }
//        if (testStrings.length() > 0) {
//            testStrings = testStrings.substring(0, testStrings.length() - 1);
//        }
//        return testStrings;
//    }
//}
