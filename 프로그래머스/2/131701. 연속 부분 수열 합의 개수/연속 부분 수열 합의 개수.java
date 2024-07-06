import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;

        // 누적 합을 계산
        int[] prefixSums = new int[n * 2];
        prefixSums[0] = elements[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + elements[i];
        }
        for (int i = n; i < 2 * n; i++) {
            prefixSums[i] = prefixSums[i - 1] + elements[i % n];
        }

        // 각 부분 수열 합을 저장할 Set
        Set<Integer> answerSet = new HashSet<>();

        // 모든 가능한 부분 수열 계산
        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < startIndex + n; endIndex++) {
                int sum = getSum(prefixSums, startIndex, endIndex);
                answerSet.add(sum);
            }
        }

        // 정답 반환
        return answerSet.size();
    }

    // 특정 구간의 합을 구하는 함수
    private int getSum(int[] prefixSums, int startIndex, int endIndex) {
        if (startIndex == 0) {
            return prefixSums[endIndex];
        }
        return prefixSums[endIndex] - prefixSums[startIndex - 1];
    }
}
