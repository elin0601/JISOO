import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
               
        Set<Integer> temp = new HashSet<>();
        for(int num : nums){
            temp.add(num);
        }
        
        answer = Math.min(temp.size(), nums.length/2);
        return answer;
    }
}