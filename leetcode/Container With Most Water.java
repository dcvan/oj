public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int x = 0;
        int y = height.length - 1;
        int maxVal = y * Math.min(height[x], height[y]);

        while (y > x) {
            if (height[x] < height[y]) {
                x++;
                int val = (y - x) * Math.min(height[x], height[y]);
                maxVal = Math.max(maxVal, val);
            } else {
                y--;
                int val = (y - x) * Math.min(height[x], height[y]);
                maxVal = Math.max(maxVal, val);
            }
        }
        return maxVal;
    }
}