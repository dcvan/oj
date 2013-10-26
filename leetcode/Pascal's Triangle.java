public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	for (int i = 0; i < numRows; i++) {
    		ArrayList<Integer> innerList = new ArrayList<Integer>();
    		innerList.add(1);
    		for (int j = 1; j < i; j++) {
    			innerList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
    		}
    		if (i > 0)
    			innerList.add(1);
    		list.add(innerList);
    	}
    	return list;
    }
}