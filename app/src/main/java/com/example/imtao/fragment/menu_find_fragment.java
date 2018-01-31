package com.example.imtao.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.imtao.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by asus1 on 2018/1/20.
 */

public class menu_find_fragment extends Fragment {

    Button button_download;

    ProgressBar progressBar;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_find, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final String app_url = "http://bmob-cdn-15323.b0.upaiyun.com/2017/12/07/43f65e4d40adb3848047e18dcabf5d92.png";
        progressBar=(ProgressBar)getView().findViewById(R.id.progress_loading);
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 10001:
                        progressBar.setProgress((Integer) msg.obj);
                        break;
                }
            }
        };
        button_download = (Button) getView().findViewById(R.id.button_download);
        /**
         * 点击按钮
         * 发起下载
         * 开启子线程开始下载
         * 下载过程中通知主线程更新进度条
         *
         */
        button_download.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        download(app_url);
                    }
                }).start();
            }

            private void download(String app_url) {

                try {
                    URL  url = new URL(app_url);

                    URLConnection urlConnection = url.openConnection();

                    InputStream inputStream=urlConnection.getInputStream();

                    //获取文件总长度
                   int url_length= urlConnection.getContentLength();
                    String fileName= Environment.getExternalStorageState()+ File.separator+"jinkai"+
                            File.separator;
                    File file=new File(fileName);
                    if (!file.exists()){
                        file.mkdir();
                    }
                    String file_name=fileName+"jinkai.png";
                    File file1=new File(file_name);

                    int downloadLength=0;
                    byte []bytes=new byte[1024];
                    int length=0;
                    OutputStream outputStream=new FileOutputStream(file_name);
                    while ((length=inputStream.read(bytes))!=-1){

                        outputStream.write(bytes,0,length);
                        downloadLength+=length;
                        Message message=Message.obtain();
                        message.obj=downloadLength *100 /url_length;
                        message.what=10001;
                        handler.sendMessage(message);
                    }
                    outputStream.close();
                    inputStream.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
