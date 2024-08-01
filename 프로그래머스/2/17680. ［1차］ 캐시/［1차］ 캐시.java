import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // 캐시 크기가 0인 경우 모든 요청이 cache miss가 되므로 총 실행시간은 cities 길이에 5를 곱한 것과 같다
        if (cacheSize == 0) {
            
            return cities.length * 5;
        }

        // LRU 캐시를 구현하기 위해 LinkedHashMap 사용
        Map<String, Integer> cache = new LinkedHashMap<String, Integer>(cacheSize, 0.75f, true) {
            
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize; // 캐시 크기를 초과하면 가장 오래된 항목을 제거
            }
        };

        int totalTime = 0;

        for (String city : cities) {
            
            city = city.toLowerCase(); // 대소문자를 구분하지 않으므로 소문자로 변환

            if (cache.containsKey(city)) {
                // cache hit
                totalTime += 1;
            } else {
                // cache miss
                totalTime += 5;
            }

            cache.put(city, 0); // 캐시에 도시 추가
        }

        return totalTime;
    }

}