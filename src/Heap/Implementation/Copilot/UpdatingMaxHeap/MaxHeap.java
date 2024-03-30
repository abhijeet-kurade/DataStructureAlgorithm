package Heap.Implementation.Copilot.UpdatingMaxHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxHeap <T extends Comparable>{

    Map<T, Integer> indices;
    List<T> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(null);
        indices = new HashMap<>();
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

        indices.put(heap.get(i), i);
        indices.put(heap.get(j), j);
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
        indices.put(element, curr);
        while (heap.get(curr).compareTo(heap.get(parent(curr))) > 0){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public T extractMax(){
        if(heap.size() <= 1){
            throw new IllegalStateException("Heap is empty.");
        }
        T element = heap.get(1);
        indices.remove(element);
        heap.set(1, heap.get(heap.size()-1));
        indices.put(heap.get(1),1);
        heap.remove(heap.size()-1);
        maxHeapify(1);
        return element;
    }
    public boolean contains(T element){
        return indices.containsKey(element);
    }

    public void update(T element){
        if(!contains(element)){
            throw new IllegalStateException("Element does not exist.");
        }
        T old = heap.get(indices.get(element));
        indices.put(element, indices.get(element));
        heap.set(indices.get(element), element);
        if(old.compareTo(element) > 0){
            maxHeapify(indices.get(element));
        }
        else{
            int curr = indices.get(element);
            while (heap.get(curr).compareTo(heap.get(parent(curr))) > 0){
                swap(curr, parent(curr));
                curr = parent(curr);
            }
        }
    }
}
