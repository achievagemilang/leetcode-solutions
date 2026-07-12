class Solution {
    public int minimumCost(int[] nums, int k) {
        long op = 0;
        long resource = k;

        for(int n: nums){
            resource -= n;
            if (resource < 0){
                long deficit = -resource;
                long mul = (deficit + k - 1) / k;
                resource += mul * k;
                op += mul;
            }
        }

        return (int) toResult(op);

        
    }

    private long toResult(long op){
        final long MOD = 1_000_000_007L;
        long t1 = op;
        long t2 = op + 1;

        if(t1 % 2 == 0){
            t1 /= 2;
        } else {
            t2 /= 2;
        }

        t1 = t1 % MOD;
        t2 = t2 % MOD;
        long res = t1 * t2;

        return res % MOD;
    }
}
