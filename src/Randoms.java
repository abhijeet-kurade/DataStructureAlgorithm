import java.util.Collections;
import java.util.List;

public class Randoms {
    public static void main(String[] args) {

        System.out.println();
        /*LinkedList<Integer> ll = new LinkedList<>();
        ll.add(new LinkedListNode<>(5));
        ll.add(new LinkedListNode<>(554));
        ll.add(new LinkedListNode<>(55436));*/
    }

    public void fun(Room sd){

    }


    public List<Room> method(List<Room> rooms) {

        Collections.sort(rooms, (o1, o2) -> {
            if(o1.size != o2.size){
                return o1.size - o2.size;
            }
            return o1.seats - o2.seats;
        });

        fun(new TeachingRoom());

        return rooms;
    }
}

class Room{
    int size;
    int seats;
    int table;
}

class TeachingRoom extends Room{

}



class LinkedList<T>{
    LinkedListNode<T> head;
    LinkedListNode<T> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;

        size = 0;
    }

    public void add(LinkedListNode<T> node){
        if(head == null){
            head = node;
        }
        else {
            tail.next = node;
        }
        tail = node;
        node.next = null;
        size += 1;
    }

    public void remove(){

    }
}

class LinkedListNode<T>{

    T data;
    LinkedListNode next;


    public LinkedListNode(T data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }




}
