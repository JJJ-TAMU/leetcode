class Solution {
    private static final int[][] DIRS = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int dirIdx = 0;
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    x += DIRS[dirIdx][0];
                    y += DIRS[dirIdx][1];
                    break;
                case 'R':
                    dirIdx = (dirIdx + 1) % 4;
                    break;
                case 'L':
                    dirIdx = (dirIdx + 3) % 4;
                    break;
                default:
                    break;
            }
        }
        return !(dirIdx == 0 && (x != 0 || y != 0));
    }
}