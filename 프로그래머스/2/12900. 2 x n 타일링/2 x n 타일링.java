class Solution {
    public int solution(int n) {
        int MOD = 1_000_000_007;

        // dp 배열 초기화
        int[] dp = new int[n + 1];

        // 초기 조건 설정
        dp[0] = 1;
        dp[1] = 1;

        // 동적 프로그래밍을 이용한 문제 해결
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // 결과 반환
        return dp[n];
    }
}
