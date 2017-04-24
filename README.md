# ThreadUtils
android简单的链式线程切换工具类，简单适用，可用于学习线程相关知识

简单的链式调用的线程切换工具
详细教程请看博客：http://blog.csdn.net/guohaiyang1992/article/details/70665374 

简单的使用教程如下：
TaskManager.getNewInstance().addTask(new Task() {
            @Override
            public void runInTask() {
            //主线程
           }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
            //子线程
            }
        }).addTask(new Task() {
            @Override
            public void runInTask() {
            //主线程
            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
            //子线程
            }
        }).start();
