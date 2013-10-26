public class Solution {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        map.put(0, 1);
        map.put(1, 1);
        if (map.containsKey(n))
        	return map.get(n);
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return map.get(n);
    }
}