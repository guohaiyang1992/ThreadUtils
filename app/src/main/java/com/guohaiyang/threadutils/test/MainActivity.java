package com.guohaiyang.threadutils.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.guohaiyang.threadutils.R;
import com.hfga.threadutil.task.AsynTask;
import com.hfga.threadutil.task.MainTask;
import com.hfga.threadutil.task.TaskManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();


    }

    private void test() {
        TaskManager.getNewInstance().onNext(new MainTask(1000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "main_thread:" + Thread.currentThread().getName());
            }
        }).onNext(new AsynTask(2000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "asyn_thread:" + Thread.currentThread().getName());
            }
        }).onNext(new MainTask(3000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "main_thread:" + Thread.currentThread().getName());
            }
        }).onNext(new AsynTask(4000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "asyn_thread:" + Thread.currentThread().getName());
            }
        }).start();
    }
}
