class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 경로를 저장할 2차원 배열
        int[][] dp = new int[n][m];
        
        // 물에 잠긴 지역을 -1로 표시
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        // 시작점 초기화
        dp[0][0] = 1;

        // 동적 프로그래밍으로 경로의 수를 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 물에 잠긴 지역은 무시
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 위에서 오는 경우 추가
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                // 왼쪽에서 오는 경우 추가
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                // 큰 수를 방지하기 위해 1,000,000,007로 나눈 나머지를 저장
                dp[i][j] %= 1000000007;
            }
        }

        // 학교에 도착하는 경로의 수를 반환
        return dp[n - 1][m - 1];
    }
}
