import java.util.*;

class Main{

    // TC - sqrt(N)
    // Check for prime
    public static boolean isPrime(int n){
        if(n<2)return false;
        
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }





    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        System.out.println(isPrime(n));
    }
}