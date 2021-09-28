class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int max = Integer.MIN_VALUE;

        int prev = heaters[0];

        int hIdx = 0;

        for (int house : houses) {
            if (house <= prev) {
                max = Math.max(max, prev - house);
            } else {
                hIdx++;
                while (hIdx < heaters.length && heaters[hIdx] <= house) {
                    hIdx++;
                }
                // System.out.println(hIdx);
                if (hIdx == heaters.length) {
                    max = Math.max(houses[houses.length - 1] - heaters[hIdx - 1], max);
                    break;
                } else {
                    if (house - heaters[hIdx - 1] < heaters[hIdx] - house) {
                        max = Math.max(house - heaters[hIdx - 1], max);
                        prev = heaters[hIdx - 1];
                        hIdx = hIdx - 1;
                    } else {
                        max = Math.max(heaters[hIdx] - house, max);
                        prev = heaters[hIdx];
                    }
                }
            }
        }
        return max;
    }
}