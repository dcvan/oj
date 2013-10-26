public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (rowIndex == 0)
        	return list;
        
        while (rowIndex > 0) {
            rowIndex --;
            int size = list.size();
            for (int i = 1; i < size; i++) {
                list.set(size - i, list.get(size - i) + list.get(size - 1 - i));
            }
            list.add(1);
        }
        return list;
    }
}