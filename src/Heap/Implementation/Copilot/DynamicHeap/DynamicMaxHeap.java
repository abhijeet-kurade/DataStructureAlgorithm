package Heap.Implementation.Copilot.DynamicHeap;

import java.util.ArrayList;
import java.util.List;

public class DynamicMaxHeap {

    List<Integer> heap;

    public DynamicMaxHeap() {
        heap = new ArrayList<>();
        heap.add(Integer.MAX_VALUE);
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
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;

            if(left < heap.size() && heap.get(left) > heap.get(largest)){
                largest = left;
            }
            if(right < heap.size() && heap.get(right) > heap.get(largest)){
                largest = right;
            }

            if(largest != pos){
                swap(pos, largest);
                maxHeapify(largest);
            }
        }
    }
    public void insert(int element){
        heap.add(element);
        int curr = heap.size()-1;
        while (heap.get(curr) < heap.get(parent(curr))){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int extractMax(){
        int element = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        maxHeapify(1);
        return element;
    }
}
