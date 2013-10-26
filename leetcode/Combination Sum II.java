public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();

        int T = target;
        int M = num.length;
        ArrayList<ArrayList<Integer>>[][] f = new ArrayList[T + 1][M + 1];
        for (int i = 0; i <= T; i++) {
            for (int j = 0; j <= M; j++) {
                f[i][j] = new ArrayList<ArrayList<Integer>>();
            }
        }
        f[0][0].add(new ArrayList<Integer>());

        HashSet<String> set = new HashSet<String>();
        Arrays.sort(num);
        for (int m = 1; m <= M; m++) {
            if (num[m - 1] > T)
                return f[T][m - 1];
            for (int t = 0; t <= T; t++) {
                if (f[t][m - 1].size() == 0)
                    continue;
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                for (int k = 0; k <= Math.min(1, (T - t) / num[m - 1]); k++) {
                    if (k >= 1)
                        tempList.add(num[m - 1]);
                    int sum = num[m - 1] * k + t;

                    for (ArrayList<Integer> list : f[t][m - 1]) {
                        ArrayList<Integer> newList = new ArrayList<Integer>();
                        newList.addAll(list);
                        newList.addAll(tempList);
                        String str = newList.toString() + m;
                        if (!set.contains(str)) {
                            f[sum][m].add(newList);
                            set.add(str);
                        }
                    }
                }
            }
        }
        return f[T][M];
    }
}