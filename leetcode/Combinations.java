public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (n < k)
        	return list;
        if (k == 0){
            list.add(new ArrayList<Integer>());
            return list;
        }
        if (n == k){
        	ArrayList<Integer> newList = new ArrayList<Integer>();
        	for (int i = 1; i <= k; i++)
        		newList.add(i);
        	list.add(newList);
        	return list;
        }
        ArrayList<ArrayList<Integer>> list_1 = combine(n-1, k);
        ArrayList<ArrayList<Integer>> list_2 = combine(n-1, k-1);
        
        for (ArrayList<Integer> subList:list_1) {
        	list.add(subList);
        }
        for (ArrayList<Integer> subList:list_2) {
        	subList.add(n);
        	list.add(subList);
        }
        return list;
    }
}