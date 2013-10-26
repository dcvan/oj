public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : num)
            set.add(n);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num.length <= 2)
            return list;

        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            for (int j = i + 1; j < num.length - 1; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;

                if (-(num[j] + num[i]) >= num[j + 1] && set.contains(- num[i] - num[j])) {
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    newList.add(num[i]);
                    newList.add(num[j]);
                    newList.add(-num[i] - num[j]);
                    list.add(newList);
                }
            }
        }
        return list;
    }
}