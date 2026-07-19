class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() <= 1) return s.length();
        int[] count = new int[26]; 
        int ans = 0;

        int l = 0;
        int r = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            count[c - 'A']++;

            if(r - l + 1 - findMaxCount(count) <= k){
                ans = Math.max(r-l+1, ans);       
            } else {
                while(l < r && r - l + 1 - findMaxCount(count) > k){
                    count[s.charAt(l) - 'A']--;
                    l++;
                }
            }

            r++;
        }

        return ans;
    }

    public int findMaxCount(int[] count){
        int max = -1;
        for(int n: count){
            max = Math.max(n, max);
        }

        return max;
    }
}

