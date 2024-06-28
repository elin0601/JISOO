import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> arrayList = new ArrayList<>();
        
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] subArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(subArray);
            
            int tEl = subArray[k-1];
            arrayList.add(tEl);
        }
        
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}