class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] actual = new int[3];
        for (int[] triplet : triplets) {
            if (validate(triplet, target)) {
                update(actual, triplet);
            }
        }
        return Arrays.equals(actual, target);
    }

    private static void update(int[] actual, int[] triplet) {
        for (int i = 0; i < 3; i++) {
            actual[i] = Math.max(actual[i], triplet[i]);
        }
    }

    private static boolean validate(int[] actual, int[] target) {
        for (int i = 0; i < 3; i++) {
            if (actual[i] > target[i]) {
                return false;
            }
        }
        return true;
    }
}