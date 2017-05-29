package com.example.zhangwei.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by zhangwei on 2017/5/29.
 */

public class UserLogin extends AppCompatActivity {
    Button cmdLogin;
    EditText txtUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login);
        cmdLogin=(Button)findViewById(R.id.login);
        txtUserName = (EditText)findViewById(R.id.txtUserName);
        cmdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存数据
                SharedPreferences sharedPreferences = getSharedPreferences("users",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_login_name",txtUserName.getText().toString());
                editor.commit();
                //点击按钮进行跳转到外壳
                Intent intent = new Intent();
                intent.setClass(UserLogin.this,MwebView.class);
                startActivity(intent);
            }
        });
    }
}
