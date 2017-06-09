package leetcode.No65ValidNumber;

/**
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        int i = 0;
        int len = s.length();
        if (len == 0)
            return false;
        while (i < len && s.charAt(i) != 'e')
            i++;
        if(i==len-1)
            return false;
        if (i == len)
            return valid(s, false);
        else
            return valid(s.substring(0, i), false) && valid(s.substring(i + 1), true);
    }

    public static boolean valid(String s, boolean hasdot) {
        if (s.length() == 0)
            return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if(s.length()==0||s.equals("."))
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (hasdot)
                    return false;
                hasdot = true;
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = {" e", "0", "--1", "1.1e10", "1 1e"};
        for (String i : s
                ) {
            System.out.println(isNumber(i));
        }

    }
}

//public class ValidNumber {
//    public boolean isNumber(String s) {
//        s = s.trim();
//
//        boolean pointSeen = false;
//        boolean eSeen = false;
//        boolean numberSeen = false;
//        boolean numberAfterE = true;
//        for(int i=0; i<s.length(); i++) {
//            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//                numberSeen = true;
//                numberAfterE = true;
//            } else if(s.charAt(i) == '.') {
//                if(eSeen || pointSeen) {
//                    return false;
//                }
//                pointSeen = true;
//            } else if(s.charAt(i) == 'e') {
//                if(eSeen || !numberSeen) {
//                    return false;
//                }
//                numberAfterE = false;
//                eSeen = true;
//            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
//                if(i != 0 && s.charAt(i-1) != 'e') {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//
//        return numberSeen && numberAfterE;
//    }
//}