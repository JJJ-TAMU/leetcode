class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;

        int[] types = {-1, -1};
        int[] count = { 0,  0};

        int lo = 0;
        for (int hi = 0; hi < fruits.length; hi++) {
            if (types[0] == -1) {
                types[0] = fruits[i];
                count[0] = 1;
            } else if (types[1] == -1) {
                types[1] = fruits[i];
                count[1] = 1;
            } else if (types[0] == fruits[i]) {
                count[0]++;
            } else if (types[1] == fruits[i]) {
                count[1]++;
            } else {
                
            }
        }

    }
}