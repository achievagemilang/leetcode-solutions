class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int low = 101;
        int high = 0;
        Set<Integer> seen = new HashSet<>();

        for(int n: nums){
            low = Math.min(low, n);
            high = Math.max(high, n);
            seen.add(n);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = low; i <= high; i++){
            if(!seen.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}
