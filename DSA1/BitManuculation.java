class BitManuculation
{
    

    public static void oddeven(int n)
    {
        int bitMask =1;

        if((n & bitMask)==0)
        {
            System.out.println("even no");
        }
        else
        {
            System.out.println("odd no");
        }
    }

    public static int getIthBit(int n, int i)
    {
        int bitMask = 1<<i;

        if((n & bitMask)==0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    } 

    public static int setIthBit(int n , int i)
    {
        int bitMask = 1<<i;

        return n | bitMask;
    }


    public static int clearIthBit(int n,int i)
    {
        int bitMask = ~(1<<i);

        return n & bitMask;

    }

    public static int updateIthBit(int n,int i,int newBit)
    {
        if(newBit==0)
        {
            return clearIthBit(n,i);
        }
        else
        {
            return setIthBit(n,i);
        }
    }
    
    
    public static int clearIthLastBit(int n,int i)
    {
        int bitMask = (~0)<<i;

        return n & bitMask;

    }
    
    public static int clearRangeOfIthBits(int n,int i,int j)
    {
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;

        int bitMask = a|b;

        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n)
    {
        return (n & (n-1))==0;
    }

    public static int countSetBits(int n)
    {
        int count=0 ;

        while(n>0)
        {
                if((n & 1) != 0 )
                {
                    count ++;
                }
                n = n>>1;
        }
        return count ;
    }

    public static int fastExpo(int a,int n)
    {
        int ans =1;

        while(n>0)
        {
            if((n & 1)!=0)
            {
                ans = ans *a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }
    
    public static void main(String args[])
    {
        // code for odd or even by bit man..tion
       /* oddeven(3);
        oddeven(7);
        oddeven(4);
        */


       // code for to get ith bit
        /*  
        System.out.println(getIthBit(10,3));
        
        */

        //code for set ith bit

       // System.out.println(setIthBit(10,2));

        //code for clear ith bit

        //System.out.println(clearIthBit(10,1));

        //code for update ith bit

      //  System.out.println(updateIthBit(10,2,1));

        // code for clear ith last bits

        //System.out.println(clearIthLastBit(15,2));

        // code for clear range of bits

       // System.out.println(clearRangeOfIthBits(10,2,4));

        //code for checking no is power of 2 or not

       // System.out.println(isPowerOfTwo(16));

        // code to count set bits in a number

       // System.out.println(countSetBits(15));

        // code to fast exponentiation

       // System.out.println(fastExpo(4,2));

    }
}