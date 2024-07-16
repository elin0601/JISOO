import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙을 생성합니다.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 작업량들을 최대 힙에 추가합니다.
        for (int work : works) {
            maxHeap.add(work);
        }
        
        // N 시간 동안 작업을 줄입니다.
        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty()) {
                int largestWork = maxHeap.poll();
                if (largestWork > 0) {
                    maxHeap.add(largestWork - 1);
                }
            }
        }
        
        // 남은 작업량의 제곱합을 계산합니다.
        long fatigue = 0;
        while (!maxHeap.isEmpty()) {
            int remainingWork = maxHeap.poll();
            fatigue += (long) remainingWork * remainingWork;
        }
        
        return fatigue;
    }
}