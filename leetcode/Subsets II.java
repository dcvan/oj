public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return list;

        int L = num.length;
        int N = 1 << L;
        Arrays.sort(num);
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            int temp = i;
            String newStr = "";

            for (int k = 0; k < L; k++) {
                if (temp % 2 == 1) {
                    newList.add(num[k]);
                    newStr = newStr + "_" + num[k];
                }
                temp = temp >> 1;
            }
            if (!set.contains(newStr))
                list.add(newList);
            set.add(newStr);
        }
        return list;
    }
}