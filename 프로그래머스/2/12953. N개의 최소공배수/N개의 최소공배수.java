class Solution {
      // 최대 공약수
        private int gcd(int a, int b){
            while(b!=0){
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        
        // 최대 공배수
        private int lcm(int a, int b){
            int result = a * (b / gcd(a, b));
            return result;
        }
        
    public int solution(int[] arr) {
        
        int answer = arr[0];
        for(int i = 1; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
}