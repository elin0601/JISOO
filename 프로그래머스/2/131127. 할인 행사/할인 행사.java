import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int requiredDays = 10;
        int totalDays = discount.length;
        int count = 0;
        
        for (int i = 0; i <= totalDays - requiredDays; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < requiredDays; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }
            
            boolean isValid = true;
            for (String key : wantMap.keySet()) {
                if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                count++;
            }
        }
        
        return count;
    }

}