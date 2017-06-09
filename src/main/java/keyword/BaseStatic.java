package keyword;

public class BaseStatic {
    static {
        System.out.println("Load base static");
    }

    public BaseStatic(){
        System.out.println("BaseStatic constructor");
    }

    static class BaseInnerClass{
        static{
            System.out.println("Base inner class static");
        }

        public BaseInnerClass(){
            System.out.println("BaseInnerClass constructor");
        }
    }

}


