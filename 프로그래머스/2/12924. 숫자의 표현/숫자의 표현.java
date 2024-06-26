import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n) {
        
        // 경우의 수 저장
        int counts = 0;
       
        for(int i = 1; i<=n; i++){ 

            int sum = 0;
            
            // sum이 n이 될 때 경우의 수(counts) 증가 
            for(int j = i; sum<n; j++){
                sum += j;
                if(sum == n){
                    counts++;
                    break;
                }
            }
        }  
               
        return counts;
    }
}