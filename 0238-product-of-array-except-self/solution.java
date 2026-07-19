class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pref = 1;
        int post = 1;
        int[] ans = new int[nums.length];
        ans[0] = pref;
        for(int i=1; i<nums.length; i++){
            ans[i] = pref*nums[i-1];
            pref = pref*nums[i-1];
        }

        for(int i=nums.length-1; i>=0; i--){
            ans[i] = post*ans[i];
            post = post*nums[i];
        }

        return ans;
    }
}  

