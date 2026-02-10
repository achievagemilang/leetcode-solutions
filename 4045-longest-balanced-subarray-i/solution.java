class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int len = 0;

        // Try all subarrays starting at i
        for (int i = 0; i < n; i++) {
            HashSet<Integer> odd = new HashSet<>();
            HashSet<Integer> even = new HashSet<>();

            for (int j = i; j < n; j++) {
                // classify current element
                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);

                // check balance condition
                if (odd.size() == even.size())
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
}
