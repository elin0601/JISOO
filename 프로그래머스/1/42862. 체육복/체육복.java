import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 체육복을 잃어버린 학생
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우 처리
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 여벌 체육복을 빌려주기
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if(reserve[j] == -1) continue;
                if(lost[i] == reserve[j] -1 || lost[i] == reserve[j] + 1) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                    
                }
            }
        }
        
        answer = n;
        for (int a : lost){
            if(a != -1){
                answer--;
            }
        }
        
        
        return answer;
    }
}