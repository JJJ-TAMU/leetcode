class Solution {
    // three cases:
    //  0: invalid
    //  1: rotate to itself
    //  2: good number
    public int rotatedDigits(int n) {
        int[] status = new int[Math.max(n, 10) + 1];
        status[0] = 1;
        status[1] = 1;
        status[2] = 2;
        status[3] = 0;
        status[4] = 0;
        status[5] = 2;
        status[6] = 2;
        status[7] = 0;
        status[8] = 1;
        status[9] = 2;

        for (int i = Math.min(n, 10); i <= n; i++) {
            int left = i / 10;
            int right = i % 10;
            if (status[left] == 0 || status[right] == 0) {  status[i] = 0;  }
            else if (status[left] == 1 && status[right] == 1) {  status[i] = 1;  }
            else { status[i] = 2;  }
        }

        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (status[i] == 2) {
                counter++;
            }
        }

        // System.out.println(Arrays.toString(status));
        return counter;
    }

    private static boolean canRotate(int digit) {
        return digit == 0 || digit == 1
        || digit == 2 || digit == 5
        || digit == 6 || digit == 9;
    }

    private static boolean good(int digit) {
        return digit == 2 || digit == 5 
        || digit == 6 || digit == 9;
    }
}