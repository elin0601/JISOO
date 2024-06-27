import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        // 연속적인 숫자가 있으니까 List 이용
        List<Integer> arrList = new ArrayList<>();
        
        // 항상 첫번째 오는 숫자는 배열에 포함
        if(arr.length>0){
            arrList.add(arr[0]);
        }
        
        // 연속적인 숫자가 아닐 경우에만 List에 추가
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                arrList.add(arr[i]);
            }
        }
        
        int[] answer = new int[arrList.size()];
        
        for(int i = 0; i<arrList.size(); i++){
            answer[i] = arrList.get(i);              
        }        
        return answer;
    }
}