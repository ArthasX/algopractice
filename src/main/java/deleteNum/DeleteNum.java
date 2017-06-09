package deleteNum;


import util.ListQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/5/2.
 */
public class DeleteNum {
    static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int current;

    public int list() {

        return 0;
    }

    public int array() {
        return 0;
    }

    public static void main(String args[]) {
        ListQueue lq= new ListQueue();
        List<int[]> arrayList = Arrays.asList(num);
        lq.add(arrayList);
        //System.out.println(Node.node2String(n));
        System.out.println(lq);
    }



}


