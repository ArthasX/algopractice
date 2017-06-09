/**
 * Created by KJB-001064 on 2017/5/25.
 */
public class Time33 {
    static char[] str = {'A', 'A'};

    public static void main(String[] args) {
        System.out.println(hash(1));
    }

    public static int hash(int i) {

        if (i == 0)
            return str[i];
        return hash(i - 1) * 33 + str[i];
    }
}
