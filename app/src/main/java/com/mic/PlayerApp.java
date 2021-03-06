package com.mic;


import android.app.Application;

import androidx.multidex.MultiDex;

import com.mic.ndk.NDKInterface;
import com.mic.ndk.NDKTools;

public class PlayerApp extends Application {


    //public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        // 设置全局异常捕捉类
        // ExceptionCrashHandler.getInstance().init(this);
        NDKTools.loadLibrary();
        NDKInterface.signatureVerify(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
