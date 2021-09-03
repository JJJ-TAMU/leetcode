class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort in descending order according to units
        Arrays.sort(boxTypes, (b0, b1)->Integer.compare(b1[1], b0[1]));
        int totalUnits = 0;
        for (int[] boxType : boxTypes) {
            int n = boxType[0], v = boxType[1];
            int m = Math.min(truckSize, n);
            totalUnits += m * v;
            truckSize -= m;
            if (truckSize == 0) {
                break;
            }
        }
        return totalUnits;
    }
}