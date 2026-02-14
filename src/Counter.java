public class Counter  implements Runnable{


    public static Integer count = 0;
    private static final Object obj = new Object();
    public Counter() {}

    @Override
    public void run() {
        for(int i=0;i < 100000; i++) {
            synchronized (obj) {
                count++;
            }
        }
    }
}
