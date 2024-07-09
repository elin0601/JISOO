class Solution {
    // 숫자를 주어진 진법으로 변환하는 함수
    public String convertToBase(int num, int base) {
        String digits = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        if (num == 0) return "0";

        while (num > 0) {
            result.insert(0, digits.charAt(num % base));
            num /= base;
        }

        return result.toString();
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder totalNumbers = new StringBuilder();

        int number = 0;

        // 충분한 길이의 문자열을 생성
        while (totalNumbers.length() < t * m) {
            totalNumbers.append(convertToBase(number++, n));
        }

        // 튜브가 말해야 하는 숫자를 추출
        for (int i = 0; i < t; i++) {
            answer.append(totalNumbers.charAt(p - 1 + i * m));
        }

        return answer.toString();
    }
}