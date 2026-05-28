class BinomialCoeffient
{


    public static int factorial (int num)
    {
        int f=1;

        for(int i=1;i<=num;i++)
        {
            f=f*i;
        }
            return f;
    }
    
    
    public static int binoco(int n, int r)
    {
        int fact_n= factorial(n);
        int fact_r= factorial(r);
        int fact_nmr = factorial(n-r);  // here m is for minus

        int binoco= fact_n / (fact_r * fact_nmr) ;
 
        return binoco;
    }


    public static void main(String args[])
    {
            System.out.println(binoco(5,2));
    }   



}