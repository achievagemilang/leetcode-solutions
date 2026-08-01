class Solution {
    public int maximumWidth(int[] planks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int p: planks){
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        int[] vals = new int[freq.size()];
        int[] counts = new int[freq.size()];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            vals[idx] = entry.getKey();
            counts[idx] = entry.getValue();
            idx++;
        }

        Map<Integer, Integer> scores = new HashMap<>();
        int ans = 0;

        for(int i=0; i<vals.length; i++){
            int val = vals[i];
            int count = counts[i];

            // Take the plank as it is
            int singleScore = scores.getOrDefault(val, 0) + count;
            scores.put(val, singleScore);
            ans = Math.max(singleScore, ans);

            // Take 2 identical
            int identicalScore = scores.getOrDefault(val*2, 0) + count/2;
            scores.put(val*2, identicalScore);
            ans = Math.max(identicalScore, ans);
            
            // Take combination
            for(int j=i+1; j<vals.length; j++){
                int y = vals[j];
                int sum = val + y;

                int score = scores.getOrDefault(sum, 0) + Math.min(count, counts[j]);
                scores.put(sum, score);
                ans = Math.max(score, ans);
            }
        }
        
        return ans;
    }
}
