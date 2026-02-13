import jdk.jfr.Threshold;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for(long i=0;i < 100000000000L; i++);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (obj) {
                for(int i=0;i < 100000000; i++);
            }
        }, "t2");
        t1.start();
        t2.start();

        while(t1.isAlive() || t2.isAlive()) {
            System.out.println(t1.getName()+" "+t1.getState());
            System.out.println(t2.getName()+" "+t2.getState());
        }
    }
}
