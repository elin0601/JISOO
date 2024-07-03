class Solution {
    public int solution(int[][] triangle) {
      int height = triangle.length;
        
        // triangle 배열을 밑에서부터 갱신
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 아래 층의 두 값 중 더 큰 값을 선택해서 현재 값을 갱신
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        
        // 꼭대기의 값이 최대 경로 합
        return triangle[0][0];
    }
}