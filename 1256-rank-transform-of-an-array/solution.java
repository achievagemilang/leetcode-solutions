class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        Map<Integer, Integer> rankMap = new HashMap<>();

        for(int n: arr){
            pq.add(n);
        }

        int i = 1;
        while(!pq.isEmpty()){
            int n = pq.poll();
            if (rankMap.containsKey(n)) continue;
            rankMap.put(n, i);
            i++;
        }

        int[] res = new int[arr.length];
        i = 0;
        for(int n: arr){
            res[i] = rankMap.get(n);
            i++;
        }

        return res;


    }
}
