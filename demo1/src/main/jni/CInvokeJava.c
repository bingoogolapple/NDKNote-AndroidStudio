#include <jni.h>
#include <android/log.h>

#define LOG_TAG "NDKNoteJavaInvokeCTAG"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

JNIEXPORT void JNICALL
Java_cn_bingoogolapple_ndknote_demo1_jni_CInvokeJava_callHelloFromJava(JNIEnv *env, jobject obj) {
    jclass clazz = (*env)->FindClass(env, "cn/bingoogolapple/ndknote/demo1/jni/CInvokeJava");
    if (clazz == 0) {
        LOGE("find class CInvokeJava error");
        return;
    }
    // javap -s cn.bingoogolapple.ndknote.demo1.jni.CInvokeJava   获取函数的签名
    jmethodID methodId = (*env)->GetMethodID(env, clazz, "helloFromJava", "()V");
    if (methodId == 0) {
        LOGE("find method helloFromJava error");
        return;
    }
    (*env)->CallVoidMethod(env, obj, methodId);
}

JNIEXPORT void JNICALL
Java_cn_bingoogolapple_ndknote_demo1_jni_CInvokeJava_callAdd(JNIEnv *env, jobject obj) {
    jclass clazz = (*env)->FindClass(env, "cn/bingoogolapple/ndknote/demo1/jni/CInvokeJava");
    if (clazz == 0) {
        LOGE("find class CInvokeJava error");
        return;
    }
    jmethodID methodId = (*env)->GetMethodID(env, clazz, "add", "(II)I");
    if (methodId == 0) {
        LOGE("find method add error");
        return;
    }
    jint result = (*env)->CallIntMethod(env, obj, methodId, 2, 3);
    LOGI("2+3=%d", result);
}

JNIEXPORT void JNICALL
Java_cn_bingoogolapple_ndknote_demo1_jni_CInvokeJava_callPrintStaticString(JNIEnv *env,
                                                                           jobject obj) {
    jclass clazz = (*env)->FindClass(env, "cn/bingoogolapple/ndknote/demo1/jni/CInvokeJava");
    if (clazz == 0) {
        LOGE("find class CInvokeJava error");
        return;
    }
    jmethodID methodId = (*env)->GetStaticMethodID(env, clazz, "printStaticString",
                                                   "(Ljava/lang/String;)V");
    if (methodId == 0) {
        LOGE("find method printStaticString error");
        return;
    }
    (*env)->CallStaticVoidMethod(env, clazz, methodId, (*env)->NewStringUTF(env, "静态 王浩"));
}