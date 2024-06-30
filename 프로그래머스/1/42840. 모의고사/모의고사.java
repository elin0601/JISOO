import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        // 수포자들의 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞힌 정답 수를 저장할 배열
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                score[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                score[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                score[2]++;
            }
        }

        // 가장 높은 점수 찾기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        // 가장 높은 점수를 받은 사람을 저장할 리스트
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                result.add(i + 1);
            }
        }

        // 리스트를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
