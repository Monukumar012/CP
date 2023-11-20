import java.util.*;

class Main{

    // TC - sqrt(N)  |  SC - |facotrs|
    // get All Factors/Divisors of N 
    public static List<Integer> getFactors(int n){
        List<Integer> factor = new ArrayList<>();
        
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                factor.add(i);
                if(i!=n/i)factor.add(n/i);
            }
        }
        return factor;
    }


    // TC - sqrt(N)
    // Count All Factors/Divisors of N 
    public static int countFactors(int n){
        int cnt=0;

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                cnt++;
                if(i!=n/i)cnt++;
            }
        }
        return cnt;
    }




    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        System.out.println(getFactors(n));
    }
}