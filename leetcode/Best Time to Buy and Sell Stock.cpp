class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<int> mins;
        vector<int> maxs;
        if (prices.empty()) return 0;
        
        int min = prices.front();
        int max = prices.back();
        int len = prices.size();
        mins.push_back(min);
        maxs.push_back(max);
        for (int i = 1; i < len; i++) {
            if (prices[i] < min)
                min = prices[i];
            mins.push_back(min);
            if (prices[len-i-1] > max)
                max = prices[len-i-1];
            maxs.push_back(max);
        }
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            if (res < maxs[len-i-2] - mins[i])
                res = maxs[len-i-2] - mins[i];
        }

        return res;
    }
};
