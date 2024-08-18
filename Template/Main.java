import java.io.*;
import java.util.*;


public class Main{

    static void solve(){
        
    }

    public static void main(String[] args) {
        int t=1;
        //t=sc.nextInt();
        while(t-->0){
            out.res.setLength(0);
            solve();
        }
    }

// Input
    // public static Scanner sc = new Scanner(System.in);
    static Mix out = new Mix();
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

        char[] nextToCharArray(){
            return next().toCharArray();
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
        
        long MOD=(long)1e9+7;
        public StringBuilder res=new StringBuilder();
        public void yes(){
            System.out.println("YES");
        }

        public void no(){
            System.out.println("NO");
        }

        public void debug(Object...obj) {
            System.out.println(Arrays.deepToString(obj));
        }

        public void nline(){
            System.out.println();
        }

        public void print(String x){
            res.append(x);
        }

        public void print(int x){
            res.append(x);
        }

        public void print(long x){
            res.append(x);
        }

        public void print(char x){
            res.append(x);
        }

        public void println(String x){
            res.append(x).append("\n");
        }

        public void println(int x){
            res.append(x).append("\n");
        }

        public void println(long x){
            res.append(x).append("\n");
        }

        public void println(char x){
            res.append(x).append("\n");
        }

        public void printArray(int arr[]){
            for(int e: arr)res.append(e+" ");
            System.out.println(res);
        }

        public void printArray(long arr[]){
            for(long e: arr)res.append(e+" ");

            System.out.println(res);
        }

        public void printMatrix(int arr[][]){
            
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
            while(i<=j){
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


        public Map<Long, Integer> primeFactorization(long n) {
            Map<Long, Integer> map = new HashMap<>();
            while (n % 2 == 0) {
                map.merge(2L, 1, Integer::sum);
                n /= 2;
            }
            
            for (long i = 3; i * i <= n; i += 2) {
                while (n % i == 0) {
                    map.merge(i, 1, Integer::sum);
                    n /= i;
                }
            }
            
            if (n > 2) map.merge(n, 1, Integer::sum);
            return map;
        }

        public long totalFactorsFromPrimeFactorization(Map<Long, Integer> primeFactors) {
            long totalFactors = 1;
            for (int exponent : primeFactors.values())
                totalFactors *= (exponent + 1);
            return totalFactors;
        }

        public List<Integer> getCompositeNumbers(int n) {
            List<Integer> list=new ArrayList<>();
            boolean[] primes=sieve(n);
            for(int i=0;i<n;i++){
                if(!primes[i])
                    list.add(i);
            }

            return list;
        }
        public long max(long...arr) {
            long max=arr[0];
            for(long e:arr)max=Math.max(max,e);
            
            return max;
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

        // Check Inside matrix or not
        public boolean isSafe(int i, int j, int n, int m){
            return i>=0 && i<n && j>=0 & j<m;
        }


        // (X^Y)%P
        public long power(long x, long y, long p){
            long res = 1;
            x = x % p;
            if (x == 0)return 0;
            while (y > 0){
                if((y & 1) != 0) res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            res %=p;
            if(res<0)res+=p;
            return res;
        }

        // (X^Y)%P
        public int power(int x, int y, int p){
            int res = 1;
            x = x % p;
            if (x == 0)return 0;
            while (y > 0){
                if((y & 1) != 0) res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            res %=p;
            if(res<0)res+=p;
            return res;
        }


        //Lower Bound - Smallest Index i a[i]>=x
        public int lowerBound(List<Integer> arr, int n, int x){
            
            int l=0, h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr.get(m)>=x){
                    h=m-1;
                }
                else l=m+1;
            }
            return l;
        }

        //Lower Bound - Smallest Index i a[i]>=x
        public int lowerBound(List<Long> arr, int n, long x){
            
            int l=0, h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr.get(m)>=x){
                    h=m-1;
                }
                else l=m+1;
            }
            return l;
        }
        public int lowerBound(int arr[], int n, int x){
            
            int l=0, h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr[m]>=x){
                    h=m-1;
                }
                else l=m+1;
            }
            return l;
        }


