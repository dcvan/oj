public class Solution {
    // DP:
    public ArrayList<ArrayList<Integer>> combinationSum_DP(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<ArrayList<Integer>>();

        int T = target;
        int M = candidates.length;
        ArrayList<ArrayList<Integer>>[][] f = new ArrayList[T + 1][M + 1];
        for (int i = 0; i <= T; i++) {
            for (int j = 0; j <= M; j++) {
                f[i][j] = new ArrayList<ArrayList<Integer>>();
            }
        }
        f[0][0].add(new ArrayList<Integer>());

        Arrays.sort(candidates);
        for (int m = 1; m <= M; m++) {
            for (int t = 0; t <= T; t++) {
                if (f[t][m - 1].size() == 0)
                    continue;
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                for (int k = 0; k <= (T - t) / candidates[m - 1]; k++) {
                    if (k >= 1)
                        tempList.add(candidates[m - 1]);
                    int sum = candidates[m - 1] * k + t;

                    for (ArrayList<Integer> list : f[t][m - 1]) {
                        ArrayList<Integer> newList = new ArrayList<Integer>();
                        newList.addAll(list);
                        newList.addAll(tempList);
                        f[sum][m].add(newList);
                    }
                }
            }
        }
        return f[T][M];
    }

    // recurse:
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        return recurse(candidates, target, 0);
    }

    public ArrayList<ArrayList<Integer>> recurse(int[] num, int target, int index){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (target == 0){
            list.add(new ArrayList<Integer>());
            return list;
        }
        int N = num.length;
        if (index >= N)
            return list;

        ArrayList<Integer> bufferList = new ArrayList<Integer>();
        for (int i = 0; i <= target / num[N - 1 - index]; i++) {
            if (i > 0)
                bufferList.add(num[N - 1 - index]);
            ArrayList<ArrayList<Integer>> subList = recurse(num, target - i * num[N - 1 - index], index + 1);
            for (ArrayList<Integer> l:subList) {
               l.addAll(bufferList);
               list.add(l);
            }
        }
        return list;
    }
}