package by.dziomin.demoThreads.task_09_threadProducerConsumer;

class Consumer extends Thread {
    final int N = 5; // максимально допустимое число
    Store store; // объект склада, с которого покупатель будет брать товар
    int product = 0; // текущее количество товаров со склада

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {


        try {
            while (product < N) {// пока количество товаров не будет равно 5
                product = product + store.get(); // берем по одному товару со склада
                System.out.println("Потребитель купил " + product + " товар(ов)");

                sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(" поток потребителя прерван ");
        }
    }
}
