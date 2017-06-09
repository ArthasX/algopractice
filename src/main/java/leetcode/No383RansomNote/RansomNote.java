package leetcode.No383RansomNote;

/**
 * Created by KJB-001064 on 2017/6/8.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[58]; //65-122   0-57
        int[] m = new int[58];
        for (int i = 0; i < ransomNote.length(); i++) {
            r[ransomNote.charAt(i) - 65]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            m[magazine.charAt(i) - 65]++;
        }
        for (int i = 0; i < 58; i++) {
            if (r[i] - m[i] > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
}

//
//public class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//
//        int l1 = ransomNote.length();
//        int l2 = magazine.length();
//
//        if (l1 > l2)
//            return false;
//        if (l1 == 0)
//            return true;
//
//        char[] arr1 = ransomNote.toCharArray();
//        char[] arr2 = magazine.toCharArray();
//
//
//        int[] hash = new int[256];
//
//        for (int i = 0; i < l2; i++)
//            hash[arr2[i]]++;
//
//        for (int i = 0; i < l1; i++) {
//            if (hash[arr1[i]] == 0)
//                return false;
//            else
//                hash[arr1[i]]--;
//        }
//        return true;
//    }
//}