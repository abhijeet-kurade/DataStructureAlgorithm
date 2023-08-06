package ArrayHashMaps.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnapshotArray {
    List<int[]> snaps;
    public SnapshotArray(int length) {
        int[] arr = new int[length];
        Arrays.fill(arr, 0);
        snaps = new ArrayList<>();
        snaps.add(arr);
    }
    public void set(int index, int val) {
        int[] lastSnap = snaps.get(snaps.size()-1);
        lastSnap[index] = val;
    }
    public int snap() {
        int[] lastSnap = snaps.get(snaps.size()-1);
        int id = snaps.size()-1;
        int[] newSnap = new int[lastSnap.length];
        for(int i=0; i<lastSnap.length; i++){
            newSnap[i] = lastSnap[i];
        }
        snaps.add(newSnap);
        return id;
    }
    public int get(int index, int snap_id) {
        return snaps.get(snap_id)[index];
    }
}
