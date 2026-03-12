package com.mjc813;

import java.util.concurrent.*;

public class Thread3 {
    ExecutorService es = Executors.newFixedThreadPool(10);

    public void testThread3() {
        this.es.execute(new Thread2());

        Future<Integer> result = this.es.submit(new CallableClass(1, 10000));
        try {
            System.out.printf("%s, testThread3, result = %d\n", Thread.currentThread().getName(), result.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.toString());
        }
    }

    public void close() {
        this.es.shutdown();
    }
}
