package cn.bingoogolapple.ndknote.demo1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bingoogolapple.ndknote.demo1.R;
import cn.bingoogolapple.ndknote.demo1.jni.CInvokeJava;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/20 下午2:40
 * 描述:
 */
public class CInvokeJavaActivity extends AppCompatActivity {
    private CInvokeJava mCInvokeJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_invoke_java);
        mCInvokeJava = new CInvokeJava();
    }

    public void callHelloFromJava(View v) {
        mCInvokeJava.callHelloFromJava();
    }

    public void callAdd(View v) {
        mCInvokeJava.callAdd();
    }

    public void callPrintStaticString(View v) {
        mCInvokeJava.callPrintStaticString();
    }
}
