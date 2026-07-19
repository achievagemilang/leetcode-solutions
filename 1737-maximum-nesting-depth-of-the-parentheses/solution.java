class Solution {
    public int maxDepth(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') st.push('(');
            if(s.charAt(i) == ')') st.pop();

            max = Math.max(max, st.size());
        }

        return max;
    }
}
