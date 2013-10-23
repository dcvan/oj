#include<vector>

class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > res;
        vector<int> first(1, 1);
        vector<int> second(2, 1);
        
        if (numRows == 0) return res;
        res.push_back(first);
        if (numRows == 1) return res;
        res.push_back(second);
        if (numRows == 2) return res;
        
        for (int i = 3; i <= numRows; i++) {
            vector<int> now(i, 1);
            for (int j = 1; j < i-1; j++)
                now[j] = res[i-2][j-1] + res[i-2][j];
            res.push_back(now);
        }
        
        return res;
    }
};
