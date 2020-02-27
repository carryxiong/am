import java.util.concurrent.Semaphore;

public class SemaphoreDemo {



    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for(int i=1;i<=6;i++)
        {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
