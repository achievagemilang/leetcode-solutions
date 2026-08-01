class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        return f(0, n - 1, nums) >= 0;
    }

    public int f(int left, int right, int[] nums){
        if (left > right){
            return 0;
        }

        int chooseLeft = nums[left] - f(left + 1, right, nums);
        int chooseRight = nums[right] - f(left, right - 1, nums);

        return Math.max(chooseLeft, chooseRight);
    }
}
