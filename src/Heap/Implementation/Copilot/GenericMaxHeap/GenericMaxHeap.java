package Heap.Implementation.Copilot.GenericMaxHeap;

import java.util.ArrayList;
import java.util.List;

public class GenericMaxHeap <T extends Comparable>{
    List<T> heap;

    public GenericMaxHeap() {
        heap = new ArrayList<>();
        heap.add(null);
    }

    private int parent(int pos){
        return pos/2;
    }

    private int leftChild(int pos){
        return 2 * pos;
    }

    private int rightChild(int pos){
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos){
        return pos > heap.size()/2 && pos < heap.size();
    }

    private void swap(int i, int j){
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;

            if(left < heap.size() && heap.get(left).compareTo(heap.get(largest))>0){
                largest = left;
            }
            if(right < heap.size() && heap.get(right).compareTo(heap.get(largest))>0){
                largest = right;
            }

            if(largest != pos){
                swap(pos, largest);
                maxHeapify(largest);
            }
        }
    }

    public void insert(T element){
        heap.add(element);
        int curr = heap.size()-1;
        while (heap.get(curr).compareTo(heap.get(parent(curr))) > 0){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public T extractMax(){
        T element = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        maxHeapify(1);
        return element;
    }

}
