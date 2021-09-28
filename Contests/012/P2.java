class Solution {
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";
    private static final String NEITHER = "Neither";
    private static final String DOT = "\\.";
    private static final String COLON = ":";

    public String validIPAddress(String IP) {
        if (containsDot(IP)) {
            if (containsCOLON(IP)) {
                return NEITHER;
            }
            return validateV4(IP);
        } else if (containsCOLON(IP)){
            return validateV6(IP);
        } else {
            return NEITHER;
        }
    }

    private static boolean containsDot(String IP) {
        return IP.indexOf('.') != -1;
    }
    private static boolean containsCOLON(String IP) {
        return IP.indexOf(COLON) != -1;
    }
    private static String validateV4(String IP) {
        String[] parts = IP.split(DOT, -1);
        int n = parts.length;
        if (n != 4) {   return NEITHER; }
        for (String part : parts) {
            if (!validateV4Part(part)) {
                return NEITHER;
            }
        }
        return IPV4;
    }

    private static boolean validateV4Part(String part) {
        if (part.length() < 1 || part.length() > 3) {   return false;   }
        char[] cs = part.toCharArray();
        for (char ch : cs) {
            if (ch > '9' || ch < '0') {
                return false;
            }
        }
        int actual = Integer.valueOf(part);
        if (actual > 255 || Integer.toString(actual).length() < part.length()) {
            return false;
        }
        return true;
    }

    private static String validateV6(String IP) {
        String[] parts = IP.split(COLON, -1);
        int n = parts.length;
        if (n != 8) {   return NEITHER; }
        for (String part : parts) {
            if (!validateV6Part(part)) {
                return NEITHER;
            }
        }
        return IPV6;
    }
    
    private static boolean validateV6Part(String part) {
        if (part.length() < 1 || part.length() > 4) {
            return false;
        }
        char[] cs = part.toCharArray();
        for (char ch : cs) {
            if (Character.isDigit(ch)) {
                continue;
            }
            if (!((ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f'))) {
                return false;
            }
        }
        return true;
    }

}