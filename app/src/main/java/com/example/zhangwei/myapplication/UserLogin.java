package com.example.zhangwei.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.bridge.Bridge;
import com.afollestad.bridge.BridgeException;
import com.afollestad.bridge.Form;
import com.afollestad.bridge.Request;
import com.afollestad.bridge.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwei on 2017/5/29.
 */

public class UserLogin extends AppCompatActivity {
    Button cmdLogin;
    EditText txtUserName;
    EditText txtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login);
        cmdLogin=(Button)findViewById(R.id.login);
        txtUserName = (EditText)findViewById(R.id.txtUserName);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        cmdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存数据
//                SharedPreferences sharedPreferences = getSharedPreferences("users",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("user_login_name",txtUserName.getText().toString());
//                editor.commit();
//                //点击按钮进行跳转到外壳
//                Intent intent = new Intent();
//                intent.setClass(UserLogin.this,MwebView.class);
//                startActivity(intent);
                //知识点一：线程
                new Thread(runnable).start();
            }
        });
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //知识点二：Bridge jdk api
            Form form = new Form();
            form.add("username",txtUserName.getText().toString());
            form.add("password",txtPassword.getText().toString());
            try {
                Request request = Bridge.post("http://192.168.10.10/api/v1/user")
                        .body(form)
                        .request();
                Response response = request.response();

                if (response.isSuccess()){
                    JSONObject jsonObject = response.asJsonObject();
                    //知识点三：循环侦听
                    Looper.prepare();
                    //知识点四：android 对话框
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserLogin.this);
                    builder.setTitle("提示");
                    builder.setMessage(jsonObject.get("msg").toString());

                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    if (jsonObject.get("status").toString().equals("success")){
                        //知识点五：android 提醒
                        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(UserLogin.this);
                        notificationCompat.setTicker("欢迎回到Awbeci");//注意这行代码没有起作用
                        notificationCompat.setContentTitle("恭喜你今日登录奖励");
                        notificationCompat.setContentText("今日你获得一个权益，请注意查看");
                        notificationCompat.setDefaults(Notification.DEFAULT_SOUND);
                        notificationCompat.setSmallIcon(R.drawable.small);
                        notificationCompat.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.large));
                        notificationCompat.setNumber(3);
                        notificationManager.notify(123,notificationCompat.build());
                    }

                    builder.show();
                    Looper.loop();
                }else {
                }
            } catch (BridgeException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
