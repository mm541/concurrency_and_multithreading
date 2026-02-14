import jdk.jfr.Threshold;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int count = 0;
    public static void main() throws InterruptedException {

        Counter counter = new Counter();
        Counter counter1 = new Counter();

        Thread t1 = new Thread(counter, "t1");
        Thread t2 = new Thread(counter1, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Counter.count);
    }
}
