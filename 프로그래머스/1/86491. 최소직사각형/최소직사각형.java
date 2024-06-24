class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            
            int maxSide = Math.max(w,h);
            int minSide = Math.min(w,h);
            
            maxWidth = Math.max(maxWidth, maxSide);
            maxHeight = Math.max(maxHeight, minSide);
        }
        answer = maxWidth * maxHeight;
        return answer;
    }
}