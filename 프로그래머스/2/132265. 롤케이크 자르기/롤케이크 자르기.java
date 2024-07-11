import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
         int n = topping.length;
        
        // 왼쪽과 오른쪽에 존재하는 토핑 종류를 추적하기 위한 집합
        HashSet<Integer> leftSet = new HashSet<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        
        // 오른쪽 맵을 초기화
        for (int i = 0; i < n; i++) {
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }

        int ways = 0;

        // 왼쪽에서 오른쪽으로 순회하면서 각 위치에서 왼쪽 집합의 크기를 저장
        for (int i = 0; i < n - 1; i++) {
            leftSet.add(topping[i]);
            
            // 오른쪽 맵에서 현재 토핑을 하나 제거
            rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            if (rightMap.get(topping[i]) == 0) {
                rightMap.remove(topping[i]);
            }

            // 왼쪽 집합과 오른쪽 맵의 크기가 같으면 공평하게 나눌 수 있는 방법 증가
            if (leftSet.size() == rightMap.size()) {
                ways++;
            }
        }

        return ways;
    }
}