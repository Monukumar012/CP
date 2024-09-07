import java.io.*;
import java.util.*;

/**
 *  @author [Monu Kumar]
 * sc is used to take any type of input => int, long, intArray, longArray etc.
 * out is used for print any thing => int, string, array and for all utility methods => seieve, factors, powMod, bits etc.
 * Note: Use only out.print... methods for printing. Don't use System.out.print...
 */
public class Main{
    static void solve(){
    // Sample Code
        int n=sc.nextInt();
        int[] arr=sc.nextIntArray();
        out.print("Your Output");
    }

    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt(); // comment this if not given number of test cases
        out.res.setLength(0);
        while(t-->0){
            solve();
            out.nline();
        }
        System.out.print(out.res);
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


    static class MultiSet<E>{
        private TreeMap<E, Long> map=new TreeMap<>();

        public MultiSet() {
            map=new TreeMap<>();
        }
    
        public MultiSet(Comparator<? super E> comparator) {
            map=new TreeMap<>(comparator);
        }

        public void add(E ele){
            map.merge(ele, 1L, Long::sum);
        }

        public void remove(E ele){
            if(!map.containsKey(ele))return;

            if(map.get(ele)==1L)map.remove(ele);
            else map.merge(ele, -1L, Long::sum);
        }

        public E lower(E ele){
            return map.lowerKey(ele);
        }

        public E ceiling(E ele){
            return map.ceilingKey(ele);
        }

        public E floor(E ele){
            return map.floorKey(ele);
        }

        public E higher(E ele){
            return map.higherKey(ele);
        }

        public E first(){
            return map.firstKey();
        }

        public E last(){
            return map.lastKey();
        }
        public int size() {
            return map.size();
        }
    
        public boolean isEmpty() {
            return map.isEmpty();
        }

        public boolean contains(Object o) {
            return map.containsKey(o);
        }
        public void clear() {
            map.clear();
        }

        public E pollFirst() {
            Map.Entry<E,?> e = map.pollFirstEntry();
            return (e == null) ? null : e.getKey();
        }

        public E pollLast() {
            Map.Entry<E,?> e = map.pollLastEntry();
            return (e == null) ? null : e.getKey();
        }

        @Override
        public String toString() {
            return map.toString();
        }
    }

    static class Mix{

        public long MOD=(long)1e9+7;
        public StringBuilder res=new StringBuilder();

    /**
     * Use this for debugging
     * Pass any number of argument and any type of argument
     */
        public void debug(Object...obj) {
            System.out.println(Arrays.deepToString(obj));
        }
    
    // Print yes or no
        public void yes(){
            res.append("YES");
        }
        public void no(){
            res.append("NO");
        }
    // Print new line
        public void nline(){
            res.append("\n");
        }
    // Print element
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
    // Print element with new line
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
    // Print whole array or any number of argument with " " seprated
        public void print(int...arr){
            for(int e: arr)res.append(e+" ");
        }
        public void print(long...arr){
            for(long e: arr)res.append(e+" ");
        }
    // Print array from index l to r
        public void print(int l, int r, int []arr){
            while(l<=r)res.append(arr[l++]+" ");
        }

        public void print(int l, int r, long []arr){
            while(l<=r)res.append(arr[l++]+" ");
        }

        public void print(int l, int r, double []arr){
            while(l<=r)res.append(arr[l++]+" ");
        }

    // Get Max of any number of arguments or array.
        public int max(int...arr) {
            int max=Integer.MIN_VALUE;
            for(int e:arr)max=Math.max(max,e);
            return max;
        }

        public long max(long...arr) {
            long max=Long.MIN_VALUE;
            for(long e:arr)max=Math.max(max,e);
            return max;
        }

    // Get Min of any number of arguments or array.
        public int min(int...arr){
            int min = Integer.MAX_VALUE;
            for(int e: arr)min=Math.min(min,e);
            return min;
        }
        public long min(long...arr){
            long min = Long.MAX_VALUE;
            for(long e: arr)min=Math.min(min,e);
            return min;
        }

    // Get Sum of any number of arguments or array.
        public long sum(int...arr){
            long sum=0;
            for(int e:arr)sum+=e;
            return sum;
        }
        public long sum(long...arr){
            long sum=0;
            for(long e:arr)sum+=e;
            return sum;
        }

    // Check given array is sorted or not from i to j
        public boolean isSorted(int arr[], int i ,int j){
            int n=arr.length;
            while(i!=j){
                if(arr[i%n]>arr[(i+1)%n])return false;
                i++;i%=n;
            }
            return true;
        }

