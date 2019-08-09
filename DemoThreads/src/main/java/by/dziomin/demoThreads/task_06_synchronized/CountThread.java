package by.dziomin.demoThreads.task_06_synchronized;

class CountThread implements Runnable {
    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    public void run() {
        res.increment();
    }
}
