package leetcode.No557;

import java.util.Stack;

/**
 * Created by KJB-001064 on 2017/6/9.
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        int i = 0;
        Stack<Character> ss = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        while (i <= s.length()) {
            if (i != s.length() && s.charAt(i) != ' ') {
                ss.push(s.charAt(i));
            } else {
                int j = 0;
                int k = ss.size();
                while (j < k) {
                    sb.append(ss.pop());
                    j++;
                }
                sb.append(' ');
            }
            i++;
        }
        return sb.toString().trim();
    }

       public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}

//
//public class Solution {
//    public String reverseWords(String s) {
//        char[] c = s.toCharArray();
//        int index = s.indexOf(" ");
//        int lastIndex = -1;
//        while(index !=-1){
//            swap(c, lastIndex+1,index-1);
//            lastIndex =index;
//            index = s.indexOf(" ", lastIndex +1);
//        }
//
//        swap(c,lastIndex+1,c.length-1);
//
//        return new String(c);
//    }
//
//    private void swap(char[] c, int low, int high){
//        char temp;
//        while(high>low){
//            temp = c[low];
//            c[low] = c[high];
//            c[high] = temp;
//            low++;
//            high--;
//        }
//    }
//}