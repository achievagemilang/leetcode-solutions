class Solution {
    public int longestBalanced(String s) {
        int maxLen = 0;
        
        int currentRun = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            maxLen = Math.max(maxLen, currentRun);
        }

        maxLen = Math.max(maxLen, solveTwo(s, 'a', 'b', 'c')); // Ignore c
        maxLen = Math.max(maxLen, solveTwo(s, 'a', 'c', 'b')); // Ignore b
        maxLen = Math.max(maxLen, solveTwo(s, 'b', 'c', 'a')); // Ignore a

        maxLen = Math.max(maxLen, solveThree(s));

        return maxLen;
    }

    private int solveTwo(String s, char c1, char c2, char forbidden) {
        int max = 0;
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int balance = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == forbidden) {
                map = new HashMap<>();
                map.put(0, i); 
                balance = 0;
            } else {
                if (c == c1) balance++;
                else if (c == c2) balance--;
                
                if (map.containsKey(balance)) {
                    max = Math.max(max, i - map.get(balance));
                } else {
                    map.put(balance, i);
                }
            }
        }
        return max;
    }

    private int solveThree(String s) {
        int max = 0;
        int n = s.length();
        
        int offset = n; 
        
        Map<Long, Integer> map = new HashMap<>();
        
        long initialKey = (((long)0 + offset) << 32) | ((long)0 + offset);
        map.put(initialKey, -1);
        
        int a = 0, b = 0, c = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;
            
            long d1 = (a - b) + offset;
            long d2 = (b - c) + offset;
            long key = (d1 << 32) | d2;
            
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
