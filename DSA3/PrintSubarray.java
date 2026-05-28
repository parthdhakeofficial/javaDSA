class PrintSubarray
{


    public static void subarray(int a[])
    {
        int ts=0;
        int sum=0;
        
        for(int i=0;i<a.length;i++)
        {
            int start=i;
            for(int j=i;j<a.length;j++)
            {
                int end=j;
                for(int k=start;k<=end;k++)
                {
                    System.out.print(a[k]+" ");
                  
                }
                System.out.println();
                ts++;
                 sum= start+end+k;
            }
            System.out.println();
             
        }
        
     System.out.println("total subarrays:"+ts);
        
    }
    public static void main(String args[])
    {
        int a[]={2,4,6,8,10};

        subarray(a);
       
    }
}