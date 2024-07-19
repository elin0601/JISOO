class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int removedZerosCount = 0;

        while (!s.equals("1")) {
            int originalLength = s.length();
            s = s.replace("0", "");  // 모든 0을 제거
            int newLength = s.length();
            removedZerosCount += (originalLength - newLength);  // 제거된 0의 개수 누적

            s = Integer.toBinaryString(newLength);  // 길이를 이진법으로 변환
            transformCount++;
        }

        return new int[]{transformCount, removedZerosCount};
    }
}
