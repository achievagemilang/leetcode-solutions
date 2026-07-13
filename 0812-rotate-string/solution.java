class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int attempt = s.length();
        while (attempt > 0){
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(1)).append(s.charAt(0));
            s = sb.toString();
            if(s.equals(goal)) return true;
            attempt--;
        }
        
        return false;
    }
}
