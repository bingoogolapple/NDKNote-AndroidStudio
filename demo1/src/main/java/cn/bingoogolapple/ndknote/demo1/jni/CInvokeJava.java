package cn.bingoogolapple.ndknote.demo1.jni;

import android.util.Log;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/21 下午8:26
 * 描述:
 */
public class CInvokeJava {
    private static final String TAG = CInvokeJava.class.getSimpleName();

    public String name = "哈哈";

    public native void callHelloFromJava();

    public native void callAdd();

    public native void callPrintStaticString();

    public void helloFromJava() {
        Log.i(TAG, "c代码调用java代码打印Hello");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public void printString(String s) {
        Log.i(TAG, name + "--在java代码中打印c代码传递过来的字符串--" + s);
    }

    public static void printStaticString(String s) {
        Log.i(TAG, "在java的静态方法中打印c代码传递过来的字符串--" + s);
    }
}