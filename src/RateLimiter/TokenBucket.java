package RateLimiter;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    public static void main(String[] args) {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(10, 1, 1000);

        Runnable task = () -> {
            while (true) {
                if (rateLimiter.tryConsume(1)) {
                    System.out.println(Thread.currentThread().getName() + ": Token consumed.");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": No tokens available.");
                }

                try {
                    Thread.sleep(400);
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
class TokenBucketRateLimiter {
    private final long capacity;
    private final long refillTokens;
    private final long refillIntervalMillis;
    private final AtomicLong availableTokens;
    private final AtomicLong lastRefillTimestamp;

    public TokenBucketRateLimiter(long capacity, long refillTokens, long refillIntervalMillis) {
        this.capacity = capacity;
        this.refillTokens = refillTokens;
        this.refillIntervalMillis = refillIntervalMillis;
        this.availableTokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = new AtomicLong(System.currentTimeMillis());
    }

    public boolean tryConsume(long tokens) {
        refill();
        long currentTokens = availableTokens.get();
        if (currentTokens >= tokens) {
            availableTokens.addAndGet(-tokens);
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long lastRefill = lastRefillTimestamp.get();
        if (now > lastRefill) {
            long elapsedTime = now - lastRefill;
            long newTokens = (elapsedTime / refillIntervalMillis) * refillTokens;
            if (newTokens > 0) {
                if (lastRefillTimestamp.compareAndSet(lastRefill, now)) {
                    availableTokens.getAndUpdate(tokens -> Math.min(capacity, tokens + newTokens));
                }
            }
        }
    }

    public long getAvailableTokens() {
        refill();
        return availableTokens.get();
    }

    public long getCapacity() {
        return capacity;
    }

    public long getRefillTokens() {
        return refillTokens;
    }

    public long getRefillIntervalMillis() {
        return refillIntervalMillis;
    }
}