import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
          Stack<Character> stack = new Stack<>();
        int len = number.length();
        
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // 만약 k가 아직 남아있다면, 스택의 뒤에서부터 제거
        while (k-- > 0) {
            stack.pop();
        }
        
        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}