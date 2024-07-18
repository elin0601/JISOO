import java.util.Stack;

class Solution {
    public int solution(int[] order) {
       int n = order.length;
        Stack<Integer> auxiliaryBelt = new Stack<>();
        int currentBox = 1;
        int loadedBoxes = 0;

        for (int target : order) {
            while (currentBox <= n && (auxiliaryBelt.isEmpty() || auxiliaryBelt.peek() != target)) {
                auxiliaryBelt.push(currentBox++);
            }

            if (!auxiliaryBelt.isEmpty() && auxiliaryBelt.peek() == target) {
                auxiliaryBelt.pop();
                loadedBoxes++;
            } else {
                break;
            }
        }

        return loadedBoxes;
    }
}