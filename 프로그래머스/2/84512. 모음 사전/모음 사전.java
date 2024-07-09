class Solution {
    public int solution(String word) {
         // 각 자리의 가중치 배열
        int[] weight = {781, 156, 31, 6, 1}; // (5^4 + 5^3 + 5^2 + 5^1 + 5^0)
        char[] letters = {'A', 'E', 'I', 'O', 'U'};
        
        int result = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 현재 문자가 letters 배열에서 몇 번째 문자인지 찾음
            int index = 0;
            for (int j = 0; j < letters.length; j++) {
                if (letters[j] == c) {
                    index = j;
                    break;
                }
            }
            // 가중치 계산
            result += index * weight[i] + 1;
        }
        
        return result;
    }
}