package RateLimiter;

import java.util.concurrent.atomic.AtomicLong;

public class FixedWindow {
}

class FixedWindowRateLimiter {
    private final long capacity;
    private final long windowSizeMillis;
    private final AtomicLong currentWindowStart;
    private final AtomicLong requestCount;

    public FixedWindowRateLimiter(long capacity, long windowSizeMillis) {
        this.capacity = capacity;
        this.windowSizeMillis = windowSizeMillis;
        this.currentWindowStart = new AtomicLong(System.currentTimeMillis());
        this.requestCount = new AtomicLong(0);
    }

    public boolean tryConsume() {
        long now = System.currentTimeMillis();
        long windowStart = currentWindowStart.get();

        if (now - windowStart >= windowSizeMillis) {
            currentWindowStart.set(now);
            requestCount.set(0);
        }

        if (requestCount.get() < capacity) {
            requestCount.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    public long getCurrentWindowStart() {
        return currentWindowStart.get();
    }

    public long getRequestCount() {
        return requestCount.get();
    }

    public long getCapacity() {
        return capacity;
    }

    public long getWindowSizeMillis() {
        return windowSizeMillis;
    }
}
