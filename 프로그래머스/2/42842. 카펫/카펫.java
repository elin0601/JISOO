class Solution {
    public int[] solution(int brown, int yellow) {
       int totalGrids = brown + yellow;

        for (int height = 3; height <= totalGrids / 3; height++) {
            if (totalGrids % height == 0) {
                int width = totalGrids / height;
                
                if ((width + height - 2) * 2 == brown) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[0]; // 실패하는 경우는 없으므로 사실 이 줄은 필요하지 않음
    }

}