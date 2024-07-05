import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 전화번호부 정렬
        Arrays.sort(phone_book);
        
        // 인접한 번호들만 비교하여 접두어인지 확인
        for(int i = 0; i< phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        return answer;
    }
}