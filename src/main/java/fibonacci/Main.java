package fibonacci;

import java.io.FileNotFoundException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nigel on 6/28/16.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Create the Executor Service and Blocking Queue Object.
        ExecutorService service = Executors.newFixedThreadPool(100);
        BlockingQueue<Integer> blockQueue = new ArrayBlockingQueue<>(1000);

        //Create 2 separate threads.
        Thread producer = new Thread(new FileReader(blockQueue));
        Thread consumer = new Thread(new QueueReader(blockQueue));

        //Don't forget to start the threads.
        consumer.start();
        producer.start();

    }
}