import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> usedWords = new HashSet<>();
        
        char lastChar = words[0].charAt(0);  // 첫 단어의 첫 글자
        int turn = 1;

        for (int i = 0; i < words.length; i++) {
            
            String word = words[i];

            // 현재 단어가 규칙에 맞지 않는 경우
            if (usedWords.contains(word) || word.charAt(0) != lastChar || word.length() == 1) {
                
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            // 단어를 사용했다고 기록
            usedWords.add(word);
            
            // 마지막 글자를 업데이트
            lastChar = word.charAt(word.length() - 1);
            turn++;
        }

        // 탈락자가 없을 경우
        return new int[]{0, 0};
    }
}