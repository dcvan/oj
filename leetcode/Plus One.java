public class Solution {
    public int[] plusOne(int[] digits) {
        int buffer = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = digits.length - 1; i >= 0; i--) {
            list.add((digits[i] + buffer) % 10);
            buffer = (digits[i] + buffer) / 10;
        }
        if (buffer > 0)
            list.add(buffer);

        int num[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(list.size() - i - 1);
        }
        return num;
    }
}