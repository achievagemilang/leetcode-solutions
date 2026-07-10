class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        for(int n: nums){
            if(mp.containsKey(target - n)){
                return new int[]{mp.get(target - n), i};
            }
            mp.put(n, i);
            i++;
        }

        return new int[]{0, 0};
        
    }
}
