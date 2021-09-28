class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int bound = getDistance(target, new int[]{0, 0});
        for (int[] source : ghosts) {
            int distance = getDistance(target, source);
            if (distance <= bound) {    return false;   }
        }
        return true;
    }

    private static int getDistance(int[] target, int[] source) {
        return Math.abs(target[0] - source[0]) + Math.abs(target[1] - source[1]);
    }
}