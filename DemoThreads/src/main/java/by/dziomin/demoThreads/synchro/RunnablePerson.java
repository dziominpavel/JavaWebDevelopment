package by.dziomin.demoThreads.synchro;

public class RunnablePerson extends Person implements Runnable {

    private String res;

    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (res) {
            String nameT = getName();
            long timeout = 0;
            System.out.println("Старт потока " + nameT);
            for (int i = 0; i < 20; i++) {
                System.out.println("hello world i'm " + super.getName());
                try {
                    Thread.sleep(100);
//                TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException newE) {
                    newE.printStackTrace();
                }
            }
            System.out.println("Конец потока " + nameT);
        }
    }
}

