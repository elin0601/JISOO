import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        // 만약 s가 n보다 작으면 자연수 집합으로 n개의 원소를 만들 수 없음
        if (s < n) {
            return new int[] {-1};
        }
        
        int[] answer = new int[n];
        int baseValue = s / n;  // 모든 원소에 들어갈 기본 값
        int remainder = s % n;  // 나머지
        
        // 모든 원소를 baseValue로 초기화
        Arrays.fill(answer, baseValue);
        
        // 나머지만큼의 원소에 1을 더해줌
        for (int i = 0; i < remainder; i++) {
            answer[i]++;
        }
        
        // 결과 배열을 오름차순으로 정렬하여 반환
        Arrays.sort(answer);
        
        return answer;
    }
}
