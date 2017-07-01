# ThreadUtils

### android简单的链式线程切换工具类，简单适用，可用于学习线程相关知识

简单的链式调用的线程切换工具
详细教程请看博客：http://blog.csdn.net/guohaiyang1992/article/details/70665374 

#### 简单的使用教程：
```java
        TaskManager.getNewInstance().onNext(new MainTask() {
            @Override
            public void runInTask() {
                Log.v("ghy", "main_thread:" + Thread.currentThread().getName());
                //主线程，没有延迟
            }
        }).onNext(new AsynTask(2000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "asyn_thread:" + Thread.currentThread().getName());
                //子线程，延迟 2000ms
            }
        }).onNext(new MainTask(3000) {
            @Override
            public void runInTask() {
                Log.v("ghy", "main_thread:" + Thread.currentThread().getName());
                //主线程，延迟3000ms
            }
        }).onNext(new AsynTask() {
            @Override
            public void runInTask() {
                Log.v("ghy", "asyn_thread:" + Thread.currentThread().getName());
                //子线程，无延迟
            }
        }).start();

```

----
#### 引入该库：
1.在你的project中的build.gradle中，按照如下设置
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2.在你的module中的build.gradle按照如下设置

	

```
dependencies {
	        compile 'com.github.guohaiyang1992:ThreadUtils:1.0'
	}
```
