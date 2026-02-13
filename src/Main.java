import jdk.jfr.Threshold;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(() -> {
            for(int i=0;i < 10; i++) {
                System.out.println("priority: "+Thread.currentThread().getPriority()+" t: "+Thread.currentThread().getState());
                Thread temp = new Thread(() -> {
                    System.out.println(Thread.currentThread().isDaemon());
                });

                temp.start();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        });
        t.setPriority(7);
        t.setDaemon(true);
        t.start();

        t.join();
//        System.out.println("priority: "+mainThread.getPriority());

    }
}
