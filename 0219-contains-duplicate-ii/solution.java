class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        Set<Integer> seen = new HashSet<>();
        seen.add(nums[l]);

        for(int r=1; r<nums.length; r++){
            if(r - l > k){
                seen.remove(nums[l]);
                l++;
            }
            if(seen.contains(nums[r])) return true;
            seen.add(nums[r]);
        }

        return false;
    }
}
