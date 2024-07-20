import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최솟값을 추적하는 우선순위 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값을 추적하는 우선순위 큐
        int size = 0; // 현재 큐의 크기

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number);
                size++;
            } else if (command.equals("D")) {
                if (size == 0) continue;

                if (number == 1) {
                    maxHeap.poll();
                } else if (number == -1) {
                    minHeap.poll();
                }
                size--;
                
                if (size == 0) {
                    minHeap.clear();
                    maxHeap.clear();
                }
            }
        }

        if (size == 0) {
            return new int[]{0, 0};
        } else {
            int max = maxHeap.peek();
            int min = minHeap.peek();
            return new int[]{max, min};
        }
    }
}
