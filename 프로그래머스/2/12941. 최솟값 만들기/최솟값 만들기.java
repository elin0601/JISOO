import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        // 배열 A와 B의 길이는 동일하다고 가정
        int n = A.length;
        
        // A 배열을 정렬 (오름차순)
        Arrays.sort(A);
        
        // B 배열을 정렬 (오름차순)
        Arrays.sort(B);
        
        // 최종 결과를 저장할 변수
        int minSum = 0;
        
        // A에서 가장 작은 수와 B에서 가장 큰 수를 차례대로 곱하여 더함
        for (int i = 0; i < n; i++) {
            minSum += A[i] * B[n - 1 - i];
        }
        
        return minSum;
    }
}
