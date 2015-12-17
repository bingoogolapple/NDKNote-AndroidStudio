#include <jni.h>
#include <android/log.h>
#include <string.h>

#define LOG_TAG "NDKNoteCTAG"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

JNIEXPORT jstring JNICALL
Java_cn_bingoogolapple_ndknote_demo1_activity_MainActivity_getABIStringFromC(JNIEnv *env,
                                                                             jobject obj) {

#if defined(__arm__)
#if defined(__ARM_ARCH_7A__)
#if defined(__ARM_NEON__)
#if defined(__ARM_PCS_VFP)
#define ABI "armeabi-v7a/NEON (hard-float)"
#else
#define ABI "armeabi-v7a/NEON"
#endif
#else
#if defined(__ARM_PCS_VFP)
#define ABI "armeabi-v7a (hard-float)"
#else
#define ABI "armeabi-v7a"
#endif
#endif
#else
#define ABI "armeabi"
#endif
#elif defined(__i386__)
#define ABI "x86"
#elif defined(__x86_64__)
#define ABI "x86_64"
#elif defined(__mips64)  /* mips64el-* toolchain defines __mips__ too */
#define ABI "mips64"
#elif defined(__mips__)
#define ABI "mips"
#elif defined(__aarch64__)
#define ABI "arm64-v8a"
#else
#define ABI "unknown"
#endif

    char *result = "Compiled with ABI " ABI ".";

    LOGI(result);

    return (*env)->NewStringUTF(env, result);
}

JNIEXPORT jint JNICALL
Java_cn_bingoogolapple_ndknote_demo1_activity_MainActivity_addAToB(JNIEnv *env, jobject instance,
                                                                   jint a, jint b) {
    jint result = a + b;
    LOGI("%d+%d=%d", a, b, result);
    return a + b;
}

JNIEXPORT jstring JNICALL
Java_cn_bingoogolapple_ndknote_demo1_activity_MainActivity_sayHelloFromC(JNIEnv *env,
                                                                         jobject obj,
                                                                         jstring name) {
    const char *result = (*env)->GetStringUTFChars(env, name, 0);

    // c语言中的字符串 都是以'/0' 作为结尾
    char arr[7] = {' ', 'h', 'e', 'l', 'l', 'o', '\0'};
    strcat(result, arr);

    LOGI(result);

    (*env)->ReleaseStringUTFChars(env, name, result);

    return (*env)->NewStringUTF(env, result);
}

JNIEXPORT jintArray JNICALL
Java_cn_bingoogolapple_ndknote_demo1_activity_MainActivity_mapArrByC(JNIEnv *env, jobject instance,
                                                                     jintArray arr) {
    jint *intArr = (*env)->GetIntArrayElements(env, arr, NULL);

    int len = (*env)->GetArrayLength(env, arr);
    LOGI("数组长度等于%d",len);

    // c99 循环的变量的初始化条件要在for循环的外面
    int i = 0;
    for(;i<len;i++){
        LOGI("转换前[%d]=%d", i, intArr[i]);

        //*(intarr+i) += 10;

        intArr[i] += 10;
    }

    (*env)->ReleaseIntArrayElements(env, arr, intArr, 0);

    return arr;
}