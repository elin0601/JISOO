import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 옷의 종류별로 몇 개의 옷이 있는지 세기 위한 HashMap 생성
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 주어진 clothes 배열을 순회하면서 옷의 종류별로 개수를 셈
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        int combinations = 1;
        
        // 각 옷 종류별로 (입지 않는 경우 + 입는 경우) 경우의 수를 계산
        for (int count : clothesMap.values()) {
            combinations *= (count + 1);
        }
        
        // 최소 한 개의 의상은 입어야 하므로 아무것도 입지 않는 경우를 뺌
        return combinations - 1;
    }
}
