import java.util.concurrent.CountDownLatch;

public class CountdownlatchDemo {

    private static CountDownLatch countDownLatch=new CountDownLatch(7);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <=7; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+temp);
                countDownLatch.countDown();
            },"i").start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"神龙");
    }
}
