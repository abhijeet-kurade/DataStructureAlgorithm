package ArrayHashMaps.Arrays.AlgoExpert;

public class MinRewards {

    public int minRewards(int[] scores) {
        int len = scores.length;
        int[] rewards = new int[len];

        for(int i=0; i<len; i++) rewards[i] = 1;

        for(int i=1; i<len; i++)
            if(scores[i-1] < scores [i])
                rewards[i] =  rewards[i-1] + 1;

        for(int i=len-2; i>=0; i--){
            if(scores[i] > scores [i+1]){
                int new_reward = rewards[i+1] + 1;
                rewards[i] = Math.max(rewards[i], new_reward);
            }
        }

        int total_reward = 0;
        for(int reward : rewards)
            total_reward += reward;

        return total_reward;
    }
}
