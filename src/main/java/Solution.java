import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] valLab = new int[n][2];

        for(int i = 0; i < n; i++){
            valLab[i][0] = values[i];
            valLab[i][1] = labels[i];
        }
        Arrays.sort(valLab, Comparator.comparingInt(a -> -a[0]));
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < n; i++){

            if(map.getOrDefault(valLab[i][1], 0) < useLimit){
                int c = map.getOrDefault(valLab[i][1], 0);
                c++;
                map.put(valLab[i][1], c);
                res += valLab[i][0];
                numWanted--;
                if(numWanted == 0){
                    break;
                }
            }
        }
        return res;
    }
}
