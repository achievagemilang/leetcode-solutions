class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int ans = 0;

        int l = 0;
        int r = 0;
        Set<Character> seen = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);

            while(seen.contains(c)){
                char removed = s.charAt(l);
                seen.remove(removed);
                l++;
            }

            seen.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}

