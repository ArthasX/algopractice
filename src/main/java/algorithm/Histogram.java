package algorithm;

import java.util.Arrays;

/**
 * Created by KJB-001064 on 2017/6/9.
 */
public class Histogram {
    public static int[] histogram(int[]a,int m){
        int []b=new int[m];
        for(int i=0;i<a.length;i++){
            b[a[i]]++;
        }
        return b;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(histogram(new int[]{1,2,2,3},4)));

    }
}
