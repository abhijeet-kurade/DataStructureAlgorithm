package Utils.DataStructure.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionFind {
    HashMap<Integer, Integer> map;
    List<Integer> parent;
    List<Integer> rank;

    public UnionFind() {
        this.map = new HashMap<>();
        this.parent = new ArrayList<>();
        this.rank = new ArrayList<>();
    }

    public void union(int x, int y){
        if(!this.map.containsKey(x)){
            int n = this.parent.size();
            this.map.put(x, n);
            this.parent.add(n);
            this.rank.add(0);
        }
        if(!this.map.containsKey(y)){
            int n = this.parent.size();
            this.map.put(y, n);
            this.parent.add(n);
            this.rank.add(0);
        }

        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(this.rank.get(px) > this.rank.get(py)){
            this.parent.set(py, px);
        }
        else if(this.rank.get(px) < this.rank.get(py)){
            this.parent.set(px, py);
        }
        else{
            this.rank.set(px, this.rank.get(px) + 1);
            this.parent.set(py, px);
        }

    }

    public int internalFind(int idx){
        if(idx != this.parent.get(idx)){
            this.parent.set(idx, internalFind(this.parent.get(idx)));
        }
        return this.parent.get(idx);
    }

    public int find(int x){
        int idx = this.map.get(x);

        return internalFind(idx);
    }
}
