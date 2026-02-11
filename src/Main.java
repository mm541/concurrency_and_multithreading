import jdk.jfr.Threshold;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
            System.out.println(10/0);
        }, "My Thread");
        try {
            t1.start();
            Thread.sleep(5000);
//            System.out.println(10/0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName());

    }
}
