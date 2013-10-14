class Solution {
public:
    int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       int *ways = new int[n+1 > 3 ? n+1 : 3];
       ways[0] = 0;
       ways[1] = 1;
       ways[2] = 2;
       for (int i = 3; i <= n; i++)
           ways[i] = ways[i-1] + ways[i-2];
       return ways[n];
    }
};
