class Solution {
    public int reverseBits(int n) {
        if (n == 0) return 0; 

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            sb.append(rem);
            n = n / 2;
        }

        while(sb.length() < 32){
            sb.append(0);
        }

        int sum = 0;
        int p = 0;
        for(int i=sb.length()-1; i > 0; i--){
            sum += Math.pow(2, p) * (sb.charAt(i) - '0');
            p++;
        }

        return sum;
    }
}
