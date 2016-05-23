package com.example.zbj.progressbardemo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

//import com.zhubaijia.ZbjApplication;

import java.util.Locale;

/**
 * 设备相关工具类
 * Created by echo on 16/1/25.
 */
public class DeviceUtils {

    /**
     * 获得屏幕相关对象
     */
//    public static DisplayMetrics getDisplayMetrics() {
//        return AppUtils.getContext().getResources().getDisplayMetrics();
//    }

    /**
     * 获得屏幕密度
     */
    public static float getDensity() {
        return MyApplication.getContext().getResources().getDisplayMetrics().density;
    }

    /**
     * 获取设备宽度（px）
     *
//     * @return int
//     */
//    public static int deviceWidth() {
//        return getDisplayMetrics().widthPixels;
//    }

    /**
     * 获取设备高度（px）
     *
     * @return
//     */
//    public static int deviceHeight() {
//        return getDisplayMetrics().heightPixels;
//    }



    /**
     * SD卡判断
     *
     * @return boolean
     */
    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }


    /**
     * 是否有网
     *
     * @return boolean
     */
//    public static boolean isNetworkConnected() {
//        ConnectivityManager mConnectivityManager = (ConnectivityManager) ZbjApplication.getApplication()
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo mNetworkInfo = mConnectivityManager
//                .getActiveNetworkInfo();
//        if (mNetworkInfo != null) {
//            return mNetworkInfo.isAvailable();
//        }
//        return false;
//    }


    /**
     * 获取设备的唯一标识，deviceId
     *
     * @param context context
     * @return String
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null) {
            return "-";
        } else {
            return deviceId;
        }
    }

    /**
     * 获取手机品牌
     *
     * @return String
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return int
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return String
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 手机型号
     *
     * @return String
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取当前App进程的id
     *
     * @return int
     */
    public static int getAppProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * 获取手机IMEI
     *
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getIMEI(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return deviceId;
    }

    /**
     * 复制到剪贴板
     *
     * @param context context
     * @param content content
     */
    public static void copy2Clipboard(Context context, String content) {
        ClipData clipData = ClipData.newPlainText(context.getString(R.string.app_name), content);
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(
                Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(clipData);
    }

    /**
     * 获取SIM卡运营商
     *
     * @param context
     * @return
     */
    public static String getOperators(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSubscriberId();
    }

    /**
     * 获取当前系统语言环境
     *
     * @param context
     * @return
     */
    public static String getLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage();
    }

    /**
     * 获取当前系统语言环境
     *
     * @param context
     * @return
     */
    public static String getCountry(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getCountry();
    }

}
