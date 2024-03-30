package Heap.Implementation.Copilot.StandardFixedSizeHeap;

public class Heap {
    private int[] heap;
    private int size;
    private int maxsize;

    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.heap = new int[this.maxsize+1];
        this.heap[0]  = Integer.MAX_VALUE;
    }

    private int parent(int pos){
        return pos/2;
    }
    private int leftChild(int pos){
        return 2*pos;
    }
    private int rightChild(int pos){
        return (2*pos) + 1;
    }

    private boolean isLeaf(int pos){
        if(pos > (size/2) && pos <= size) return true;
        return false;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            if(heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]){
                if(heap[leftChild(pos)] > heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element){
        size += 1;
        heap[size] = element;
        int curr = size;
        while (heap[curr] > heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int extractMax(){
        int element = heap[1];
        heap[1] = heap[size];
        size -= 1;
        maxHeapify(1);
        return element;
    }
}
