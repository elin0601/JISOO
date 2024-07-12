class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        
        // 첫 번째 행 초기화
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        // DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                
                // 이전 행에서 같은 열을 제외한 최대값 찾기
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        maxPrev = Math.max(maxPrev, dp[i - 1][k]);
                    }
                }
                dp[i][j] = land[i][j] + maxPrev;
            }
        }
        
        // 마지막 행에서 최대값 찾기
        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        return answer;
    }
}