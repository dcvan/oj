public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++)
            map.put(numbers[i], i);
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ans[0] = i + 1;
                ans[1] = map.get(target - numbers[i]) + 1;
                return ans;
            }
        }
        return ans;
    }
}