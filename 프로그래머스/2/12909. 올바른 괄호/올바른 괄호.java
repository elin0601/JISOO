import java.util.Stack;
class Solution {
    boolean solution(String s) {
     // 스택을 이용하여 괄호의 짝을 맞추는 방법
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자에 대해 반복
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호일 경우 스택에 추가
            if (c == '(') {
                stack.push(c);
            } else {
                // 닫는 괄호일 경우
                // 스택이 비어있는 경우, 짝이 맞지 않음
                if (stack.isEmpty()) {
                    return false;
                }
                // 스택에서 여는 괄호를 제거
                stack.pop();
            }
        }

        // 스택이 비어있다면 모든 괄호의 짝이 맞는 것
        return stack.isEmpty();
    }
}