package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    public int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int reqs_len = reqs.length;
        int blocks_len = blocks.size();
        int[][] distances = new int[blocks_len][reqs_len];
        for(int i=0; i<blocks_len; i++)
            for(int j=0; j<reqs_len; j++)
                distances[i][j] = blocks.get(i).get(reqs[j]) ? 0 : Integer.MAX_VALUE - 1;

        for(int i=1;i<blocks_len; i++)
            for(int j=0; j<reqs_len; j++)
                distances[i][j] = Math.min(distances[i][j], distances[i-1][j] + 1);

        for(int i =blocks_len -2; i >= 0; i--)
            for(int j=0; j<reqs_len; j++)
                distances[i][j] = Math.min(distances[i][j], distances[i+1][j] + 1);

        int[] max_distance = new int[blocks_len];
        for(int i=0;i<blocks_len; i++) max_distance[i] = Integer.MIN_VALUE;
        for(int i=0;i<blocks_len; i++)
            for(int j=0; j<reqs_len; j++)
                max_distance[i] = Math.max(max_distance[i], distances[i][j]);

        int req_block = 0;
        for(int i=1;i<blocks_len; i++)
            if(max_distance[req_block] > max_distance[i])
                req_block = i;
        return req_block;
    }

}
