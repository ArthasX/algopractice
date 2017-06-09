package keyword;

import java.util.HashMap;

/**
 * Created by KJB-001064 on 2017/5/31.
 */

public class StaticLoadOrderTest extends BaseStatic{

    static {
        System.out.println("Load test");
    }

    public StaticLoadOrderTest(){
        System.out.println("Test constructor");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BaseStatic.BaseInnerClass();new StaticLoadOrderTest();
        new BaseStatic();
    }


}