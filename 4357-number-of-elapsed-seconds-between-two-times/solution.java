class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] endArr = endTime.split(":");
        String[] startArr = startTime.split(":");
        boolean isCarry = false;

        int end = Integer.parseInt(endArr[2]);
        int start = Integer.parseInt(startArr[2]);
        int resSec = end - start;
        if(resSec < 0) {
            isCarry = true;
            resSec += 60;
        }

        end = Integer.parseInt(endArr[1]);
        start = Integer.parseInt(startArr[1]);
        int resMin = end;
        if(isCarry){
            resMin -= 1;
            isCarry = false;
        }
        resMin -= start;
        if(resMin < 0) {
            isCarry = true;
            resMin += 60;
        }

        end = Integer.parseInt(endArr[0]);
        start = Integer.parseInt(startArr[0]);
        int resHour = end;
        if(isCarry){
            resHour -= 1;
            isCarry = false;
        }
        resHour -= start;

        return resHour*3600 + resMin*60 + resSec;
    }
}

/*
split by ":"
hour = s[0]
minute = s[1]
sec = s[2]

endTimeSec - startTimeSec

*/
