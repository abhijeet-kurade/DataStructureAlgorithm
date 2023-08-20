package Stacks.StackImpl;

public class  DynamicStack{
    int capacity;
    private int[] stackArray;
    private int top;

    public DynamicStack(int size){
        this.top = 0;
        this.capacity = size;
        this.stackArray = new int[size];
    }

    public int size(){
        return this.top;
    }

    public boolean clear(){
        this.top = 0;
        return true;
    }

    public boolean isFull(){
        if(this.top == this.capacity)
            return true;
        else
            return false;
    }

    public boolean isEmpty(){
        if(this.top == 0)
            return true;
        else
            return false;
    }

    private void resize(){
        int doubleSize = this.capacity * 2;
        int[] newArray = new int[doubleSize];
        int index =0;
        for(int i : this.stackArray){
            newArray[index++] = i;
        }
        this.capacity = doubleSize;
        this.stackArray = newArray;
    }

    public void shrink(){
        int halfSize = this.capacity/2;
        int[] newArray = new int[halfSize];
        for(int i=halfSize-1; i>=0; i--){
            newArray[i] = this.stackArray[i];
        }
        this.stackArray = newArray;
        this.capacity = halfSize;

    }

    public boolean push(int val){
        if(isFull())
            this.resize();
        stackArray[this.top++] = val;
        return true;
    }

    public int pop(){
        int val = -1;
        if(isEmpty()){
            System.out.println("Array underflow");
        }
        else{
            --this.top;
            val = stackArray[this.top];
            stackArray[this.top] = 0;
            if(this.top == ((this.capacity/2))){
                this.shrink();
            }
        }
        return val;
    }

    public void printStack(){
        for(int i= this.stackArray.length-1; i>=0; i--)
            System.out.print(this.stackArray[i]+" ");
        System.out.println();
    }


}
