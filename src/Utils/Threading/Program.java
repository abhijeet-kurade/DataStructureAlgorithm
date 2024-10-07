package Utils.Threading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {

    
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();
        Lock lock = new ReentrantLock();
        map.put(1, 0);

        T1 t1 = new T1(map, lock);
        T2 t2 = new T2(map, lock);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.get(1));
    }


}

class T1 extends Thread{

    Lock lock ;
    Map<Integer, Integer> map ;

    public T1(Map<Integer, Integer> map, Lock lock){
        this.map = map;
        this.lock = lock;
    }
    @Override
    public void run() {
        super.run();
        for(int i=0; i<1000; i++){

            lock.lock();
                map.put(1, map.get(1)+1);
            lock.unlock();

        }
    }
}

class T2 extends Thread{

    Lock lock ;
    Map<Integer, Integer> map ;

    public T2(Map<Integer, Integer> map, Lock lock){
        this.map = map;
        this.lock = lock;
    }
    @Override
    public void run() {
        super.run();
        for(int i=0; i<1000; i++){

            lock.lock();
                map.put(1, map.get(1)-1);
            lock.unlock();

        }
    }
}
/*
 i = 0

 t1 = 1 => 1

 t2 = -1-2-3
 */