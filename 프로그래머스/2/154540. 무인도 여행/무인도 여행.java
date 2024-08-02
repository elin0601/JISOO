import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        
        int rows = maps.length;
        
        int cols = maps[0].length();
        
        boolean[][] visited = new boolean[rows][cols];
        
        List<Integer> islandDays = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < cols; j++) {
                
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    
                    int days = bfs(maps, visited, i, j);
                    islandDays.add(days);
                }
            }
        }

        if (islandDays.isEmpty()) {
            
            return new int[] { -1 };
        }

        Collections.sort(islandDays);
        
        return islandDays.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(String[] maps, boolean[][] visited, int startX, int startY) {
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int rows = maps.length;
        int cols = maps[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {startX, startY});
        
        visited[startX][startY] = true;
        
        int totalDays = 0;

        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            
            totalDays += maps[x].charAt(y) - '0';

            for (int i = 0; i < 4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    
                    queue.offer(new int[] {nx, ny});
                    
                    visited[nx][ny] = true;
                }
            }
        }

        return totalDays;
    }
}