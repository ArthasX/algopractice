package leetcode.No476NumberComplement;

/**
 * Created by KJB-001064 on 2017/6/9.
 * <p>
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * <p>
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * <p>
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * <p>
 * According to the problem, the result is
 * <p>
 * The flipped version of the original input but
 * Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
 * For example input = 5 (the binary representation is 101), the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3). Then we need to flip 3 bits from RIGHTMOST and the answer is 010
 * To achieve above algorithm, we need to do 3 steps:
 * <p>
 * Create a bit mask which has N bits of 1 from RIGHTMOST. In above example, the mask is 111. And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, left shift one, and then minus one. Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, you will be able to use it later.
 * Negate the whole input number.
 * Bit AND numbers in step 1 and 2.
 * <p>
 * 5
 * <p>
 * 0....0101
 * mask
 * <p>
 * 0100 <<1 0...1000
 * <p>
 * 1000  -1 0...0111  if don't left shift 1,the the mask-1 is 0...0100-1=0...0011,we can get the same result
 * <p>
 * ~5
 * <p>
 * 1...1010
 * <p>
 * 0...0011
 * <p>
 * 0...0010  = 2
 */
public class NumberComplement {
    public static int NumberComplement(int num) {
        int mask = Integer.highestOneBit(num) - 1;//最高位源码肯定是1  去反后肯定是0 所以最高位不用管
        //(Integer.highestOneBit(num) << 1) - 1); 101
        System.out.println(mask);
        num = ~num;
        System.out.println(num);
        return mask & num;
    }

    public static void main(String[] args) {
        System.out.println(NumberComplement(5));
    }
}


//public class NumberComplement {
//    public static int NumberComplement(int num) {
//        return (Integer.highestOneBit(num)<<1) - 1-num;  //7-5=2
//    }
//}

