import java.util.*;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for (String str : strs) {
            String code = encode(str);
            if (!map.containsKey(code))
                map.put(code, new ArrayList<String>());
            map.get(code).add(str);
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                result.addAll(map.get(key));
        }
        return result;
    }

    public String encode(String string) {
        int N = string.length();
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for (int i = 0; i < N; i++) {
            char c = string.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        String result = "";
        for (Character c : map.keySet())
            result += c + "" + map.get(c);
        return result;
    }
}