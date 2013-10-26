public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
        	return 0;

        int buffer = 1;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1])
        		continue;
        	A[buffer++] = A[i];
        }
        return buffer;
    }
}