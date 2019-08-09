package by.dziomin.demoThreads.task_01_threadHelloWorld;

public class Main extends Thread {

    public static void main(String[] args) {
//        System.out.println(curr);
        System.out.println(currentThread().getName() + " main");
        ThreadHello threadHello = new ThreadHello();
        System.out.println("state = " + threadHello.getState());
        threadHello.start();
        System.out.println("state = " + threadHello.getState());
    }
}



//7.	синхронизация записи информации в файл, стр. 302
//8.	потокобезопасность класса StringBuffer, стр. 304
//9.	threadProducer-Consumer
//10.	threadProducer-Consumer_wait_notify
//11.	threadCommonResourceReentrantLock
//12.	threadProducerConsumerReentrantLock
//13.	threadCommonResourceSemaphore
//14.	threadDiningPhilosophers
//15.	пул ресурсов, стр. 313
//16.	threadBlockingQueue
//17.	threadAuction
//18.	CountDownLatch - «Щеколда», стр. 320
//19.	ExecutorService и Callable
//20.	threadExchanger
//21.	theadPhaser