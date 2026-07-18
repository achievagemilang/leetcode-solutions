class Solution {
    public int findGCD(int[] nums) {
        int largest = -1;
        int smallest = 1001;
        for(int n: nums){
            if(largest < n){
                largest = n;
            }
            if(smallest > n){
                smallest = n;
            }
        }

        return gcd(largest, smallest);
    }

    public int gcd(int a, int b){
        if(b == 0){
            return Math.abs(a);
        }

        return gcd(b, a % b);
    }
}
