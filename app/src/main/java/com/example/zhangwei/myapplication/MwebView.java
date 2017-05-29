package com.example.zhangwei.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by zhangwei on 2017/5/28.
 */

public class MwebView extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);
//        setContentView(R.layout.mwebview);
//        final WebView webView = (WebView)findViewById(R.id.wvWebview);
        WebSettings webSettings = webView.getSettings();
//        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
//        webView.addJavascriptInterface(this,"androidJs");
//        webView.loadUrl("http://www.awbeci.com");
        webView.loadUrl("file:///android_asset/index.html");

//        Button button = (Button)findViewById(R.id.wvButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                webView.loadUrl("javascript:showme()");
//            }
//        });
    }

//    @JavascriptInterface
//    public void setTextView(final String txt){
//        this.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                EditText editText = (EditText)findViewById(R.id.wvText);
//                editText.setText(txt);
//            }
//        });
//    }
}
