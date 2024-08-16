package RateLimiter;
import java.util.concurrent.atomic.AtomicLong;


public class LeakyBucket {
    public static void main(String[] args) {
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(10, 1);

        Runnable task = () -> {
            while (true) {
                if (rateLimiter.tryConsume(1)) {
                    System.out.println(Thread.currentThread().getName() + ": Token consumed.");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": No capacity available.");
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}

class LeakyBucketRateLimiter {
    private final long capacity;
    private final long leakRate;
    private final AtomicLong currentWaterLevel;
    private final AtomicLong lastLeakTimestamp;

    public LeakyBucketRateLimiter(long capacity, long leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.currentWaterLevel = new AtomicLong(0);
        this.lastLeakTimestamp = new AtomicLong(System.currentTimeMillis());
    }

    public boolean tryConsume(long tokens) {
        leak();
        long currentLevel = currentWaterLevel.get();
        if (currentLevel + tokens <= capacity) {
            currentWaterLevel.addAndGet(tokens);
            return true;
        } else {
            return false;
        }
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long lastLeak = lastLeakTimestamp.get();
        if (now > lastLeak) {
            long elapsedTime = now - lastLeak;
            long leakedWater = (elapsedTime * leakRate) / 1000;
            if (leakedWater > 0) {
                long newTimestamp = lastLeak + (leakedWater * 1000) / leakRate;
                if (lastLeakTimestamp.compareAndSet(lastLeak, newTimestamp)) {
                    currentWaterLevel.getAndUpdate(level -> Math.max(0, level - leakedWater));
                }
            }
        }
    }

    public long getCurrentWaterLevel() {
        leak();
        return currentWaterLevel.get();
    }

    public long getCapacity() {
        return capacity;
    }

    public long getLeakRate() {
        return leakRate;
    }
}
