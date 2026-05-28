class DP6
{
    //multiplication of matries
    public static int mcm (int arr[],int i,int j)
    {
        if(j==j)
        {
            return 0; //single matrix case
        }

        int ans=Integer.MAX_Value;

        for(int k=i;k<=j-1;k++)
        {
            int cost1 = mcm(arr,i,k); //Ai...Ak=>arr[i-1]Xarr[k]
            int cost2 = mcm(arr,i+1,j);//Ai+1...Aj=>arr[k]Xarr[j]
            int cost3 = arr(i-1)*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;
            ans = Math.min(ans,finalCost);
        
        }

        return ans;
    }

    public static void main(String args[]){
        int arr[]={1,2,3,4,3};//n=5
        int n=arr.length;

        System.out.println(mcm(arr,1,n-1));
    }
}