import jdk.jfr.Threshold;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(() -> {
            for(int i=0;i < 10; i++) {
                System.out.println("main: "+" "+mainThread.getState()+" t: "+Thread.currentThread().getState());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        });

        t.start();
        t.join();
        System.out.println("main: "+mainThread.getState()+" t:"+t.getState());

    }
}
