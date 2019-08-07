package by.training.demoThreads.task_02_threadRunnablePerson;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello world i'm " + super.getName());
            try {
                Thread.sleep(100);
//                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException newE) {
                newE.printStackTrace();
            }
        }
    }
}

