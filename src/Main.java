import jdk.jfr.Threshold;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Thread.setDefaultUncaughtExceptionHandler((thread, ex)-> {
            System.out.println(ex.getMessage());
        });
       Thread t1 = new Thread(() -> {
           System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            throw new RuntimeException("Something went wrong");
       });
        t1.start();
        System.out.println(10/0);
        System.out.println(Thread.currentThread().getName());
    }
}
