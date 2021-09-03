class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String l1, String l2) {
                String[] c1 = l1.split(" ", 2);
                String[] c2 = l2.split(" ", 2);
                if (Character.isDigit(c1[1].charAt(0))) {
                    if (Character.isDigit(c2[1].charAt(0))) {
                        return 0;
                    }
                    return 1;
                } else {
                    if (Character.isDigit(c2[1].charAt(0))) {
                        return -1;
                    }
                    int cmp = c1[1].compareTo(c2[1]);
                    return cmp == 0 ? c1[0].compareTo(c2[0]) : cmp;
                }
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}