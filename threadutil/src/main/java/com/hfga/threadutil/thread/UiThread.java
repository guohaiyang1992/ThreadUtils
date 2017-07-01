package com.hfga.threadutil.thread;

import android.util.Log;

import com.hfga.threadutil.ThreadUtils;
import com.hfga.threadutil.task.AbsTask;

/**
 * Created by guohaiyang on 2017/6/30.
 */

public class UiThread implements IThread {
    @Override
    public void run(AbsTask task, int delay) {
        ThreadUtils.runInUi(task, delay);
    }
}
