import java.util.*;

class sieveOfEratosthenes{

    // TC - N(log(logN)) -> ~O(N)
    public static boolean[] sieve(int n){
        boolean primes[]=new boolean[n+1];
        
        // Mark all primes true
        for(int i=2;i<=n;i++)primes[i]=true;

        // Mark false for multiple of primes
        for(int p=2;p<=n;p++){
            if(primes[p]){
                for(int i=p*p;i<=n;i+=p){
                    primes[i]=false;
                }
            }
        }
        return primes;
    }





    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        boolean primes[]=sieve(n);

        for(int i=0;i<=n;i++){
            System.out.print(i+"-"+primes[i]+", ");
        }
    }
}