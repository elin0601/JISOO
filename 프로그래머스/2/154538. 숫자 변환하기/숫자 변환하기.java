import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        boolean[] visited = new boolean[y + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0}); // {현재 값, 연산 횟수}
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int operations = current[1];

            int[] nextValues = new int[]{value + n, value * 2, value * 3};

            for (int nextValue : nextValues) {
                if (nextValue == y) {
                    return operations + 1;
                }
                if (nextValue < y && !visited[nextValue]) {
                    queue.add(new int[]{nextValue, operations + 1});
                    visited[nextValue] = true;
                }
            }
        }

        return -1; // 변환할 수 없는 경우
    
    }
}