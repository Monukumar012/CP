import java.io.*;
import java.util.*;


public class Main{
    static void solve(){
        // Mix.yes();
    }
    
    public static void main(String[] args) {
        // int t=sc.nextInt();
        // while(t-->0)solve();
        solve();
    }
    // Mix xxx = new Mix();

// Input
    // public static Scanner sc = new Scanner(System.in);
    static Scanner sc = new Scanner();

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;
 
        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextIntArray(int n){
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=nextInt();
            }
            return arr;
        }

        long[] nextLongArray(int n){
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=nextLong();
            }
            return arr;
        }

        double[] nextDoubleArray(int n){
            double arr[]=new double[n];
            for(int i=0;i<n;i++){
                arr[i]=nextDouble();
            }
            return arr;
        }

        char[] nextCharArray(int n){
            char[] arr=new char[n];
            for(int i=0;i<n;i++){
                arr[i]=next().charAt(0);
            }
            return arr;
        }

        int [][] nextIntMatrix(int n,int m){
            int arr[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=nextInt();
                }
            }
            return arr;
        }

        long [][] nextLongMatrix(int n,int m){
            long arr[][]=new long[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=nextLong();
                }
            }
            return arr;
        }

        double [][] nextDobuleMatrix(int n,int m){
            double arr[][]=new double[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=nextDouble();
                }
            }
            return arr;
        }

        char [][] nextCharMatrix(int n,int m){
            char arr[][]=new char[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=next().charAt(0);
                }
            }
            return arr;
        }

        
    }


    static class Mix{
        
        public void yes(){
            System.out.println("YES");
        }
        public void no(){
            System.out.println("NO");
        }

        public void nline(){
            System.out.println();
        }

        public void printArray(int arr[]){
            for(int e: arr)System.out.print(e+" ");
        }

        public void printArray(long arr[]){
            for(long e: arr)System.out.print(e+" ");
        }

        public int max(int arr[]){
            int max = Integer.MIN_VALUE;
            for(int e: arr)max=Math.max(max,e);
            return max;
        }

        public int min(int arr[]){
            int min = Integer.MAX_VALUE;
            for(int e: arr)min=Math.min(min,e);
            return min;
        }

        public long sum(int arr[]){
            long sum=0;
            for(int e:arr)sum+=e;
            return sum;
        }

        public long sum(long arr[]){
            long sum=0;
            for(long e:arr)sum+=e;
            return sum;
        }

        public boolean isSorted(int arr[], int i ,int j){
            int n=arr.length;
            while(i!=j){
                if(arr[i%n]>arr[(i+1)%n])return false;
                i++;i%=n;
            }
            return true;
        }

        public void reverse(int arr[], int i, int j){
            while(i<j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;j--;
            }
        }

        public void reverse(char arr[], int i, int j){
            while(i<j){
                char t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;j--;
            }
        }

        public void reverse(long arr[], int i, int j){
            while(i<j){
                long t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;j--;
            }
        }

        public int[] copy(int arr[]){
            int n=arr.length;
            int copy[]=new int[n];
            for(int i=0;i<n;i++)copy[i]=arr[i];
            return copy;
        }

        public long[] copy(long arr[]){
            int n=arr.length;
            long copy[]=new long[n];
            for(int i=0;i<n;i++)copy[i]=arr[i];
            return copy;
        }

        public char[] copy(char arr[]){
            int n=arr.length;
            char copy[]=new char[n];
            for(int i=0;i<n;i++)copy[i]=arr[i];
            return copy;
        }

        public boolean isPalindrome(String s, int i, int j){
            while(i<j){
                if(s.charAt(i++)!=s.charAt(j--))return false;
            }
            return true;
        }

        public boolean isPalindrome(char s[], int i, int j){
            while(i<j){
                if(s[i++]!=s[j--])return false;
            }
            return true;
        }

        public boolean isVowel(char c){
            return "aeiouAEIOU".indexOf(c)!=-1;
        }

        public boolean isConsonant(char c){
            return !isVowel(c);
        }


        // Template
        // TC - N(log(logN)) -> ~O(N)
        public boolean[] sieve(int n){
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

        // Calulate gcd of a,b
        public int gcd(int a,int b){
            if(a==0)return b;
            return gcd(b%a, a);
        }

        public long gcd(long a,long b){
            if(a==0)return b;
            return gcd(b%a, a);
        }

        // get All Factors/Divisors of N 
        public List<Integer> getFactors(int n){
            List<Integer> factor = new ArrayList<>();
            
            for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    factor.add(i);
                    if(i!=n/i)factor.add(n/i);
                }
            }
            return factor;
        }

        // Count All Factors/Divisors of N 
        public int countFactors(int n){
            int cnt=0;

            for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    cnt++;
                    if(i!=n/i)cnt++;
                }
            }
            return cnt;
        }

        // Decimal to binary
        public String DtoB(int n){
            StringBuilder sb=new StringBuilder();
            while(n>0){
                sb.append(n%2);
                n>>=1;
            }
            return sb.reverse().toString();
        }

        //Binary to Decimal
        public int BtoD(String s){
            int n=0,k=s.length()-1;
            for(char c:s.toCharArray()){
                if(c=='1')n+=1<<k;
                k--;
            }
            return n;
        }

        // Check ith bit is set or not
        public boolean isBitSet(int n,int i){
            return (n&(1<<i))!=0;
        }

        // Check N is power of 2
        public boolean isPowerOf2(int n){
            return (n&(n-1))==0;
        }


        // Check N is power of 4 or not
        public boolean isPowerOf4(int n) {
            return n>0 && (n & (n-1))==0 && n%3==1;
        }

        // Count Set bit in N | TC - O(no. of set bits)
        public int cntSetBit(int n){
            int cnt=0;
            while(n>0){
                n=n&(n-1);
                cnt++;
            }
            return cnt;
        }

        // Check all bits are set in given num | 7-> 111
        public boolean allBitSet(int n){
            return (n&(n+1))==0;
        }

        // Check bits in num having in alternative form | 101010 | 010101
        public boolean isAlternativeBit(int n){
            // 101010 ^ 010101 (n>>1) = 111111
            return allBitSet(n^(n>>1));
        }
    }

}


