public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int N = s.length();
        boolean f[] = new boolean[N + 1];
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        // if valid:
        if (!wordBreakValid(s, dict))
        	return new ArrayList<String>();

        // initialize:
        list.add(new ArrayList<String>());
        list.get(0).add("");
        f[0] = true;

        OUT:
        for (int i = 1; i <= N; i++) {
            list.add(new ArrayList<String>());
            for (String str : dict) {
                int len = str.length();
                if (len > i || f[i - len] == false)
                    continue;

                String subStr = s.substring(i - len, i);
                if (subStr.equals(str)) {
                    f[i] = true;
                    for (String string : list.get(i - len)) {
                        list.get(i).add(string + subStr + " ");
                    }
                }
            }
        }
        for (int i = 0; i < list.get(N).size(); i++) {
            String str = list.get(N).get(i);
            list.get(N).set(i, str.substring(0, str.length() - 1));
        }
        return list.get(N);
    }

    public boolean wordBreakValid(String s, Set<String> dict) {
        int N = s.length();
        boolean f[] = new boolean[N + 1];
        f[0] = true;

        OUT:
        for (int i = 1; i <= N; i++) {
            for (String str : dict) {
                int len = str.length();
                if (len > i || f[i - len] == false)
                    continue;

                String subStr = s.substring(i - len, i);
                if (subStr.equals(str)) {
                    f[i] = true;
                    continue OUT;
                }
            }
        }
        return f[N];
    }
}