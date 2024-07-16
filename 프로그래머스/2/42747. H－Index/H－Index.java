import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 논문의 인용 횟수를 내림차순으로 정렬합니다.
        Arrays.sort(citations);
        
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // 현재 논문의 인용 횟수가 i보다 크거나 같은지 확인합니다.
            if (citations[i] >= n - i) {
                // 조건을 만족하면 H-Index를 반환합니다.
                return n - i;
            }
        }
        
        // H-Index를 찾지 못했을 경우 0을 반환합니다.
        return 0;
    }

}