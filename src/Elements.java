public class Elements {
    private final Object obj = new Object();
    private final int[] arr;
    private int index;

    public Elements(int n) {
        arr = new int[n];
        index = -1;
    }

    public void produce(int ele) throws InterruptedException {
        synchronized (obj) {
            while(arr.length-1 == index) obj.wait();
            index++;
            System.out.println("Produced: "+"{ index: "+ index+" value: "+ele+"}");
            arr[index] = ele;
            obj.notify();
        }
    }

    public int consume() throws InterruptedException {
        int element;
        synchronized (obj) {
            while(index == -1) obj.wait();
            element = arr[index];
            System.out.println("Consumed: "+"{ index: "+ index+" value: "+element+"}");
            index--;
            obj.notify();

        }
        return element;
    }

}
