package fibonacci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * Created by jeff on 6/28/16.
 */
public class Fibonacci implements Runnable {
    private int num;
    private long fibnum;

    public Fibonacci(int desiredNumber) {
        this.num = desiredNumber;
    }

    /**
     * Recursive fibonacci algorithm.  Majorly inefficient
     *
     * @param number The nth number in the series to find
     * @return the long of the found number
     */
    public long fib(int number) {
        long rval = 0;
        if (number < 1) {
            rval = 0;
        } else if (number == 1) {
            rval = 1;
        } else {
            rval = fib(number - 1) + fib(number - 2);
        }
        this.fibnum = rval;
        return rval;
    }

    /**
     *Prints the iteration of the Fibbonacci and the number in the sequence.
     */
    @Override
    public void run() {
        System.out.printf("The %dth number in Fibbonacci is: %d\n", this.num, this.fibnum);
    }
}