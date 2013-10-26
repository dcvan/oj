public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0)
            return list;

        Arrays.sort(S);
        int L = S.length;
        int N = 1 << S.length;

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            int temp = i;
            for (int k = 0; k < L; k++) {
                if (temp % 2 == 1)
                    newList.add(S[k]);
                temp >> 1;
            }
            list.add(newList);
        }
        return list;
    }
}