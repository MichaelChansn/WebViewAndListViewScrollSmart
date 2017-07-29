package com.ks.smart_sroll;

import java.util.ArrayList;
import java.util.List;

import com.ks.library.smartscroll.view.SmartScrollLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    
    private List<String> list = new ArrayList<>();
    private SmartScrollLayout wl;
    
    String htmlString = "<h1>Title1</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p><br>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>" +
            "<h1>Title2</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p><br>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>" +
            "<h1>Title3</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>" +
            "<h1>Title4</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>" +
            "<h1>Title5</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>" +
            "<h1>Title6</h1><p>This is HTML text. <i>Formatted in italics.</i><br>Anothor Line.</p>" +
            "<img src=\"http://img.blog.csdn.net/20160405153830915\" width=\"330px\" height=\"330px\"/><br>";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        htmlString = "https://po.baidu"
                + ".com/feed/share?isBdboxShare=1&context=%7B%22nid%22%3A%22news_2872453080115326357%22%2C%22sourceFrom%22%3A%22bjh%22%7D";
        
        htmlString = "http://blog.csdn.net/abc5382334/article/details/23934101";
        //        htmlString = "http://www.baidu.com";
        wl = (SmartScrollLayout) findViewById(R.id.wl);
        
        // WebView
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(htmlString);
        //        myWebView.loadData(htmlString, "text/html", "utf-8");
        //        myWebView.loadData(htmlString, "text/html", "utf-8");
        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        myWebView.setWebViewClient(webViewClient);
        
        // ListView
        for (int i = 0; i < 60; i++) {
            list.add("评论：" + i);
        }
        ListView lv = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        View header = LayoutInflater.from(this).inflate(R.layout.header_view, lv, false);
        lv.addHeaderView(header);
    }
    
}
