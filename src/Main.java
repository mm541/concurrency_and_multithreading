import jdk.jfr.Threshold;

import java.util.Random;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Random random = new Random();

    public static void main() throws InterruptedException {
        final Elements elements = new Elements(10);
        Thread producer = new Thread(()-> {
            try{
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while(true) {
               int ele = random.nextInt();
                try {
                    elements.produce(ele);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "producer");
        Thread consumer = new Thread(()-> {
            while(true) {
                try {
                    elements.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"consumer");
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
//        while(true) {
//            System.out.println("Producer: "+producer.getState()+" Consumer: "+consumer.getState());
//            sleep(500);
//        }
    }
}
