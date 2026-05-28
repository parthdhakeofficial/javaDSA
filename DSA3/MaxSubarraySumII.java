class MaxSubarraySumII
{   

    public static void maxSubarraySum(int a[])
    {
        int currentsum=0;
        int maxsum=Integer.MIN_VALUE;
        int prefix[] =new int[a.length];

        prefix[0]=a[0]; 
        
        for(int p=1;p<a.length;p++)
        {
            prefix[p]=prefix[p-1]+a[p];
        }


        for(int i=0;i<a.length;i++)
        {
            int start=i;
            for(int j=i;j<a.length;j++)
            {
                int end=j;


                currentsum = start ==0? prefix[end]:prefix[start-1];
                
                System.out.println(currentsum);
                
                if (maxsum<currentsum)
                 {
                    maxsum=currentsum;
                 }
            }
            
             
        }
        
     System.out.println("max sum:"+maxsum);
        
    }

    public static void kadanes(int a[])
    {

        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0;i<a.length;i++)
        {
            cs=cs+a[i];
            if(cs<0)
            {
                cs=0;
            }

            ms = Math.max(cs,ms);  //it is inbuilt function in java to find max no
        }
            
            System.out.println("max no is:"+ms);
    }



    public static void main(String args[])
    {
        int a[]={-2,-3,4,-1,-2,1,5,-3};

        kadanes(a);
       
    }
}

