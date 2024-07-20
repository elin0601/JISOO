class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 각 노드의 방문 여부를 저장하는 배열
        int networkCount = 0; // 네트워크 개수를 저장하는 변수

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                networkCount++;
            }
        }
        
        return networkCount;
    }

    private void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}
