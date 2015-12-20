package cn.bingoogolapple.ndknote.demo1.jni;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/12/20 上午9:17
 * 描述:
 */
public class JavaInvokeC {

    public static native String getABIStringFromC();

    public static native int addAToB(int a, int b);

    public static native String sayHelloFromC(String name);

    public static native int[] mapArrByC(int[] arr);
}