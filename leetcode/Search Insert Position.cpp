class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return 0;
        for (int i = 0; i < n; i++) {
            if (target > A[i]) {  // move on
                if (i == n-1) return n;
            }
            else 
                return i;
        }
    }
};
