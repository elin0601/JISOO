import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> participantMap = new HashMap<>(); 
        
        // 참가자 명단을 해시맵에 추가
        for(String player : participant){
            participantMap.put(player, participantMap.getOrDefault(player, 0) + 1);
            
        }
        
        // 완주자 명단을 해시맵에서 차감
        for (String player : completion) {
            participantMap.put(player, participantMap.get(player) - 1);
        }
        
        // 해시맵에서 값이 1인 (완주하지 못한) 선수 찾기
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) != 0) {
                return key;
            }
        }
        
        return null;
    }
}