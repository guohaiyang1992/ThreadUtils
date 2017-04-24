package com.guohaiyang.threadutils.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.guohaiyang.threadutils.R;
import com.hfga.threadutil.Task;
import com.hfga.threadutil.TaskManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        taskManager.addTask(new Task(true) {
//            @Override
//            public void runInTask() {
//                Log.v("info", "1" + Thread.currentThread().getName());
//                printTest(1, 100);
//            }
//        }).addTask(new Task(true) {
//            @Override
//            public void runInTask() {
//                Log.v("info", "2" + Thread.currentThread().getName());
//                printTest(2, 100);
//            }
//        }).addTask(new Task(false) {
//            @Override
//            public void runInTask() {
//                Log.v("info", "3" + Thread.currentThread().getName());
//                printTest(3, 100);
//            }
//        }).addTask(new Task(true) {
//            @Override
//            public void runInTask() {
//                Log.v("info", "4" + Thread.currentThread().getName());
//                printTest(4, 100);
//            }
//        });
        TaskManager taskManager = TaskManager.getNewInstance();
        taskManager.addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "1" + Thread.currentThread().getName());
                printTest(1, 100);
            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "2" + Thread.currentThread().getName());
                printTest(2, 100);
            }
        }).addTask(new Task(false) {
            @Override
            public void runInTask() {
                Log.v("info", "3" + Thread.currentThread().getName());
                printTest(3, 100);
            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "4" + Thread.currentThread().getName());
                printTest(4, 100);
            }
        });
//
//        taskManager.addTask(new ShowDialogTask()).addTask(new GetDataFromDb()).addTask(new DisMissDialogTask());
//
        taskManager.start();
//
        TaskManager taskManager2 = TaskManager.getNewInstance();
        taskManager2.addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "1" + Thread.currentThread().getName());
                printTest(1, 100);
            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "2" + Thread.currentThread().getName());
                printTest(2, 100);
            }
        }).addTask(new Task(false) {
            @Override
            public void runInTask() {
                Log.v("info", "3" + Thread.currentThread().getName());
                printTest(3, 100);
            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {
                Log.v("info", "4" + Thread.currentThread().getName());
                printTest(4, 100);
            }
        });
//
        taskManager2.addTask(new ShowDialogTask()).addTask(new GetDataFromDb()).addTask(new DisMissDialogTask());
//
        taskManager2.start();

        TaskManager.getNewInstance().addTask(new Task() {
            @Override
            public void runInTask() {

            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {

            }
        }).addTask(new Task() {
            @Override
            public void runInTask() {

            }
        }).addTask(new Task(true) {
            @Override
            public void runInTask() {

            }
        }).start();


    }

    public void printTest(int log, int size) {
        for (int i = 0; i < size; i++) {
            Log.v("printTest", "log:" + log + ":" + i + "个");
        }
    }

    class ShowDialogTask extends Task {


        public ShowDialogTask() {
            super(false);
        }

        @Override
        public void runInTask() {
            Log.v("test", "显示dialog");
        }
    }

    class GetDataFromDb extends Task {

        /**
         * 构造函数
         */
        public GetDataFromDb() {
            super(true);
        }

        @Override
        public void runInTask() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Log.v("test", "数据库获取数据");
        }
    }


    class DisMissDialogTask extends Task {


        public DisMissDialogTask() {
            super(false);
        }

        @Override
        public void runInTask() {
            Log.v("test", "隐藏dialog");
        }
    }

}
