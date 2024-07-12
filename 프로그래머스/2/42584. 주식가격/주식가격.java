import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;      
        int[] answer = new int[n];      
        Stack<Integer> stack = new Stack<>();
        
        // 주식 가격을 순회하면서 떨어지는 시점을 찾는다.
        for(int i = 0; i < n; i++){
             // 스택에 있는 가격보다 현재 가격이 낮다면, 떨어진 시점을 찾은 것
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
             stack.push(i);
        }
        
        // 스택에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않은 것
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}