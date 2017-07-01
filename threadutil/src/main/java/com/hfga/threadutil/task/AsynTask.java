package com.hfga.threadutil.task;

import com.hfga.threadutil.thread.IThread;
import com.hfga.threadutil.thread.UiThread;

/**
 * Created by guohaiyang on 2017/6/30.
 */

public abstract class AsynTask extends AbsTask {

    public AsynTask() {

    }

    public AsynTask(int delay) {
        this.delayTime = delay;
    }

    @Override
    public IThread getThread() {
        return AbsTask.ASYN;
    }
}
