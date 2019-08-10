package by.dziomin.demoThreads.task_10_threadProducerConsumerWaitNotify;

class Consumer extends Thread {
    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
