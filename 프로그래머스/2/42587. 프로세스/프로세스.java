import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Process> queue = new LinkedList<>();
        // 큐에 모든 프로세스를 인덱스와 함께 추가
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }
        
        int executionOrder = 0;
        
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean hasHigherPriority = false;
            
            // 큐에 남아있는 프로세스 중 더 높은 우선순위가 있는지 확인
            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                // 더 높은 우선순위가 있으면 다시 큐에 넣음
                queue.add(current);
            } else {
                // 그렇지 않으면 실행하고 실행 순서 증가
                executionOrder++;
                if (current.index == location) {
                    return executionOrder;
                }
            }
        }
        
        return -1;
        
    }
    // 프로세스를 나타내는 클래스
    class Process {
        int priority;
        int index;
        
        Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}