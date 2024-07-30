import java.util.*;

class Solution {
    public int solution(int storey) {
       return calculateMinMagicStones(storey);
    }

     private int calculateMinMagicStones(int storey) {
        int stones = 0;
        while (storey > 0) {
            int remainder = storey % 10;
            storey /= 10;
            
            if (remainder > 5 || (remainder == 5 && (storey % 10) >= 5)) {
                stones += 10 - remainder;
                storey += 1;  // 다음 자리로 올림
            } else {
                stones += remainder;
            }
        }
        return stones;
    }

}