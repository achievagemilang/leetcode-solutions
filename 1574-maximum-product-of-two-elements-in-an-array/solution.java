class Solution {
    public int maxProduct(int[] nums) {
        int i = 0;
        int secondLargest = 1;
        for(int j = 2; j< nums.length; j++){
            if(nums[i] < nums[j]){
                if(nums[secondLargest] < nums[i]) secondLargest = i;
                i = j;
            } else if(nums[secondLargest] < nums[j]){
                secondLargest = j;
            }
        }

        return (nums[secondLargest] - 1) * (nums[i] - 1);

    }
}
