public class Solution {
    public int solution(int n) {
        // 주어진 숫자의 이진수 표현에서 1의 개수를 계산
        int numberOfOnes = Integer.bitCount(n);

        // 다음 숫자를 찾기 위한 변수 초기화
        int nextNumber = n + 1;

        // 다음 큰 숫자를 찾을 때까지 반복
        while (true) {
            // 다음 숫자의 이진수 표현에서 1의 개수를 계산
            int nextNumberOfOnes = Integer.bitCount(nextNumber);
            
            // 1의 개수가 동일한지 확인
            if (nextNumberOfOnes == numberOfOnes) {
                // 동일하다면 다음 큰 숫자를 찾았으므로 반환
                return nextNumber;
            }
            
            // 다음 숫자로 증가
            nextNumber++;
        }
    }
}
