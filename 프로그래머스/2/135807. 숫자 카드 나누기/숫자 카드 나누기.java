import java.util.Arrays;

class Solution {
    
    // 최대 공약수를 구하는 함수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }

    // 배열의 모든 원소의 최대 공약수를 구하는 함수
    private int gcdArray(int[] array) {
        
        int result = array[0];
        
        for (int num : array) {
            
            result = gcd(result, num);
            
            if (result == 1) {
                return 1; // 최대 공약수가 1이면 더 이상 계산할 필요가 없음
            }
        }
        
        return result;
    }

    // 배열의 모든 원소가 특정 값으로 나누어 떨어지지 않는지 확인하는 함수
    private boolean notDividesArray(int[] array, int divisor) {
        
        for (int num : array) {
            
            if (num % divisor == 0) {
                
                return false;
            }
        }
        
        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);
        
        int result = 0;

        // 첫 번째 조건: 철수의 카드들의 최대 공약수로 영희의 카드들을 나눌 수 없는지 확인
        if (notDividesArray(arrayB, gcdA)) {
            
            result = gcdA;
        }

        // 두 번째 조건: 영희의 카드들의 최대 공약수로 철수의 카드들을 나눌 수 없는지 확인
        if (notDividesArray(arrayA, gcdB)) {
            
            result = Math.max(result, gcdB);
        }

        return result;
    }

}
