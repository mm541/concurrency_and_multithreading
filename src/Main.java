import jdk.jfr.Threshold;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Thread t = new Thread (() -> {
            for(int i=0; i<1000000 ; i++);
        });
        System.out . println( t . getState () );
        t.start();
        while(t.getState() != Thread.State.TERMINATED) {
            System.out.println(t.getState());
        }

    }
}
