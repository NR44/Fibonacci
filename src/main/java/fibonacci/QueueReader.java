package fibonacci;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nigel on 6/28/16.
 */
public class QueueReader implements Runnable {
    ExecutorService service = Executors.newFixedThreadPool(100);
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

    public QueueReader(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * Reads the queue creates and calls a Fibbonacci object.
     */
    @Override
    public void run() {
        boolean done = false;
        int number = 0;

        while (!done || !queue.isEmpty()) {
            try {
                number = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                done = true;
                continue;
            }
            Fibonacci executeFibonacci = new Fibonacci(number);
            service.submit(executeFibonacci);
        }
    }
}
