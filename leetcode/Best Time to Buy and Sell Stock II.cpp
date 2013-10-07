class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.size() == 0) return 0;
        
        int buy = prices[0];  // price to buy in
        int earn = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > buy)
                earn += prices[i] - buy;
            buy = prices[i];
        }
        return earn;
    }
};
