public class Solution {
    public int reverse(int x) {
		int X = Math.abs(x);
		int ans = 0;
		while (X > 0){
			ans = ans * 10 + X % 10;
			X = X / 10;
		}
		return (x > 0) ? ans : -ans;
    }
}