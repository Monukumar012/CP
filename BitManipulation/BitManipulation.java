class BitManipulation{

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


    //Swap two Numbers
    public void swap(int a, int b){
        a=a^b; b=a^b; a=a^b;
    }

    // 1 to N XOR - TC - O(1)
    public int Xor1toN(int n){
        int rem=n%4;
        if(rem==0)return n;
        else if(rem==1)return 1;
        else if(rem==2)return n+1;
        else return 0;
    }

    // L to R XOR - TC - O(1)
    public int XorLtoR(int l, int r){
        return Xor1toN(r)^Xor1toN(l-1);
    }


    // Check ith bit is set or not
    public boolean isBitSet(int n,int i){
        return (n&(1<<i))!=0;
    }

    // Set ith bit in n
    public void setIthBit(int n,int i){
        n |= (1<<i);
    }

    // Clear ith bit in n
    public void unSetIthBit(int n,int i){
        n &= ~(1<<i);
    }

    // clear/unset last set bit in n
    public void unSetLastSetBit(int n){
        n &= (n-1);
    }

    // Flip ith bit in n
    public void flipIthBit(int n, int i){
        n ^=(1<<i);
    }

    // Check N is power of 2
    public boolean isPowerOf2(int n){
        return (n&(n-1))==0;
    }


    // Check N is power of 4 or not
    public boolean isPowerOf4(int n) {
        // long poOf4=1;
        // while(poOf4<=n){
        //     if(poOf4==n)return true;
        //     poOf4<<=2L;
        // }
        // return false;

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

    // It gives complement of given n | 10-> 1010 = 0101->5
    public int findComplement(int n) {
        // Integer.highestOneBit return num in which LSB bit is set | 1111 -> 8(1000)
        return ~n & (Integer.highestOneBit(n)-1);
    }
}



// for test
class Main {
    public static void main(String[] args) {
        BitManipulation ob=new BitManipulation();
        int n=16;
        System.out.println(ob.BtoD(ob.DtoB(n)));
    
    }
    
}