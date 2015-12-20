package cn.bingoogolapple.ndknote.demo1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bingoogolapple.ndknote.demo1.R;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/16 下午11:10
 * 描述:
 */
public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("demo1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void javaInvokeC(View v) {
        startActivity(new Intent(this, JavaInvokeCActivity.class));
    }
}