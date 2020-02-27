import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicbarrierDemo {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("神龙");
        });
        for (int i = 0; i < 7; i++) {
            final int temp=i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t"+temp);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            },String.valueOf(i)).start();
        }

    }
}
