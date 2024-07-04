class Solution {
    public long solution(int n) {
        // 피보나치 수열의 결과를 저장할 배열 선언
        int[] dp = new int[n + 1];
        
        // 초기 값 설정
        dp[0] = 1; // 0칸에 도달하는 방법은 1가지 (아무것도 안 하는 경우)
        dp[1] = 1; // 1칸에 도달하는 방법은 1가지
        
        // 피보나치 수열로 방법의 수 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}
