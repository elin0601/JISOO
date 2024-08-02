import java.util.*;

class Solution {
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        
        int rows = maps.length;
        
        int cols = maps[0].length();
        
        int startX = -1, startY = -1, leverX = -1, leverY = -1, exitX = -1, exitY = -1;

        // 시작점, 레버, 출구의 좌표를 찾는다.
        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < cols; j++) {
                
                char c = maps[i].charAt(j);
                
                if (c == 'S') {
                    
                    startX = i;
                    startY = j;
                    
                } else if (c == 'L') {
                    
                    leverX = i;
                    leverY = j;
                    
                } else if (c == 'E') {
                    
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // 시작점에서 레버까지의 최단 경로를 찾는다.
        int toLever = bfs(maps, startX, startY, leverX, leverY);
        
        if (toLever == -1) return -1;

        // 레버에서 출구까지의 최단 경로를 찾는다.
        int toExit = bfs(maps, leverX, leverY, exitX, exitY);
        
        if (toExit == -1) return -1;

        // 총 경로는 두 경로의 합
        return toLever + toExit;
    }

    private int bfs(String[] maps, int startX, int startY, int targetX, int targetY) {
        
        int rows = maps.length;
        int cols = maps[0].length();
        
        boolean[][] visited = new boolean[rows][cols];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY, 0}); // x, y, 거리
        
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == targetX && y == targetY) {
                
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    
                    visited[nx][ny] = true;
                    
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}