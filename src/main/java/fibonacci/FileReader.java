package fibonacci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Nigel on 6/28/16.
 */
public class FileReader implements Runnable {
    File file = new File("fibdata.txt");
    Scanner fileReader = new Scanner(file);
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

    public FileReader(BlockingQueue<Integer> queue) throws FileNotFoundException {
        this.queue = queue;
    }

    /**
     * Reads output from a file and injects them into a Blocking Queue.
     */
    @Override
    public void run() {
        while (fileReader.hasNextInt()){
            try {
                queue.put(fileReader.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
