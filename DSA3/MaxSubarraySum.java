class MaxSubarraySum
{   

    public static void maxSubarraySum(int a[])
    {
        int currentsum=0;
        int maxsum=Integer.MIN_VALUE;
        
        for(int i=0;i<a.length;i++)
        {
            int start=i;
            for(int j=i;j<a.length;j++)
            {
                int end=j;
                currentsum = 0;
                for(int k=start;k<=end;k++)
                {
                    currentsum +=a[k];                 
                }
                System.out.println(currentsum);
                
                if (maxsum<currentsum)
                 {
                    maxsum=currentsum;
                 }
            }
            
             
        }
        
     System.out.println("max sum:"+maxsum);
        
    }
    public static void main(String args[])
    {
        int a[]={1,-2,6,-1,3};

        maxSubarraySum(a);
       
    }
}

