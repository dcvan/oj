public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
        	return false;

        boolean ans = true;
        String strs[] = s.split("e");
        if (strs.length > 2)
        	return false;
        if (strs.length == 1){
        	ans = isDouble(strs[0]);
        }
        if (strs.length == 2){
        	ans = isDouble(strs[0]);
        	ans = ans && isNumNoZero(strs[1]);
        }
        return ans;
    }

    public boolean isDouble(String str){
		int num = str.length() - str.replaceAll("\\.", "").length();
    	if (num >= 2)
    		return false;
    	if (num == 0)
    		return isNumNoZero(str);
    	else{
    		String strs[] = str.split("\\.");
    		return isNumNoZero(strs[0]) && isNum(strs[1]);
    	}
    }
	
	// num without "." or "e", and the first letter could be "0"
	public boolean isNum(String str){
		return str.matches("[0-9]*");
	}

	// num without "." or "e", and the first letter can not could be "0"
	public boolean isNumNoZero(String str){
		return str.matches("^[1-9]+[0-9]*");
	}
}