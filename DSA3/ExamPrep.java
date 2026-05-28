import java.util.*;
class ExamPrep
{

    
   /*public static void findMaxMin(int arr[])
    {
        int max=arr[0];
        int min=arr[0];
<
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }

            if(arr[i]<min)
            {
                min=arr[i];
            }
        }

        System.out.println("Maximum is"+ max+"and Minimum is"+min);
    }
*/


    public static void main(String args[])
    {
       /* int arr[]={13,4,2,5,9};

        findMaxMin();

        //ispanlindrome*/

        Scanner sc= new Scanner(System.in);
        System.out.println("enter n");

        int n=sc.nextInt();

        if(isPanlindrome(n))
        {
            System.out.println(n +"is palindrome");
        }
        else
        {
            System.out.println(n +"is not palindrome");
        }
    }


    public static boolean isPanlindrome(int n)
    {
        int on=n;
        int rn=0;

        while(n>0)
        {
            int lastdigit=n%10;

            rn= rn*10+lastdigit;

            n/=10;//    n=n/10
        }
        return on==rn;
    }








}