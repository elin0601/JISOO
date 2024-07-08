class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int rowsA = arr1.length;
        int colsA = arr1[0].length;
        
        int rowsB = arr2.length;
        int colsB = arr2[0].length;
        
        // 결과 행렬 초기화
        int[][] result = new int[rowsA][colsB];
        
           // 행렬 곱셈 수행
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) { // 또는 rowsB
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}