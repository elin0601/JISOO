import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
       PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.add(s);
        }

        int mixCount = 0;

        while (heap.size() > 1 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            int newScoville = first + (second * 2);
            heap.add(newScoville);
            mixCount++;
        }

        return heap.peek() >= K ? mixCount : -1;
    }
}