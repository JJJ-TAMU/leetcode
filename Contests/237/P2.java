class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int counter = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins >= 0) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }
}