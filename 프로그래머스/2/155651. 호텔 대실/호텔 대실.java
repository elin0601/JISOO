import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> events = new ArrayList<>();

        // 시간 변환 및 이벤트 생성
        for (String[] booking : book_time) {
            int start = timeToMinutes(booking[0]);
            int end = timeToMinutes(booking[1]) + 10; // 청소 시간 포함
            events.add(new int[] {start, 1});  // 예약 시작
            events.add(new int[] {end, -1});   // 예약 종료
        }

        // 이벤트 정렬
        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 객실 수 계산
        int currentRooms = 0;
        int maxRooms = 0;
        for (int[] event : events) {
            currentRooms += event[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }

    // HH:MM을 분으로 변환
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

}
