package com.hfga.threadutil;

/**
 * Created by guohaiyang on 2017/4/10.
 * task存储上下task关系，通过执行run方法，并判断标志位进行主线程和子线程切换
 *
 */

public abstract class Task implements Runnable {
    //下一个任务
    private Task afterTask;
    //标志为是否在线程中执行
    private boolean isBackGround = false;

    /**
     * 构造函数
     *
     * @param isBackGround 标志：是不是子线程执行
     */
    public Task(boolean isBackGround) {
        this.isBackGround = isBackGround;
    }

    /**
     * 默认是ui线程
     */
    public Task() {
        this.isBackGround = false;
    }

    public Task getAfterTask() {
        return afterTask;
    }

    public boolean isBackGround() {
        return isBackGround;
    }

    @Override
    public void run() {
        if (isBackGround) {
            ThreadUtils.runInBackGroundThread(new Runnable() {
                @Override
                public void run() {
                    runInTask();
                    runAfterTask();
                }
            });

        } else {
            ThreadUtils.runInUiThread(new Runnable() {
                @Override
                public void run() {
                    runInTask();
                    runAfterTask();
                }
            });
        }
    }

    protected void runAfterTask() {
        if (afterTask != null) {
            afterTask.run();
        }
    }

    public abstract void runInTask();

    /**
     * 添加下一个task
     *
     * @param task 需要添加的task
     * @return 返回当前添加的task用于下次添加
     */
    public Task addNextTask(Task task) {
        setAfterTask(task);
        return task;
    }

    private void setAfterTask(Task afterTask) {
        this.afterTask = afterTask;
    }
}
