import java.util.HashSet;
import java.util.Set;

class Solution {

        // 소수 판별 함수
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 가능한 모든 숫자 조합을 생성하는 함수
    public void generatePermutations(String prefix, String str, Set<Integer> numbers) {
        int n = str.length();
        if (!prefix.isEmpty()) {
            numbers.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            generatePermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), numbers);
        }
    }

    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        // 가능한 모든 숫자의 조합을 생성
        generatePermutations("", numbers, uniqueNumbers);
        
        // 소수의 개수를 센다
        int primeCount = 0;
        for (int num : uniqueNumbers) {
            if (isPrime(num)) {
                primeCount++;
            }
        }
        
        return primeCount;
    }
}