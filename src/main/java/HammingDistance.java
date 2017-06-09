/**
 * Created by KJB-001064 on 2017/4/6.
 */
public class HammingDistance {
    public int hammingDistance(int x,int y){
        int a= x^y;
        int c=0;
        while(a!=0){
            c++;
            a=a&(a-1);
        }
        System.out.println(c);
        return c;
    }
    public int f(int a){
        if(a==0)
            return 0;
        else if((a=(a&(a-1)))==0)
            return 1;
        else{
            return 1+f(a);
        }
    }
    public int g(int x,int y){
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (((x & (1 << i)) ^ (y & (1 << i)))!=0) {
                ++res;
            }
        }
        return res;
    }
    public int h(int x,int y){
        if ((x ^ y) == 0) return 0;
        return (x ^ y) % 2 + hammingDistance(x / 2, y / 2);
    }
    public static void main(String[] args){
        HammingDistance h = new HammingDistance();
        h.hammingDistance(1,4);
        h.hammingDistance(7,2);
        h.hammingDistance(0,2);
        h.hammingDistance(1,1);
        System.out.println(h.f(5));
        System.out.println(h.g(1,4));
    }
}
