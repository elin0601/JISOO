import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 1. 문자열을 파싱하여 각 집합을 추출
        List<Set<Integer>> sets = new ArrayList<>();
        
        String[] parts = s.substring(2, s.length() - 2).split("\\},\\{");

        for (String part : parts) {
            
            String[] numbers = part.split(",");
            
            Set<Integer> set = new HashSet<>();
            
            for (String number : numbers) {
                
                set.add(Integer.parseInt(number));
            }
            
            sets.add(set);
        }

        // 2. 각 집합을 길이 순으로 정렬
        sets.sort(Comparator.comparingInt(Set::size));

        // 3. 정렬된 집합을 통해 튜플의 순서 복원
        List<Integer> result = new ArrayList<>();
        
        Set<Integer> seen = new HashSet<>();
        
        for (Set<Integer> set : sets) {
            
            for (Integer num : set) {
                
                if (!seen.contains(num)) {
                    
                    result.add(num);
                    seen.add(num);
                    break;
                }
            }
        }

        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}