    // Swap element in array
        public void swap(int i, int j, int[] arr) {
            arr[i] ^=arr[j];
            arr[j] ^=arr[i];
            arr[i] ^=arr[j];
        }
        public void swap(int i, int j, long[] arr) {
            arr[i] ^=arr[j];
            arr[j] ^=arr[i];
            arr[i] ^=arr[j];
        }
    // Reverse array from i to j
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
        public long reverse(long n){
            long rev=0;
            while(n>0){
                rev=rev*10+n%10;
                n/=10;
            }
            return rev;
        }
        public int reverse(int n){
            int rev=0;
            while(n>0){
                rev=rev*10+n%10;
                n/=10;
            }
            return rev;
        }
    // Check given is palindrompe or not
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
        public boolean isPalidrompe(long n) {
            return n==reverse(n);
        }
    /**
     * Get all palindrome number till n. 
     * Note : Number of Palindrompe up to n = 2*sqrt(n).
     * for n = 1e5, num of palindrompe is 632
    */
        public List<Long> getPalindrompeNumbers(long n) {
            List<Long> list=new ArrayList<>();
            for(long i=0;i<=n;i++){
                if(isPalidrompe(i))list.add(i);
            }
            return list;
        }
    // Check given character is vowel or not
        public boolean isVowel(char c){
            return "aeiouAEIOU".indexOf(c)!=-1;
        }
    // Check given character is consonant or not
        public boolean isConsonant(char c){
            return !isVowel(c);
        }
    // Check i, j are inside matrix or not
        public boolean isSafe(int i, int j, int n, int m){
            return i>=0 && i<n && j>=0 & j<m;
        }
    // x + y with mod 1e9+7
        public long sumIntMod(long x, long y){
            return (x%MOD+y%MOD)%MOD;
        }
    // x multiply y with mod 1e9+7
        public long mulIntMod(long x, long y){
            return mulMod(x, y, MOD);
        }
    // x power y with mod 1e9+7
        public long powerIntMod(long x, long y){
            return powerMod(x, y, MOD);
        }
    // Factorial of n with MOD 1e9+7
        public long factIntMOD(long n){
            return factMOD(n, MOD);
        }
    // x muiltiply y with mod = (X*Y)%MOD
        public long mulMod(long x, long y, long mod){
            return (x%mod*y%mod)%mod;
        }
    // x power y with mod = (X^Y)%MOD
        public int powerMod(int x, int y, int mod){
            int res = 1;
            x = x % mod;
            if (x == 0)return 0;
            while (y > 0){
                if((y & 1) != 0) res = (res * x) % mod;
                y = y >> 1;
                x = (x * x) % mod;
            }
            res %=mod;
            if(res<0)res+=mod;
            return res;
        }
        public long powerMod(long x, long y, long p){
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
    // x power y = (X^Y)
        public long power(int N, int K) {
            long result = 1;
            for (int i = 0; i < K; i++) {
                result *= N;
            }
            return result;
        }
    // Factorial of n with MOD
        public long factMOD(long n, long mod){
            if(n==0)return 0;
            long ans=1;
            for(long i=2;i<=n;i++){
                ans*=i;
                ans %=mod;
            }
            return ans;
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
        public int lowerBound(long arr[], int n, long x){
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
        public int lowerBound(double arr[], int n, double x){
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
    // Sieve of Eratosthenes
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
    // Check For Prime
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
    // Get all factors/divisors of N 
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
    // Count all factors/divisors of N 
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
    // Get All Prime factors of n with their frequency
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

    // Calculate total number of factors of any number from their primeFatorization
        public long calculateTotalNumberOfFactors(Map<Long, Integer> primeFactors) {
            long totalFactors = 1;
            for (int exponent : primeFactors.values())
                totalFactors *= (exponent + 1);
            return totalFactors;
        }

    // Calculate total number of factors of any number n
        public long calculateTotalNumberOfFactors(long n) {
            Map<Long, Integer> primeFactors = primeFactorization(n);
            return calculateTotalNumberOfFactors(primeFactors);
        }

    // Get all composite numbers till n
        public List<Integer> getCompositeNumbers(int n) {
            List<Integer> list=new ArrayList<>();
            boolean[] primes=sieve(n);
            for(int i=0;i<n;i++){
                if(!primes[i])
                    list.add(i);
            }
            return list;
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
    // Unset Left most set bit 0101100 -> 0001100
        public long unsetLSB(long n) {
            return n & -n;
        }
    // Unset right most set bit 1101100 -> 1101000
        public long unsetRSB(long n){
            return n&~(n^(n-1));
        }
    }

/**
 * Segement Tree Template 
 * Get Sum in range.
 */
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
            if(r<low || l>high)return 0;
    
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
