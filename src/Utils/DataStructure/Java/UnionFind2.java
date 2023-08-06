package Utils.DataStructure.Java;

import java.util.HashMap;

public class UnionFind2 {

    public static void main(String[] args) {
        UnionFind2 uf = new UnionFind2();
        uf.union(3, 100);
        uf.union(13, 101);
        uf.union(31, 3);
        uf.union(13, 200);
        uf.union(13, 400);
        System.out.println(uf.find(3));
        System.out.println(uf.find(13));
        System.out.println(uf.find(31));
        System.out.println(uf.find(100));
        System.out.println(uf.find(400));
    }


    HashMap<Integer, Integer> map;

    public UnionFind2(){
        this.map = new HashMap<>();
    }

    public int find(int x){
        if(x != this.map.get(x)){
            this.map.put(x, find(this.map.get(x)));
        }
        return this.map.get(x);
    }

    public void union(int x, int y){
        if(!this.map.containsKey(x)) this.map.put(x, x);
        if(!this.map.containsKey(y)) this.map.put(y, y);
        this.map.put(find(x), find(y));
    }
}
