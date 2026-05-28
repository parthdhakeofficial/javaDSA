import java.util.*;

class DP
{

    //define DP
    /**dp is a technique in computer programming in which that helps
    * efficiently solve a class of problems that have overlapping subproblems
    * and optimal substructure property.
    */

    //fibo series
    //memoization -> top down
    public static int fib(int n,int f[])
    {
        if(n==0||n==1)
        {
            return n;
        }

        if(f[n]!=0)
        {
            return f[n];
        }

        f[n]=fib(n-1,f)+fib(n-2,f);
        return f[n];

    }

    //tabulation ->bottom up
    public static int fibTabulation(int n)
    {
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    //climing chairs 
    //recurrsion-(2^n) & //memoizaton-o(n)
    public static int countWays(int n,int ways[])
    {
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }

        if(ways[n]!=-1)
        {//already calculated
            return ways[n];
        }

        ways[n]=countWays(n-1,ways)+countWays(n-2,ways);

        return ways[n];
    }

    public static int countWaysTab(int n)
    {
        int dp[]= new int[n+1];
        dp[0]=1;

        //tabulation
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                dp[i]=dp[i-1]+0;
            }
            else
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
            
        }
        return dp[n];

    }



    public static void main(String args[])
    {
        int n=5;
        //int f[]=new int [n+1];
        //System.out.println(fin(n,f));
        //System.out.println(fibTabulation(n));


        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);   //funn in array to store value 
        //this added while doing memoization
        System.out.println(countWays(n,ways));
        //int n=5//n=3->3&n=4->5=>8
        System.out.println(countWaysTab(n));
        
        
    }
}