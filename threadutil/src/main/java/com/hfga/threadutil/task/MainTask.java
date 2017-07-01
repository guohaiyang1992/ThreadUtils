package com.hfga.threadutil.task;

import com.hfga.threadutil.thread.IThread;

/**
 * Created by guohaiyang on 2017/6/30.
 */

public abstract class MainTask extends AbsTask {

    public MainTask() {

    }

    public MainTask(int delay) {
        this.delayTime = delay;
    }

    @Override
    public IThread getThread() {
        return AbsTask.MAIN;
    }
}
