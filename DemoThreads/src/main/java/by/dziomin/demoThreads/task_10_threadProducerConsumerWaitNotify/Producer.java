package by.dziomin.demoThreads.task_10_threadProducerConsumerWaitNotify;

class Producer extends Thread {
    Store store;
    Producer(Store store) {
        this.store = store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
