import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(begin);
        visited.add(begin);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                for (String word : words) {
                    if (!visited.contains(word) && canConvert(currentWord, word)) {
                        if (word.equals(target)) {
                            return level;
                        }
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

   private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
   }
}