package cn.bingoogolapple.ndknote.demo1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.bingoogolapple.ndknote.demo1.R;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/16 下午11:10
 * 描述:
 */
public class MainActivity extends AppCompatActivity {
    private TextView mResultTv;

    static {
        System.loadLibrary("demo1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTv = (TextView) findViewById(R.id.tv_main_result);
    }

    public void getABIFromC(View v) {
        mResultTv.setText(getABIStringFromC());
    }

    public native String getABIStringFromC();

    public void add(View v) {
        mResultTv.setText("2 + 3 = " + addAToB(2, 3));
    }

    public native int addAToB(int a, int b);

    public void sayHello(View v) {
        mResultTv.setText(sayHelloFromC("王浩"));
    }

    public native String sayHelloFromC(String name);

    public void mapArr(View v) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        mapArrByC(arr);

        StringBuilder resultSb = new StringBuilder("转换后");
        for (int i = 0; i < arr.length; i++) {
            resultSb.append(String.valueOf(arr[i]));
            if (i != arr.length - 1) {
                resultSb.append(",");
            }
        }
        mResultTv.setText(resultSb.toString());
    }

    public native int[] mapArrByC(int[] arr);
}