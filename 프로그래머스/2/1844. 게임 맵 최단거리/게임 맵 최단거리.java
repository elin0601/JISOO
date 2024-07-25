import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        // 방문 여부 체크
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        // 최단 거리 기록
        int[][] dist = new int[n][m];
        dist[0][0] = 1; // 시작점은 1로 설정

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 범위를 벗어나지 않으며, 벽이 아니고, 방문하지 않은 곳
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }

        // 상대 팀 진영에 도착할 수 있는지 확인
        if (visited[n-1][m-1]) {
            return dist[n-1][m-1];
        } else {
            return -1;
        }
    }
}
