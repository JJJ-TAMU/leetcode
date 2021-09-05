class Solution {
    private static final String[] LESS_THAN_TWENTY = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
    };

    private static final String[] TENS = {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] BIG_STRINGS = {"Billion", "Million", "Thousand"};
    private static final int[] BIG_VALUES = {1000_000_000, 1000_000, 1000};

    private static final char SPACE = ' ';

    public String numberToWords(int num) {
        // Corner case: num is zero
        if (num == 0) { return LESS_THAN_TWENTY[num];   }  

        StringBuilder sb = new StringBuilder();
        // Process thousands and more
        sb.append(handleThousand(num));
        num %= 1000;
        sb.append(handleHundred(num));
        return sb.toString();
    }

    private static StringBuilder handleThousand(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < BIG_STRINGS.length; i++) {
            String name = BIG_STRINGS[i];
            int value = BIG_VALUES[i];
            if (num >= value) {
                int times = num / value;
                num %= value;
                ans.append(handleHundred(times)).append(SPACE).append(name);
                appendIfMore(ans, num);
            }
        }
        return ans;
    }

    private static StringBuilder handleHundred(int num) {
        StringBuilder ans = new StringBuilder();
        if (num >= 100) {
            int times = num / 100;
            num %= 100;
            ans.append(LESS_THAN_TWENTY[times]).append(SPACE).append("Hundred");
            appendIfMore(ans, num);
        }
        if (num >= 20) {
            int times = num / 10;
            num %= 10;
            ans.append(TENS[times]);
            appendIfMore(ans, num);
        }
        if (num > 0) {
            ans.append(LESS_THAN_TWENTY[num]);
        }
        return ans;
    }

    private static void appendIfMore(StringBuilder sb, int num) {
        if (num > 0) {  sb.append(SPACE);   }
    }
}