import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int left = 0; // 가장 가벼운 사람
        int right = people.length -1; // 가장 무거운 사람
        int answer = 0; // 보트 수
        
        while(left<=right){
            
            // 가장 가벼운 사람 + 가장 무거운 사람의 합이 limit 보다 이하인 경우 
            // 같은 보트를 탈 수 있음
            if(people[left] + people[right] <= limit){
                left++;
            }
            
            // 무조건 무거운 사람은 태우고 right를 감소 시킴
            right--;
            
            // 보트의 수 증가
            answer++;
        }

        return answer;
    }
}