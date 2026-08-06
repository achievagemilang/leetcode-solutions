class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(divisibleByT(n, t)) return n;
            n++;
        }
    }

    public boolean divisibleByT(int n, int t){
        int product = 1;
        while(n > 0){
            int digit = n % 10;
            product *= digit;
            n /= 10;
        }

        return product % t == 0;
    }
}
