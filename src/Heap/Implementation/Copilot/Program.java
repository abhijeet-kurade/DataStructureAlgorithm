package Heap.Implementation.Copilot;

import Heap.Implementation.Copilot.UpdatingMaxHeap.MaxHeap;

import java.util.Objects;

public class Program {

    static class Flat implements Comparable {
        int floor;
        char number;
        int people;
        String owner;

        public Flat(int floor, char number, int people, String owner) {
            this.floor = floor;
            this.number = number;
            this.people = people;
            this.owner = owner;
        }


        @Override
        public int compareTo(Object o) {
            if(o == null) return -1;
            return this.people - ((Flat)o).people;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Flat flat)) return false;
            return floor == flat.floor && number == flat.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(floor, number);
        }

        @Override
        public String toString() {
            return "Flat{" +
                    "floor=" + floor +
                    ", number=" + number +
                    ", people=" + people +
                    ", owner='" + owner + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        MaxHeap<Flat> heap = new MaxHeap<>();

        heap.insert(new Flat(5,'a',4,"abk"));
        heap.insert(new Flat(6,'b',12,"sdk"));
        heap.insert(new Flat(5,'b',6,"fzk"));
        heap.update(new Flat(6,'b',3,"fdg"));

        while (!heap.isEmpty()){
            System.out.println(heap.extractMax());
        }
    }
}
