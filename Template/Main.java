import java.io.*;
import java.util.*;

/**
 * @author [Monu Kumar]
 *         sc is used to take any type of input => int, long, intArray,
 *         longArray etc.
 *         out is used for print any thing => int, string, array and for all
 *         utility methods => seieve, factors, powMod, bits etc.
 *         Note: Use only out.print... methods for printing. Don't use
 *         System.out.print...
 */
public class Main {

    static void solve() {

    }

    static long[] preComputeArr;
    static void preCompute() {
        int n = out.E5 + 2;
        preComputeArr = new long[n];
        int curr = 1;
        for (int i = 0; i < n; i++) {
            preComputeArr[i] = curr ^ (curr - 1);
            ++curr;
        }
    }

    public static void main(String[] args) {
        // preCompute();
        int t = 1;
        t = sc.nextInt(); // comment this if not given number of test cases
        out.res.setLength(0);
        while (t-- > 0) {
            solve();
            out.nline();
        }
        System.out.print(out.res);
    }

    // Utility Object Initialization
    static Mix out = new Mix(); // For CP utility methods or print anything
    static Scanner sc = new Scanner(); // for input anything
    // static Graph graph = new Graph(); // for graph utility methods

    // Utility Object Declaration

    // static SegmentTree sg;
    // static LazySegmentTree sg;
    // static Dsu dsu;

    static class Pair {
        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair && ((Pair) obj).x == x && ((Pair) obj).y == y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

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

        int[] nextIntArray(int n) {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextLongArray(int n) {
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        double[] nextDoubleArray(int n) {
            double arr[] = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        char[] nextToCharArray() {
            return next().toCharArray();
        }

        char[] nextCharArray(int n) {
            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next().charAt(0);
            }
            return arr;
        }

        int[][] nextIntMatrix(int n, int m) {
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextInt();
                }
            }
            return arr;
        }

