public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        if (n == 0) {
            list.add(0);
            return list;
        }

        int nums[] = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] << 1;
        }

        list.add(0);
        set.add(0);
        for (int i = 1; i < (1 << n); i++) {
            int num = list.get(i - 1);
            for (int j = 0; j < n; j++) {
                int k = num ^ nums[j];
                if (!set.contains(k)) {
                    list.add(k);
                    set.add(k);
                    break;
                }
            }
        }
        return list;
    }
}