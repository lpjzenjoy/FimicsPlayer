package com.mic.libcore.task;

import android.os.Handler;
import android.os.Looper;

import com.mic.libcore.utils.Device;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("unused")
public abstract class ExecutorTask {


    private static ExecutorService executor;
    private static Handler handler;

    static {
        Looper looper = Looper.getMainLooper();
        handler = new Handler(looper);
        int cores = Device.System.getNumAvailableCores();
        executor = Executors.newFixedThreadPool(cores);
    }




    public void execute(Object parsms, CallBack callBack) {
        executor.execute(new Task(parsms, callBack));
    }


    private static class Task implements Runnable {

        private Object params;
        private CallBack callBack;

        public Task(Object params, CallBack callBack) {
            this.params = params;
            this.callBack = callBack;
        }

        @Override
        public void run() {
            if (true) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    callBack.onSuccess(1);
                    }
                });
            } else {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    callBack.onFaild(0);
                    }
                });
            }

        }
    }

}
