package com.example.zhangwei.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by zhangwei on 2017/5/17.
 */

public class Index extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
//        Intent intent = this.getIntent();
//        String name = intent.getExtras().get("name").toString();
        ((EditText)findViewById(R.id.editText)).setText("zhangwei");
    }
}
