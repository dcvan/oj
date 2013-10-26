public class Solution {
	String letters[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> list = new ArrayList<String>();
    	if (digits == null)
    		return list;
    	if (digits.length() == 0){
    	    list.add("");
            return list;    	    
    	}
    	
    	ArrayList<String> subList = letterCombinations(digits.substring(1));

    	for (String str:subList) {
    		int index = Integer.parseInt(digits.substring(0, 1));
    		for (int i = 0; i < letters[index].length(); i++) {
    			list.add(letters[index].charAt(i) + str);
    		}
    	}
    	return list;
    }
}