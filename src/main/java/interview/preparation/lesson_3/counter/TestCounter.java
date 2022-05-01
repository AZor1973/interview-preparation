package interview.preparation.lesson_3.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCounter {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(ThreadSafeCounter::increment);
        executor.submit(ThreadSafeCounter::increment);
        executor.submit(ThreadSafeCounter::increment);
        executor.submit(ThreadSafeCounter::getCount);
        executor.submit(ThreadSafeCounter::increment);
        executor.submit(ThreadSafeCounter::increment);
        executor.submit(ThreadSafeCounter::decrement);
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ThreadSafeCounter.getCount();
        });
        executor.shutdown();
    }
}
