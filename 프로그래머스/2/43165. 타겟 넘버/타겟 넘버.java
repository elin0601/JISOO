class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        // 현재 index의 숫자를 더하거나 빼는 두 가지 경우를 재귀적으로 탐색
        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int subtract = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        // 두 가지 경우의 수를 합산하여 반환
        return add + subtract;
    }
}
