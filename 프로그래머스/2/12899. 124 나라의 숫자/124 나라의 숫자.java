class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                n -= 1;
            }

            answer = num[remainder] + answer;
        }

        return answer;
    }
}