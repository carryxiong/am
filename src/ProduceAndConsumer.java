import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceAndConsumer {

 static class ResourceShared{
    private int num=1;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void print(int mode)
    {
        if(mode==1)
        {
            lock.lock();
            try{
                while(num!=1) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t "+i);
                }
                num=2;
                condition2.signal();
            }
            finally {
                lock.unlock();
            }
        }
        else if(mode==2)
        {
            lock.lock();
            try{
                while(num!=2) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t "+i);
                }
                num=3;
                condition3.signal();
            }
            finally {
                lock.unlock();
            }
        }
       else{
            lock.lock();
            try{
                while(num!=3) {
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 15; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t "+i);
                }
                num=1;
                condition1.signal();
            }
            finally {
                lock.unlock();
            }
        }



    }
}


    public static void main(String[] args) {
         ResourceShared resourceShared=new ResourceShared();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resourceShared.print(1);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resourceShared.print(2);
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resourceShared.print(3);
            }
        },"C").start();
    }
}
