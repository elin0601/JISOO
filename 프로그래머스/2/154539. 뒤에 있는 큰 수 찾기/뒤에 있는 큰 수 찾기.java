import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
       int n = numbers.length;
        int[] answer = new int[n]; // 결과를 담을 배열
        Arrays.fill(answer, -1); // 초기값을 -1로 채운다
        List<Integer> list = new ArrayList<>(); // 인덱스를 저장할 리스트

        for (int i = 0; i < n; i++) {
            // 리스트가 비어있지 않고 현재 숫자가 리스트의 마지막 인덱스가 가리키는 숫자보다 크면
            while (!list.isEmpty() && numbers[list.get(list.size() - 1)] < numbers[i]) {
                int index = list.remove(list.size() - 1);
                answer[index] = numbers[i];
            }
            list.add(i);
        }

        return answer;
    }
}