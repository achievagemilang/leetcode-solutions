class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        if (turnedOn >= 9) {
            return times;
        }

        for (int h = 0; h < 12; h++) {
            int hBits = Integer.bitCount(h);
            if (hBits > turnedOn) continue;

            for (int m = 0; m < 60; m++) {
                if (hBits + Integer.bitCount(m) == turnedOn) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return times;
    }
}
