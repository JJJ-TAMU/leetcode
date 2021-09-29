class Solution {
    private static final int EMAIL = 0;
    private static final int PHONE = 1;

    public String maskPII(String s) {
        int type = getType(s);
        if (type == EMAIL) {
            return maskEmail(s);
        }
        return maskPhone(s);
    }

    private static int getType(String s) {
        if (Character.isLetter(s.charAt(0))) {
            return EMAIL;
        } else {
            return PHONE;
        }
    }

    private static String maskEmail(String s) {
        int mid = s.indexOf("@");
        int nameLen = mid;
        StringBuilder sb = new StringBuilder(s.length() - nameLen + 7);
        // append the first
        sb.append(Character.toLowerCase(s.charAt(0)));
        if (mid > 1) {
            sb.append("*****");
            sb.append(Character.toLowerCase(s.charAt(mid - 1)));
        }
        for (int i = mid; i < s.length(); i++) {
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    private static String maskPhone(String s) {
        StringBuilder digits = getDigits(s);
        int nCountryCode = digits.length() - 10;
        StringBuilder sb = new StringBuilder();

        switch (nCountryCode) {
            case 0:
                break;
            default:
                sb.append('+');
                for (int i = 0; i < nCountryCode; i++) {    sb.append('*'); }
                sb.append('-');
                break;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append('*');
            }
            sb.append('-');
        }
        sb.append(digits.substring(digits.length() - 4));
        return sb.toString();
    }

    private static StringBuilder getDigits(String s) {
        StringBuilder digits = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }
        return digits;
    }
}