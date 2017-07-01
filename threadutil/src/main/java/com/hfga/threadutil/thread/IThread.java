package com.hfga.threadutil.thread;

import com.hfga.threadutil.task.AbsTask;

/**
 * Created by guohaiyang on 2017/6/30.
 */

public interface IThread {
    public void run(AbsTask task, int delay);
}
