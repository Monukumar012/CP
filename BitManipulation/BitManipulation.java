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

    // is N is power of 2
    public boolean isPowerOf2(int n){
        return (n&(n-1))==0;
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
}



// for test
class Main {
    public static void main(String[] args) {
        BitManipulation ob=new BitManipulation();
        int n=16;
        System.out.println(ob.BtoD(ob.DtoB(n)));
    
    }
    
}