import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        
        int[] result = new int[n];
        
        List<Integer> numbers = new ArrayList<>();
        
        long[] factorial = new long[n+1]; 

        // 팩토리얼 값을 미리 계산하여 저장
        factorial[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            
            factorial[i] = factorial[i-1] * i;
        }

        // 숫자 리스트를 초기화
        for (int i = 1; i <= n; i++) {
            
            numbers.add(i);
        }

        // k는 0-indexed로 변환
        k--;

        for (int i = 0; i < n; i++) {
            
            int index = (int)(k / factorial[n-1-i]);  // index 계산시 long 타입을 int로 변환
            result[i] = numbers.get(index);
            
            numbers.remove(index);
            
            k -= index * factorial[n-1-i];
        }

        return result;
    }
}