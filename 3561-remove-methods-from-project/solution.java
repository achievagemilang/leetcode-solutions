class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> sus = new HashSet<>();

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] inv: invocations){
            adj.get(inv[0]).add(inv[1]);
        }

        dfs(k, sus, adj);

        boolean canRemove = true;
        for(int[] inv: invocations){
            int from = inv[0];
            int to = inv[1];

            if(!sus.contains(from) && sus.contains(to)){
                canRemove = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(canRemove){
            for(int i=0; i<n; i++){
                if(!sus.contains(i)){
                    ans.add(i);
                }
            }
        } else {
            for(int i=0; i<n; i++){
                ans.add(i);
            }
        }

        return ans;

    }

    public void dfs(int pos, Set<Integer> sus, Map<Integer, List<Integer>> adj){
        if(sus.contains(pos)) return;

        sus.add(pos);
        for(Integer i: adj.get(pos)){
            dfs(i, sus, adj);
        }
    }
}
