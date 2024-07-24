import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridgeQueue = new LinkedList<>();
        
        int time = 0; // 경과 시간
        int totalWeightOnBridge = 0; // 다리 위 트럭들의 총 무게
        int currentTruckIndex = 0; // 대기 트럭 배열에서 현재 트럭 인덱스

        // 다리 길이만큼 0을 채워서 초기화 (다리에 트럭이 없는 상태)
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        while (!bridgeQueue.isEmpty()) {
            
            time++; // 시간 증가
            
            // 다리에서 트럭 하나가 빠져나옴
            totalWeightOnBridge -= bridgeQueue.poll();

            if (currentTruckIndex < truck_weights.length) {
                
                // 다음 트럭이 다리에 올라갈 수 있는지 확인
                if (totalWeightOnBridge + truck_weights[currentTruckIndex] <= weight) {
                    
                    // 트럭이 다리에 올라감
                    bridgeQueue.offer(truck_weights[currentTruckIndex]);
                    totalWeightOnBridge += truck_weights[currentTruckIndex];
                    currentTruckIndex++;
                    
                } else {
                    
                    // 트럭이 올라갈 수 없으면 0을 추가 (트럭 없음)
                    bridgeQueue.offer(0);
                }
            }
        }

        return time;
    }
}