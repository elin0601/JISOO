import java.util.*;

class Solution {
     // BFS를 사용하여 시작 노드에서 연결된 노드의 수를 계산하는 함수
    private int bfsCountNodes(int start, Map<Integer, List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        int minDifference = n;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 그래프 생성
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // 각 간선을 제거하고 두 서브 트리의 노드 개수를 계산
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 간선 제거
            graph.get(v1).remove((Integer) v2);
            graph.get(v2).remove((Integer) v1);

            boolean[] visited = new boolean[n + 1];
            int nodesInSubtree = bfsCountNodes(v1, graph, visited);
            int difference = Math.abs(n - 2 * nodesInSubtree);
            minDifference = Math.min(minDifference, difference);

            // 간선 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return minDifference;
    }
}