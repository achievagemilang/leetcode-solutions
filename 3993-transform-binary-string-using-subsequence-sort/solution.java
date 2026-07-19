class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        int m = strs.length;
        boolean[] ans = new boolean[m];

        int[] sZeros = new int[n];
        int totalZeroInS = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0'){
                totalZeroInS++;
            }
            sZeros[i] = totalZeroInS;
        }

        for(int i=0; i<m; i++){
            ans[i] = canTransformSingle(strs[i], sZeros, totalZeroInS, n);
        }
        return ans;
    }

    private boolean canTransformSingle(String target, int[] sZeros, int totalZeroInS, int n){
        int zerosInTarget = 0;
        int questionsInTarget = 0;

        for(int i=0; i<n; i++){
            if(target.charAt(i) == '0') zerosInTarget++;
            else if (target.charAt(i) == '?') questionsInTarget++;
        }

        int zerosNeeded = totalZeroInS - zerosInTarget;

        if(zerosNeeded < 0 || zerosNeeded > questionsInTarget){
            return false;
        }

        int currentZeros = 0;
        int questionsUsedForZero = 0;

        for(int i=0; i<n; i++){
            char c = target.charAt(i);

            if(c == '0'){
                currentZeros++;
            } else if(c == '?'){
                if(questionsUsedForZero < zerosNeeded){
                    currentZeros++;
                    questionsUsedForZero++;
                }
            }
            if(currentZeros < sZeros[i]){
                return false;
            }
        }

        return true;
        
    }
}
