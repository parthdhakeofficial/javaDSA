import java.util.*;

class BinarySearch
{

    public static int binarySearch(int a[],int key)
    {
        int start=0;
        int end=a.length-1;

        while(start<=end)
        {
            int mid = (start + end)/2;

            if(a[mid]==key) //found case
            {
                return mid;
            }

            if(a[mid]>key) // left case
            {
                end=mid-1;
            }
            else     //right case
            {
                start=mid+1;
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        int a[]={2,4,6,8,10,12,14};
        int key =10;

        System.out.println("index of key is "+binarySearch(a,key));

    }

}