import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        // int 배열을 String 배열로 변환
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        // 문자열 배열을 정렬하는데, x+y가 y+x보다 큰지 비교하는 커스터마이즈된 Comparator 사용
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);  // 내림차순으로 정렬
            }
        });

        // 배열을 문자열로 합칩니다.
        StringBuilder sb = new StringBuilder();
        for (String num : strNumbers) {
            sb.append(num);
        }

        // "0"으로만 이루어진 경우를 처리
        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }
}
