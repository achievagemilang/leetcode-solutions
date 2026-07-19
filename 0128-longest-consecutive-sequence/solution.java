class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }

        for(int n: set){
            if(!set.contains(n-1)){
                int len = 0;
                while(set.contains(n)){
                    len++;
                    n += 1;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}

