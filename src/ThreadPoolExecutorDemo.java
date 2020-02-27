import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {


    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{

                System.out.println(Thread.currentThread().getName()+"\t提交");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

    }
}