        //Upper Bound - Largest Index i a[i]<=x

        public int upperBound(List<Integer> arr, int n, int x){
            
            int l=0, h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr.get(m)<=x){
                    l=m+1;
                }
                else h=m-1;
            }

            return h;
        }

        public int upperBound(int arr[], int n, int x){
            
            int l=0, h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr[m]<=x){
                    l=m+1;
                }
                else h=m-1;
            }

            return h;
        }


        // Template
        // TC - N(log(logN)) -> ~O(N)
        public boolean[] sieve(int n){
            boolean primes[]=new boolean[n+1];
            
            // Mark all primes true
            for(int i=2;i<=n;i++)primes[i]=true;

            // Mark false for multiple of primes
            for(int p=2;p*p<=n;p++){
                if(primes[p]){
                    for(int i=p*p;i<=n;i+=p){
                        primes[i]=false;
                    }
                }
            }
            return primes;
        }

        public boolean isPrime(int n){
            if(n<=1)return true;

            for(int i=2;i*i<=n;i++){
                if(n%i==0)return false;
            }
            return true;
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
        // get All Factors/Divisors of N 
        public List<Long> getFactors(long n){
            List<Long> factor = new ArrayList<>();
            
            for(long i=1;i*i<=n;i++){
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
        // Count All Factors/Divisors of N 
        public long countFactors(long n){
            long cnt=0;

            for(long i=1;i*i<=n;i++){
                if(n%i==0){
                    cnt++;
                    if(i!=n/i)cnt++;
                }
            }
            return cnt;
        }


        public long fact(long n, long mod){
            long ans=1;
            for(long i=2;i<=n;i++){
                ans*=i;
                ans %=mod;
            }
            return ans;
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

        public String DtoB(long n){
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

    
    static class SegmentTree{
        public long segmentArr[];
        public int N;
        SegmentTree(int n){
            N=n;
            segmentArr=new long[4*n+1];
        }
    
        public void build(long arr[]){
            build(0,0,N-1,arr);
        }
        
    
        public long query(int l, int r){
            return query(0,0,N-1,l,r);
        }
    
        public void update(int i,long val){
            update(0,0,N-1,i,val);
        }
    
        public void build(int ind,int low, int high, long arr[]){
            if(low==high){
                segmentArr[ind]=arr[low];
                return;
            }
    
            int mid=(low+high)/2;
            build(2*ind+1,low,mid,arr);
            build(2*ind+2,mid+1,high,arr);
    
            segmentArr[ind]=segmentArr[2*ind+1]+segmentArr[2*ind+2];
        }
    
        public long query(int ind,int low, int high,int l, int r){
            // Complete Overlap [l   low   high   r]
            if(low>=l && high<=r)return segmentArr[ind];
    
            // No Overlap  [low   high  l   r]  || [l  r  low   high]
            if(r<low || l>high)return Integer.MIN_VALUE;
    
            // Partially overlap   [low  l  high   r]  || [l   low   r   high]
            int mid=low+(high-low)/2;
            long left=query(2*ind+1,low,mid,l,r);
            long right = query(2*ind+2,mid+1,high,l,r);
    
            return left+right;
        }
    
        public void update(int ind, int low, int high, int i, long val){
            if(low==high){
                segmentArr[ind]=val;
                return;
            }
    
            int mid=low+(high-low)/2;
    
            // Given pos in left
            if(i<=mid) update(2*ind+1, low, mid, i, val);
            // Given pos in right
            else update(2*ind+2, mid+1, high, i, val);
    
            // Update root after updating [2*ind+1] or [2*ind+2]
            segmentArr[ind]=segmentArr[2*ind+1]+segmentArr[2*ind+2];
        }
    
    }
    


}
