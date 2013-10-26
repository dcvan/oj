public class Solution {
    public int searchInsert(int[] A, int target) {
        int N = A.length;
        if (N == 0)
        	return 0;
        if (A[0] > target)
        	return 0;
        if (A[N-1] < target)
        	return N;

        int left = 0;
        int right = N-1;
        while (left < right){
        	int mid = (left + right) / 2;
        	if (A[mid] == target)
        		return mid;
        	else if (A[mid] > target)
        		right = mid - 1;
        	else
        		left = mid + 1;
        }
        if (A[left] >= target)
        	return left;
        return left + 1;
    }
}