package cn.bingoogolapple.ndknote.demo1.activity;

import android.app.ProgressDialog;
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
    private ProgressDialog mProgressDialog;

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

    public void login(View v) {
        new Thread() {
            @Override
            public void run() {
                login("bga", "123456");
            }
        }.start();
    }

    public native void login(String username, String password);

    public void showProgressDialog(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog == null) {
                    mProgressDialog = new ProgressDialog(CInvokeJavaActivity.this);
                }
                mProgressDialog.setMessage(msg);
                if (!mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }
            }
        });
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
