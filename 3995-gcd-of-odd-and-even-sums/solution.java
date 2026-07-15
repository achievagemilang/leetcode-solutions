class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = (2*n)*n/2;
        int sumEven = (1+n)*n;

        return gcd(sumOdd, sumEven);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}
