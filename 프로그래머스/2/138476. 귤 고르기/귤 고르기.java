import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 귤의 크기별로 개수를 세기 위한 맵 생성
        Map<Integer, Integer> map = new HashMap<>(); 
        
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        // 크기별 개수를 리스트에 담기
        List<Integer> sizeList = new ArrayList<>(map.values());
 
        sizeList.sort(Collections.reverseOrder());
        
        int sum = 0;
        int varietyCount = 0;
        
        for(int s : sizeList){
            sum += s;
            varietyCount++;
            if(sum >= k){
                break;
            }
        }
        
        return varietyCount;
    }
}