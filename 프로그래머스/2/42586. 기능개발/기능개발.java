import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      List<Integer> result = new ArrayList<>();
        
        // 작업의 개수
        int n = progresses.length;
        
        // 각 작업의 완료까지 남은 일수를 계산하여 리스트에 저장
        List<Integer> daysList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int remainingWork = 100 - progresses[i];
            int days = (int) Math.ceil((double) remainingWork / speeds[i]);
            daysList.add(days);
        }
        
        while (!daysList.isEmpty()) {
            // 현재 작업의 완료 일수 기준
            int currentDay = daysList.get(0);
            int count = 0;
            
            // 리스트에서 현재 작업 기준으로 완료되는 모든 작업을 제거
            while (!daysList.isEmpty() && daysList.get(0) <= currentDay) {
                daysList.remove(0);
                count++;
            }
            
            result.add(count);
        }
        
        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}