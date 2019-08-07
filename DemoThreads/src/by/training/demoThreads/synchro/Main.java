package by.training.demoThreads.synchro;

public class Main extends Thread {

    public static void main(String[] args) {


        ////isAlive();
////interrupt();
////потоки демоны;


        System.out.println(" main");

        RunnablePerson p1 = new RunnablePerson("alisa");
        Thread t1 = new Thread(p1);

        RunnablePerson p2 = new RunnablePerson("bob");
        Thread t2 = new Thread(p2);

        System.out.println(t1.getName() + " " + t1.getState());
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        Thread.yield();
        System.out.println(t1.getName() + " " + t1.getState());
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();

        try {
            //main ждет окончание потока t1
            t1.join();
        } catch (InterruptedException newE) {
            newE.printStackTrace();
        }

        System.out.println(currentThread().getName() + "Остановлен");

    }
}



