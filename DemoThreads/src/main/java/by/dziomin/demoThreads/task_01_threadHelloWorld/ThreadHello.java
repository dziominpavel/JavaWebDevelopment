package by.dziomin.demoThreads.task_01_threadHelloWorld;

public class ThreadHello extends Thread {
    @Override
    public void run() {
        System.out.println(currentThread().getName() + ", Hello world!");
    }
}
