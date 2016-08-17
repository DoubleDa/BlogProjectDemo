package com.dyx.bpls.util;

import android.content.Context;

import org.apache.http.util.EncodingUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * project name：BlogProjectLoginScreen
 * class describe：
 * create person：dayongxin
 * create time：16/8/17 下午3:48
 * alter person：dayongxin
 * alter time：16/8/17 下午3:48
 * alter remark：
 */
public class FileUtils {
    private Context context; //上下文

    public FileUtils(Context c) {
        this.context = c;
    }

    //首先是个公用的方法：
    private String dealStream(InputStream is) throws IOException {
        int buffersize = is.available();// 取得输入流的字节长度
        byte buffer[] = new byte[buffersize];
        is.read(buffer);// 数据读入数组
        is.close();// 读取完毕关闭流。
        String result = EncodingUtils.getString(buffer, "UTF-8");// 防止乱码
        return result;
    }

    // 读取sd中的存在的文件
    public String readSDCardFile(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        String resStr = dealStream(fis);
        return resStr;
    }

    // res目录下新建raw资源文件夹，只能读不能写入
    public String readRawFile(int fileId) throws IOException {
        // 取得输入流
        InputStream is = context.getResources().openRawResource(fileId);
        String resultStr = dealStream(is);// 返回一个字符串
        return resultStr;
    }

    // 在assets下的文件，只能读取不能写入
    public String readAssetsFile(String filename) throws IOException {
        // 取得输入流
        InputStream is = context.getResources().getAssets().open(filename);
        String resStr = dealStream(is);// 返回一个字符串
        return resStr;
    }

    // 往sd卡中写入文件
    public void writeToSDCard(String path, byte[] buffer) throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(buffer);// 写入buffer数组。如果想写入一些简单的字符，可以将String.getBytes()再写入文件;
        fos.close();
    }

    // 将文件写入应用的data/data的files目录下
    public void writeToDateFile(String fileName, byte[] buffer) throws Exception {
        byte[] buf = fileName.getBytes("iso8859-1");
        fileName = new String(buf, "utf-8");
        FileOutputStream fos = context.openFileOutput(fileName,
                Context.MODE_APPEND);// 打开模式，有几种，此处表示添加在文件后面
        fos.write(buffer);
        fos.close();
    }

    // 读取应用的data/data的files目录下文件数据
    public String readDateFile(String fileName) throws Exception {
        FileInputStream fis = context.openFileInput(fileName);
        String resultStr = dealStream(fis);// 返回一个字符串
        return resultStr;
    }
}
