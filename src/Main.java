import jdk.jfr.Threshold;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int count = 0;
    public static void main() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for(int i=0;i < 100000; i++) count++;
        }, "t1");
        Thread t2 = new Thread(() -> {
            for(int i=0;i < 100000; i++) count++;
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
