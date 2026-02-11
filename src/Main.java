import jdk.jfr.Threshold;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {

       Thread t1 = new Thread(() -> {
           System.out.println(Thread.currentThread().getName());
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           throw new RuntimeException("Haaa!");
       }, "My Thread");
        t1.setUncaughtExceptionHandler((a, e) -> {
            System.out.println(e.getMessage());
        });
        t1.start();
        System.out.println(10/0);


        System.out.println(Thread.currentThread().getName());
    }
}
