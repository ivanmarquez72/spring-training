package Concurrency2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Synchro {
    int count = 0;

    void increment(){
        count = count + 1;
    }

    ConcurrentUtils cc = new ConcurrentUtils();

    public void ejemplo(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));

        cc.stop(executor);

        System.out.println(count);
        count = 0;
    }

    synchronized void incrementSync(){
        count = count + 1;
    }

    public void ejemplo2(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::incrementSync));

        cc.stop(executor);

        System.out.println(count);
    }
    public void incremenSync(){
        synchronized (this) {
            count = count + 1;
        }
    }
}
