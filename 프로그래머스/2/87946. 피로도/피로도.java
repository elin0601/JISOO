import java.util.*;

class Solution {
    private int maxDungeonCount = 0;

    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        exploreDungeons(k, dungeons, visited, 0);
        
        return maxDungeonCount;
    }

    private void exploreDungeons(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
        
        // 현재까지 탐험한 던전 수가 최대 탐험한 던전 수보다 많으면 갱신
        if (count > maxDungeonCount) {
            
            maxDungeonCount = count;
        }

        // 모든 던전에 대해 시도
        for (int i = 0; i < dungeons.length; i++) {
            
            // 방문하지 않았고 현재 피로도가 최소 필요 피로도 이상일 때
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true; // 던전 방문
                
                // 다음 던전을 탐험 (현재 피로도 - 소모 피로도, 탐험한 던전 수 증가)
                exploreDungeons(currentFatigue - dungeons[i][1], dungeons, visited, count + 1);
                
                visited[i] = false; // 던전 방문 해제 (백트래킹)
            }
        }
    }
}
