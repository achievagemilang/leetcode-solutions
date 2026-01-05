class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r = height.length - 1;
        int ans = -1;
        while(l < r){
            int d = r - l;
            int h = Math.min(height[l], height[r]);

            int a = d * h;
            ans = Math.max(a, ans);

            if(height[l] > height[r]){
                r--;
            } else l++;

        }

        return ans;
    }
}
