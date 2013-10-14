class Solution {
public:
    int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        bool neg = x < 0 ? true : false;
        x = neg ? -x : x;
        int digits[30];
        int base = 10, i = 0;
        while (x) {
            digits[i++] = x % base;
            x /= base;
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            res += digits[j];
            if (j != i-1)
                res *= base;
        }
        return neg ? -res : res;
    }
};