        long[][] nextLongMatrix(int n, int m) {
            long arr[][] = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextLong();
                }
            }
            return arr;
        }

        double[][] nextDobuleMatrix(int n, int m) {
            double arr[][] = new double[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextDouble();
                }
            }
            return arr;
        }

        char[][] nextCharMatrix(int n, int m) {
            char arr[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = next().charAt(0);
                }
            }
            return arr;
        }

        char[][] nextCharToMatrix(int n, int m) {
            char arr[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = next().toCharArray();
            }
            return arr;
        }

    }

    static class MultiSet<E> {
        private TreeMap<E, Long> map = new TreeMap<>();

        public MultiSet() {
            map = new TreeMap<>();
        }

        public MultiSet(Comparator<? super E> comparator) {
            map = new TreeMap<>(comparator);
        }

        public void add(E ele) {
            map.merge(ele, 1L, Long::sum);
        }

        public void remove(E ele) {
            if (!map.containsKey(ele))
                return;

            if (map.get(ele) == 1L)
                map.remove(ele);
            else
                map.merge(ele, -1L, Long::sum);
        }

        public E lower(E ele) {
            return map.lowerKey(ele);
        }

        public E ceiling(E ele) {
            return map.ceilingKey(ele);
        }

        public E floor(E ele) {
            return map.floorKey(ele);
        }

        public E higher(E ele) {
            return map.higherKey(ele);
        }

        public E first() {
            return map.firstKey();
        }

        public E last() {
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
            Map.Entry<E, ?> e = map.pollFirstEntry();
            return (e == null) ? null : e.getKey();
        }

        public E pollLast() {
            Map.Entry<E, ?> e = map.pollLastEntry();
            return (e == null) ? null : e.getKey();
        }

        @Override
        public String toString() {
            return map.toString();
        }
    }

    static class Mix {

        public int E5 = (int) 1e5;
        public int E6 = (int) 1e6;
        public long MOD = (long) 1e9 + 7;
        public StringBuilder res = new StringBuilder();

        /**
         * Use this for debugging
         * Pass any number of argument and any type of argument
         */
        public void debug(Object... obj) {
            System.out.println(Arrays.deepToString(obj));
        }

        // Print yes or no
        public void yes() {
            res.append("YES");
        }

        public void no() {
            res.append("NO");
        }

        // Print new line
        public void nline() {
            res.append("\n");
        }

        // Print element
        public void print(String x) {
            res.append(x);
        }

        public void print(int x) {
            res.append(x);
        }

        public void print(long x) {
            res.append(x);
        }

        public void print(char x) {
            res.append(x);
        }

        // Print element with new line
        public void println(String x) {
            res.append(x).append("\n");
        }

        public void println(int x) {
            res.append(x).append("\n");
        }

        public void println(long x) {
            res.append(x).append("\n");
        }

        public void println(char x) {
            res.append(x).append("\n");
        }

        // Print whole array or any number of argument with " " seprated
        public void print(int... arr) {
            for (int e : arr)
                res.append(e + " ");
        }

        public void print(long... arr) {
            for (long e : arr)
                res.append(e + " ");
        }

        // Print array from index l to r
        public void print(int l, int r, int[] arr) {
            while (l <= r)
                res.append(arr[l++] + " ");
        }

        public void print(int l, int r, long[] arr) {
            while (l <= r)
                res.append(arr[l++] + " ");
        }

        public void print(int l, int r, double[] arr) {
            while (l <= r)
                res.append(arr[l++] + " ");
        }

        // Get Max of any number of arguments or array.
        public int max(int... arr) {
            int max = Integer.MIN_VALUE;
            for (int e : arr)
                max = Math.max(max, e);
            return max;
        }

        public long max(long... arr) {
            long max = Long.MIN_VALUE;
            for (long e : arr)
                max = Math.max(max, e);
            return max;
        }

        // Get Min of any number of arguments or array.
        public int min(int... arr) {
            int min = Integer.MAX_VALUE;
            for (int e : arr)
                min = Math.min(min, e);
            return min;
        }

        public long min(long... arr) {
            long min = Long.MAX_VALUE;
            for (long e : arr)
                min = Math.min(min, e);
            return min;
        }

        // Get Sum of any number of arguments or array.
        public long sum(int... arr) {
            long sum = 0;
            for (int e : arr)
                sum += e;
            return sum;
        }

        public long sum(long... arr) {
            long sum = 0;
            for (long e : arr)
                sum += e;
            return sum;
        }

        // Get Prefix Array for 1-D array
        public long[] prefix(int[] arr) {
            int n = arr.length;
            long[] pre = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] + arr[i - 1];
            }
            return pre;
        }

        public long[][] prefix(int[][] arr, int n, int m) {
            long[][] pre = new long[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + arr[i - 1][j - 1] - pre[i - 1][j - 1];
                }
            }
            return pre;
        }

        public long prefixSum(int i, int j, int n, int m, long[][] prefix) {
            return prefixSum(i, j, n, m, prefix, true);
        }

        public long prefixSum(int i, int j, int n, int m, long[][] prefix, boolean zeroBased) {
            if (zeroBased) {
                ++i;
                ++j;
                ++n;
                ++m;
            }
            long topRight = prefix[i - 1][m], bottomLeft = prefix[n][j - 1], topLeft = prefix[i - 1][j - 1];
            return prefix[n][m] - topRight - bottomLeft + topLeft;
        }

        // Check given array is sorted or not from i to j
        public boolean isSorted(int arr[], int i, int j) {
            int n = arr.length;
            while (i != j) {
                if (arr[i % n] > arr[(i + 1) % n])
                    return false;
                i++;
                i %= n;
            }
            return true;
        }

        // Swap element in array
        public void swap(int i, int j, int[] arr) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }

        public void swap(int i, int j, long[] arr) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }

        // Reverse array from i to j
        public void reverse(int arr[], int i, int j) {
            while (i <= j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        public void reverse(char arr[], int i, int j) {
            while (i < j) {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        public void reverse(long arr[], int i, int j) {
            while (i < j) {
                long t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        public long reverse(long n) {
            long rev = 0;
            while (n > 0) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            return rev;
        }

        public int reverse(int n) {
            int rev = 0;
            while (n > 0) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            return rev;
        }

        // Check if its remainder when divided by 1 is 0
        public boolean isInteger(double n) {
            return n % 1 == 0;
        }

        public boolean isApproximatelyInteger(double number) {
            final double TOLERANCE = 1e-10; // Adjust tolerance as needed
            return Math.abs(number - Math.round(number)) < TOLERANCE;
        }

        // Check given is palindrompe or not
        public boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--))
                    return false;
            }
            return true;
        }

        public boolean isPalindrome(char s[], int i, int j) {
            while (i < j) {
                if (s[i++] != s[j--])
                    return false;
            }
            return true;
        }

        public boolean isPalidrompe(long n) {
            return n == reverse(n);
        }

        /**
         * Get all palindrome number till n.
         * Note : Number of Palindrompe up to n = 2*sqrt(n).
         * for n = 1e5, num of palindrompe is 632
         */
        public List<Long> getPalindrompeNumbers(long n) {
            List<Long> list = new ArrayList<>();
            for (long i = 0; i <= n; i++) {
                if (isPalidrompe(i))
                    list.add(i);
            }
            return list;
        }

        // Check given character is vowel or not
        public boolean isVowel(char c) {
            return "aeiouAEIOU".indexOf(c) != -1;
        }

        // Check given character is consonant or not
        public boolean isConsonant(char c) {
            return !isVowel(c);
        }

        // Check i, j are inside matrix or not
        public boolean isSafe(int i, int j, int n, int m) {
            return i >= 0 && i < n && j >= 0 & j < m;
        }

        // x + y with mod 1e9+7
        public long sumIntMod(long x, long y) {
            return (x % MOD + y % MOD) % MOD;
        }

        // x multiply y with mod 1e9+7
        public long mulIntMod(long x, long y) {
            return mulMod(x, y, MOD);
        }

        // x power y with mod 1e9+7
        public long powerIntMod(long x, long y) {
            return powerMod(x, y, MOD);
        }

        // Factorial of n with MOD 1e9+7
        public long factIntMOD(long n) {
            return factMOD(n, MOD);
        }

        // x muiltiply y with mod = (X*Y)%MOD
        public long mulMod(long x, long y, long mod) {
            return (x % mod * y % mod) % mod;
        }

        // x power y with mod = (X^Y)%MOD
        public int powerMod(int x, int y, int mod) {
            int res = 1;
            x = x % mod;
            if (x == 0)
                return 0;
            while (y > 0) {
                if ((y & 1) != 0)
                    res = (res * x) % mod;
                y = y >> 1;
                x = (x * x) % mod;
            }
            res %= mod;
            if (res < 0)
                res += mod;
            return res;
        }

        public long powerMod(long x, long y, long p) {
            long res = 1;
            x = x % p;
            if (x == 0)
                return 0;
            while (y > 0) {
                if ((y & 1) != 0)
                    res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            res %= p;
            if (res < 0)
                res += p;
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
        public long factMOD(long n, long mod) {
            if (n == 0)
                return 0;
            long ans = 1;
            for (long i = 2; i <= n; i++) {
                ans *= i;
                ans %= mod;
            }
            return ans;
        }

        // Log base 2 of n
        public double log2(double n) {
            return Math.log(n) / Math.log(2.0);
        }

        // Lower Bound - Smallest Index i a[i]>=x
        public int lowerBound(List<Integer> arr, int n, int x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr.get(m) >= x) {
                    h = m - 1;
                } else
                    l = m + 1;
            }
            return l;
        }

        public int lowerBound(List<Long> arr, int n, long x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr.get(m) >= x) {
                    h = m - 1;
                } else
                    l = m + 1;
            }
            return l;
        }

        public int lowerBound(int arr[], int n, int x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr[m] >= x) {
                    h = m - 1;
                } else
                    l = m + 1;
            }
            return l;
        }

        public int lowerBound(long arr[], int n, long x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr[m] >= x) {
                    h = m - 1;
                } else
                    l = m + 1;
            }
            return l;
        }

        public int lowerBound(double arr[], int n, double x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr[m] >= x) {
                    h = m - 1;
                } else
                    l = m + 1;
            }
            return l;
        }

        // Upper Bound - Largest Index i a[i]<=x
        public int upperBound(List<Integer> arr, int n, int x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr.get(m) <= x) {
                    l = m + 1;
                } else
                    h = m - 1;
            }
            return h;
        }

        public int upperBound(int arr[], int n, int x) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (arr[m] <= x) {
                    l = m + 1;
                } else
                    h = m - 1;
            }
            return h;
        }

        // Sieve of Eratosthenes
        // TC - N(log(logN)) -> ~O(N)
        public boolean[] sieve(int n) {
            boolean primes[] = new boolean[n + 1];

            // Mark all primes true
            for (int i = 2; i <= n; i++)
                primes[i] = true;

            // Mark false for multiple of primes
            for (int p = 2; p * p <= n; p++) {
                if (primes[p]) {
                    for (int i = p * p; i <= n; i += p) {
                        primes[i] = false;
                    }
                }
            }
            return primes;
        }

        // Check For Prime
        public boolean isPrime(int n) {
            if (n <= 1)
                return true;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }

        // Calulate gcd of a,b
        public int gcd(int a, int b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }

        public long gcd(long a, long b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }

        // Get all factors/divisors of N
        public List<Integer> getFactors(int n) {
            List<Integer> factor = new ArrayList<>();

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    factor.add(i);
                    if (i != n / i)
                        factor.add(n / i);
                }
            }
            return factor;
        }

        public List<Long> getFactors(long n) {
            List<Long> factor = new ArrayList<>();

            for (long i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    factor.add(i);
                    if (i != n / i)
                        factor.add(n / i);
                }
            }
            return factor;
        }

        // Count all factors/divisors of N
        public int countFactors(int n) {
            int cnt = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    cnt++;
                    if (i != n / i)
                        cnt++;
                }
            }
            return cnt;
        }

        public long countFactors(long n) {
            long cnt = 0;

            for (long i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    cnt++;
                    if (i != n / i)
                        cnt++;
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
            if (n > 2)
                map.merge(n, 1, Integer::sum);
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
            List<Integer> list = new ArrayList<>();
            boolean[] primes = sieve(n);
            for (int i = 0; i < n; i++) {
                if (!primes[i])
                    list.add(i);
            }
            return list;
        }

        // Decimal to binary
        public String DtoB(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append(n % 2);
                n >>= 1;
            }
            return sb.reverse().toString();
        }

        public String DtoB(long n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append(n % 2);
                n >>= 1;
            }
            return sb.reverse().toString();
        }

        // Binary to Decimal
        public int BtoD(String s) {
            int n = 0, k = s.length() - 1;
            for (char c : s.toCharArray()) {
                if (c == '1')
                    n += 1 << k;
                k--;
            }
            return n;
        }

        // Check ith bit is set or not
        public boolean isBitSet(int n, int i) {
            return (n & (1 << i)) != 0;
        }

        // Check N is power of 2
        public boolean isPowerOf2(int n) {
            return (n & (n - 1)) == 0;
        }

        public boolean isPowerOf2(long n) {
            return (n & (n - 1)) == 0;
        }

        // Check N is power of 4 or not
        public boolean isPowerOf4(int n) {
            return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
        }

        // Count Set bit in N | TC - O(no. of set bits)
        public int cntSetBit(int n) {
            int cnt = 0;
            while (n > 0) {
                n = n & (n - 1);
                cnt++;
            }
            return cnt;
        }

        // Check all bits are set in given num | 7-> 111
        public boolean allBitSet(int n) {
            return (n & (n + 1)) == 0;
        }

        // Check bits in num having in alternative form | 101010 | 010101
        public boolean isAlternativeBit(int n) {
            // 101010 ^ 010101 (n>>1) = 111111
            return allBitSet(n ^ (n >> 1));
        }

        // Unset Left most set bit 0101100 -> 0001100
        public long unsetLSB(long n) {
            return n & -n;
        }

        // Unset right most set bit 1101100 -> 1101000
        public long unsetRSB(long n) {
            return n & ~(n ^ (n - 1));
        }
    }

    /**
     * Segement Tree Template
     * Get Sum in range.
     */
    static class SegmentTree {
        public long segmentArr[];
        public int N;

        SegmentTree(int n) {
            N = n;
            segmentArr = new long[4 * n + 1];
        }

        public void build(long arr[]) {
            build(0, 0, N - 1, arr);
        }

        public long query(int l, int r) {
            return query(0, 0, N - 1, l, r);
        }

        public void update(int i, long val) {
            update(0, 0, N - 1, i, val);
        }

        public void build(int ind, int low, int high, long arr[]) {
            if (low == high) {
                segmentArr[ind] = arr[low];
                return;
            }

            int mid = (low + high) / 2;
            build(2 * ind + 1, low, mid, arr);
            build(2 * ind + 2, mid + 1, high, arr);

            segmentArr[ind] = segmentArr[2 * ind + 1] + segmentArr[2 * ind + 2];
        }

        public long query(int ind, int low, int high, int l, int r) {
            // Complete Overlap [l low high r]
            if (low >= l && high <= r)
                return segmentArr[ind];

            // No Overlap [low high l r] || [l r low high]
            if (r < low || l > high)
                return 0;

            // Partially overlap [low l high r] || [l low r high]
            int mid = low + (high - low) / 2;
            long left = query(2 * ind + 1, low, mid, l, r);
            long right = query(2 * ind + 2, mid + 1, high, l, r);

            return left + right;
        }

        public void update(int ind, int low, int high, int i, long val) {
            if (low == high) {
                segmentArr[ind] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            // Given pos in left
            if (i <= mid)
                update(2 * ind + 1, low, mid, i, val);
            // Given pos in right
            else
                update(2 * ind + 2, mid + 1, high, i, val);

            // Update root after updating [2*ind+1] or [2*ind+2]
            segmentArr[ind] = segmentArr[2 * ind + 1] + segmentArr[2 * ind + 2];
        }
    }

    /**
     * Segment Tree with Lazy propogation Template
     * Get Sum in range.
     */
    static class LazySegmentTree {
        long segArr[], lazy[];
        int N;

        LazySegmentTree(int n) {
            N = n;
            segArr = new long[4 * n + 1];
            lazy = new long[4 * n + 1];
        }

        void build(long arr[]) {
            build(0, 0, N - 1, arr);
        }

        void build(int ind, int low, int high, long arr[]) {
            if (low == high) {
                segArr[ind] = arr[low];
                return;
            }
            int mid = low + (high - low) / 2;

            build(2 * ind + 1, low, mid, arr);
            build(2 * ind + 2, mid + 1, high, arr);

            segArr[ind] = segArr[2 * ind + 1] + segArr[2 * ind + 2];
        }

        void update(int l, int r, long val) {
            update(0, 0, N - 1, l, r, val);
        }

        void update(int ind, int low, int high, int l, int r, long val) {
            // If previous Updates remaining updates those
            if (lazy[ind] != 0) {
                int nodes = high - low + 1;
                segArr[ind] += nodes * lazy[ind];

                // Propogate Down if down exist
                if (low != high) {
                    lazy[2 * ind + 1] = lazy[ind];
                    lazy[2 * ind + 2] = lazy[ind];
                }

                lazy[ind] = 0;
            }
            // No OverLap - [low high l h] | [l h low high]
            if (l > high || r < low)
                return;

            // Completely OverLap [l low high h]
            if (low >= l && high <= r) {
                int nodes = high - low + 1;
                segArr[ind] += nodes * val;

                // Propogate Down if down exist
                if (low != high) {
                    lazy[2 * ind + 1] = val;
                    lazy[2 * ind + 2] = val;
                }
                return;
            }

            int mid = low + (high - low) / 2;

            update(2 * ind + 1, low, mid, l, r, val);
            update(2 * ind + 2, mid + 1, high, l, r, val);

            segArr[ind] = segArr[2 * ind + 1] + segArr[2 * ind + 2];
        }

        long query(int l, int r) {
            return query(0, 0, N - 1, l, r);
        }

        long query(int ind, int low, int high, int l, int r) {
            // If previous Updates remaining updates those
            if (lazy[ind] != 0) {
                int nodes = high - low + 1;
                segArr[ind] += nodes * lazy[ind];

                // Propogate Down if down exist
                if (low != high) {
                    lazy[2 * ind + 1] = lazy[ind];
                    lazy[2 * ind + 2] = lazy[ind];
                }

                lazy[ind] = 0;
            }

            // No Overlap
            if (high < l || low > r)
                return 0;

            // Completely overlap
            if (low >= l && high <= r) {
                return segArr[ind];
            }

            // Partialy overlap
            int mid = low + (high - low) / 2;

            long left = query(2 * ind + 1, low, mid, l, r);
            long right = query(2 * ind + 2, mid + 1, high, l, r);
            return left + right;
        }
    }

    /**
     * Disjoint Set Union
     */
    static class Dsu {
        int size[], par[];

        Dsu(int n) {
            size = new int[n + 1];
            par = new int[n + 1];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        // find uplimate parrent - root/boss
        int find(int u) {
            if (u == par[u])
                return u;
            return par[u] = find(par[u]);
        }

        void union(int u, int v) {
            int upu = find(u), upv = find(v);
            if (upu == upv)
                return;

            if (size[upu] > size[upv]) {
                par[upv] = upu;
                size[upu] += size[upv];
            } else {
                par[upu] = upv;
                size[upv] += size[upu];
            }
        }
    }

    /**
     * Graph Utility methods = dijkstra, build adjency list from edges
     */
    static class Graph {
        // Build Adjancey List From edges
        List<List<Integer>> buildAdjancey(int edges[][], int n) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                adj.add(new ArrayList<>());

            for (int e[] : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }

            return adj;
        }

        // Build Adjancey List From edges with cost/weight
        List<List<int[]>> buildAdjanceyWithCost(int edges[][], int n) {
            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                adj.add(new ArrayList<>());

            for (int e[] : edges) {
                adj.get(e[0]).add(new int[] { e[1], e[2] });
                adj.get(e[1]).add(new int[] { e[0], e[2] });
            }

            return adj;
        }

        // src to dest shortest path
        int dijkstra(int src, int dest, List<List<int[]>> adj, int n) {
            int dis[] = new int[n];
            Arrays.fill(dis, (int) 1e9);

            Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[] { src, 0 });
            dis[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.peek()[0], cost = pq.poll()[1];

                if (u == dest)
                    return cost;

                for (int p[] : adj.get(u)) {
                    int v = p[0], currCost = p[1];

                    if (dis[v] > dis[u] + currCost) {
                        dis[v] = dis[u] + currCost;
                        pq.add(new int[] { v, dis[v] });
                    }
                }
            }
            return -1;
        }

        // src to dest shortest path with at max using k edges
        int dijkstra(int src, int dest, int k, List<List<int[]>> adj, int n) {
            int dis[] = new int[n];
            Arrays.fill(dis, (int) 1e9);

            Queue<int[]> pq = new LinkedList<>();
            pq.add(new int[] { src, k, 0 });
            dis[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.peek()[0], kk = pq.poll()[1];

                if (kk == 0)
                    continue;

                for (int p[] : adj.get(u)) {
                    int v = p[0], currCost = p[1];

                    if (kk > 0 && dis[v] > dis[u] + currCost) {
                        dis[v] = dis[u] + currCost;
                        pq.add(new int[] { v, kk - 1 });
                    }
                }
            }
            return dis[dest] == (int) 1e9 ? -1 : dis[dest];
        }

        // get src to all dest shortest path array
        int[] dijkstra(int src, List<List<int[]>> adj, int n) {
            int dis[] = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);

            Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.add(new int[] { 0, src });
            dis[src] = 0;

            while (!pq.isEmpty()) {
                int cost = pq.peek()[0];
                int u = pq.poll()[1];

                if (cost > dis[u])
                    continue;

                for (int p[] : adj.get(u)) {
                    int v = p[0], currCost = p[1];

                    if (dis[v] > dis[u] + currCost) {
                        dis[v] = dis[u] + currCost;
                        pq.add(new int[] { dis[v], v });
                    }
                }
            }
            return dis;
        }
    }
}
