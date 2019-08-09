package by.dziomin.demoThreads.task_05_threadThreadToDisable;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Главный поток начал работу...");
                ThreadToDisable myThread = new ThreadToDisable();
        Thread myT = new Thread(myThread, "name of ThreadToDisable");
                myT.start();
        try {
            Thread.sleep(1100);
            myThread.disable();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(" Поток прерван");
        }
        System.out.println(" Главный поток завершил работу..");



    }
}
