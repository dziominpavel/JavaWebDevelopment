package by.dziomin.demoThreads.task_06_synchronized;

import static java.lang.Thread.sleep;

public class ThreadsApp {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 6 ; i++){
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток " + i);
            t.start();
        }
    }
}
