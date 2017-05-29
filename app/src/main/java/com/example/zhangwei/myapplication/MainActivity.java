package com.example.zhangwei.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btnShow);
        btn.setOnClickListener(new BtnClicker());
    }

    class BtnClicker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
//            ((Button)v).setText("你点了我");
            Intent intent = new Intent();
//            intent.setClassName("com.android.deskclock","com.android.deskclock.DeskClock");
//            intent.setComponent(new ComponentName("com.android.deskclock","com.android.deskclock.DeskClock"));
//            intent.setClass(MainActivity.this,Index.class);
//            intent.putExtra("name","吴灵美");
//            intent.setAction("index");
//            intent.setAction(intent.ACTION_VIEW);
//            intent.setData(Uri.parse("http://www.awbeci.com"));
//            System.out.println("this is one");
//            intent.setAction(intent.ACTION_CALL);
//            System.out.println("this is two");
//            intent.setData(Uri.parse("tel://17756073101"));
//            System.out.println("this is three");
            intent.setAction("newslist");
            intent.setData(Uri.parse("awbeci://awbeci.com"));
            startActivity(intent);
        }
    }
}
