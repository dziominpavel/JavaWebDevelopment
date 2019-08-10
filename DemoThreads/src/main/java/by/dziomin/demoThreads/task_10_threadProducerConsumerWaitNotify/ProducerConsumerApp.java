package by.dziomin.demoThreads.task_10_threadProducerConsumerWaitNotify;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }
}