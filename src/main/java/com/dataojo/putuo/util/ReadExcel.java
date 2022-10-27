package com.dataojo.putuo.util;

import com.dataojo.putuo.entity.Issue;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static List readExcel(String path,String strURL) {
        List<Issue> list = new ArrayList<>();
        try {
			/*// 如果需要通过URL获取资源的加上以下的代码，不需要的省略就行
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// 设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			// 防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 获取输入流
			InputStream inputStream = conn.getInputStream();
			Workbook workbook  = Workbook.getWorkbook(inputStream);
			......*/

            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(path));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            // sheet.getRows() 获取总行数
            for (int i = 1; i < sheet.getRows(); i++) {
                Issue issue = new Issue();
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                System.out.println(i);
                String TASKID = sheet.getCell(1, i).getContents();
                // 获取第二列的第 i 行信息
                String CASESN = sheet.getCell(2,i).getContents();
                // 获取第三列的第 i 行信息
                String DISCOVERTIMEl = sheet.getCell(4, i).getContents();
                String COORDX = sheet.getCell(25, i).getContents();
                String COORDY = sheet.getCell(26, i).getContents();
                String ADDRESS = sheet.getCell(30, i).getContents();
                String INFOTYPEID = sheet.getCell(31, i).getContents();
                String DESCRIPTION = sheet.getCell(36, i).getContents();
                String DISPATCHUSER = sheet.getCell(46, i).getContents();
                // 获取第四列的第 i 行信息
//                String grade = sheet.getCell(3, i).getContents();

                // 存入本地或者是存入对象等根据给人需求自己定就行,创建对象存储，然后加入集合中
                // ......
                issue.setTASKID(TASKID);
                issue.setCASESN(CASESN);
                issue.setDISCOVERTIMEl(DISCOVERTIMEl);
                issue.setCOORDX(COORDX);
                issue.setCOORDY(COORDY);
                issue.setADDRESS(ADDRESS);
                issue.setINFOTYPEID(INFOTYPEID);
                issue.setDESCRIPTION(DESCRIPTION);
                issue.setDISPATCHUSER(DISPATCHUSER);
                list.add(issue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return list;
    }

}