public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> checked = new HashSet<Integer>();
        for (int i : num)
            set.add(i);

        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            int val = num[i];
            if (checked.contains(val))
                continue;
            // right:
            int maxVal = val;
            while (set.contains(maxVal + 1)) {
                checked.add(maxVal + 1);
                maxVal++;
            }
            // left:
            int minVal = val;
            while (set.contains(minVal - 1)) {
                checked.add(minVal - 1);
                minVal--;
            }
            maxLen = Math.max(maxLen, maxVal - minVal + 1);
        }
        return maxLen;
    }
}