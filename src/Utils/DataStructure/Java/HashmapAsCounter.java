package Utils.DataStructure.Java;

import java.util.HashMap;

public class HashmapAsCounter {
    public static void main(String[] args) {
        // a b b a a c a e f
        // count of(a b c d e)
        // remove a e f b b

        Counter<Character> counter = new Counter<>();
        counter.add('a');
        counter.add('b');
        counter.add('b');
        counter.add('a');
        counter.remove('b');
        counter.add('a');
        System.out.println(counter.getCount('b'));

    }

    static class Counter<K>{
        HashMap<K, Integer> counter;

        public Counter() {
            this.counter = new HashMap<>();
        }

        public void add(K key){
            this.counter.put(key, this.counter.getOrDefault(key, 0) + 1);
        }

        public boolean remove(K key){
            this.counter.put(key, this.counter.getOrDefault(key, 0) - 1);
            if(this.counter.get(key) < 0){
                this.counter.remove(key);
                return false;
            }
            if(this.counter.get(key) == 0){
                this.counter.remove(key);
                return true;
            }
            return true;
        }

        public Integer getCount(K key){
            return this.counter.getOrDefault(key, 0);
        }
    }
}
