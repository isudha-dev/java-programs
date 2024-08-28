package concepts.Concurrency;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomThreadExecutor());
//        ThreadPoolExecutor tpe2 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2));

        for (int i = 0; i < 8; i++) {
            tpe.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Executing thread: "+Thread.currentThread().getName());
            });
        }

        tpe.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setDaemon(false);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}

class CustomThreadExecutor implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Thread rejected: "+Thread.currentThread().getName());
    }
}
