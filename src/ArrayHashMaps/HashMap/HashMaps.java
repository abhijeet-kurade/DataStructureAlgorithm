package ArrayHashMaps.HashMap;

import java.util.*;

public class HashMaps {
    class Entity{
        int x, y;

        public Entity(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entity entity = (Entity) o;
            return true; //x == entity.x && y == entity.y;
        }

        @Override
        public int hashCode() {
            return x%2;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashMaps hm= new HashMaps();
        hm.starts();
    }

    public void starts(){
        Map<Entity, Integer> map = new HashMap<>();
        map.put(new Entity(2, 3), 2);
        map.put(new Entity(21, 3), 3);
        map.put(new Entity(2334, 3), 4);
        System.out.println(map);

        LinkedList<Integer> djh;

    }


}
