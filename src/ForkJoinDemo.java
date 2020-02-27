import java.util.concurrent.*;

public class ForkJoinDemo {


    public static void main(String[] args) throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        MyTask task=new MyTask(0,100);
        ForkJoinTask<Integer> task1 = pool.submit(task);
        System.out.println(task1.get());
        pool.shutdown();
    }

}
class MyTask extends RecursiveTask<Integer>{

    private static  final Integer current=10;



    private int begin;
    private int end;
    private int result=0;

    public MyTask(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end-begin)<=current)
        {
            for (int i = begin; i <=end; i++)
            {
                result=result+i;
            }
        }
        else
        {
            int middle=(end+begin)/2;
            MyTask t1=new MyTask(begin,middle);
            MyTask t2=new MyTask(middle+1,end);
            t1.fork();
            t2.fork();
            result=t1.join()+t2.join();
        }
        return result;
    }
}