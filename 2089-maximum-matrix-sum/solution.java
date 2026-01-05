class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long minVal = Long.MAX_VALUE;
        int negatives = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                int m = matrix[i][j];
                minVal = Math.min(minVal, Math.abs(m));

                if(m < 0)
                    negatives++;
                    
                sum += Math.abs(m);
            }
        }

        if(negatives % 2 == 1) sum = sum - (2 * minVal);

        return sum;
    }
}
