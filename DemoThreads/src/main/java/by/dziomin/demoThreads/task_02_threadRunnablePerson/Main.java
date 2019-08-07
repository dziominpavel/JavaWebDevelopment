package by.dziomin.demoThreads.task_02_threadRunnablePerson;

public class Main {

    public static void main(String[] args) {
        System.out.println(" main");

        RunnablePerson p1 = new RunnablePerson("alisa");
        Thread t1 = new Thread(p1);

        RunnablePerson p2 = new RunnablePerson("bob");
        Thread t2 = new Thread(p2);

        System.out.println(t1.getName() + " " + t1.getState());
        t1.start();
        System.out.println(t1.getName() + " " + t1.getState());
        t2.start();

        try {
            //main ждет окончание потока t1
            t1.join();
        } catch (InterruptedException newE) {
            newE.printStackTrace();
        }
        System.out.println(t1.getName() + " " + t1.getState());
    }
}



