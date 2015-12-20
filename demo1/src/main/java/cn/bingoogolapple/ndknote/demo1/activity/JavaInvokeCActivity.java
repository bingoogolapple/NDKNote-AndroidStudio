package cn.bingoogolapple.ndknote.demo1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.bingoogolapple.ndknote.demo1.R;
import cn.bingoogolapple.ndknote.demo1.jni.JavaInvokeC;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/20 下午2:40
 * 描述:
 */
public class JavaInvokeCActivity extends AppCompatActivity {
    private TextView mResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_invoke_c);
        mResultTv = (TextView) findViewById(R.id.tv_java_invoke_c_result);
    }

    public void getABIFromC(View v) {
        mResultTv.setText(JavaInvokeC.getABIStringFromC());
    }

    public void add(View v) {
        mResultTv.setText("2 + 3 = " + JavaInvokeC.addAToB(2, 3));
    }

    public void sayHello(View v) {
        mResultTv.setText(JavaInvokeC.sayHelloFromC("王浩"));
    }

    public void mapArr(View v) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        JavaInvokeC.mapArrByC(arr);

        StringBuilder resultSb = new StringBuilder("转换后");
        for (int i = 0; i < arr.length; i++) {
            resultSb.append(String.valueOf(arr[i]));
            if (i != arr.length - 1) {
                resultSb.append(",");
            }
        }
        mResultTv.setText(resultSb.toString());
    }
}
