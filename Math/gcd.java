import java.util.*;

class Main{

    // TC - log(min(a, b))
    // Calulate gcd of a,b
    public static int gcd(int a,int b){
        if(a==0)return b;

        return gcd(b%a, a);
    }





    
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(gcd(a,b));
    }
}