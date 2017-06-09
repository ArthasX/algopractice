package array;

/**
 * Created by KJB-001064 on 2017/5/16.
 */
import java.util.Scanner;
public class InequalitySeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据
            String[] nums = sc.nextLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int k = Integer.parseInt(nums[1]);//k个小于符号

            int[][] dp = new int[1005][1005];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
            }

            //dp[i][j]表示前i个数字构成的数列中，
            // 恰有j个‘<’号的方案数（‘>’号就有i - j - 1个）
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1)) % 2017;
                }
            }

            System.out.println(dp[n][k] % 2017);
        }
    }
}
