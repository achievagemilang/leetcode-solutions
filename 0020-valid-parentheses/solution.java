class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        if(s.length() == 0) return true;

        Deque<Character> st = new ArrayDeque<>();
        Map<Character,Character> pairMap = new HashMap<>(Map.of(']', '[', '}', '{'));
        pairMap.put(')', '(');
        Set<Character> open = new HashSet<>(Set.of('(', '{', '['));

        for(char c: s.toCharArray()){
            if(open.contains(c)){
                st.push(c);
            } else{
                if(st.isEmpty()) return false;
                char popped = st.pop();
                if(pairMap.get(c) != popped){
                    return false;
                }
            } 
        }

        return st.isEmpty();
    }
}

