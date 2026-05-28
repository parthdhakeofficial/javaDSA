import java.util.*;


class LinearSearch
{


    public static int linearSearch(int num[],int key)
    {

        for(int i=0;i<num.length;i++)
        {
            if(num[i]==key)
            {
                return i;
            }
        }

        return -1;

    }

    public static int getLargest(int numbers[])
    {
        int largest = Integer.MIN_VALUE;
        //here int largest = -Infinity

        int smallest = Integer.MAX_VALUE;
        //here int smallest = +Infinity

        for(int i =0;i< numbers.length;i++)
        {
            if (largest<numbers[i])
            {
                largest=numbers[i];
            }

            if(smallest>numbers[i])
            {
                smallest=numbers[i];
            }
        }

        //a function can only return one alue at a time

        System.out.println("smallest value is"+smallest);    
    
        return largest;
        
    }

    public static void main(String args[])
    {

        int numbers[]={1,2,6,3,5};

        System.out.println("largest no is"+getLargest(numbers));

        int num[]={2,4,6,8,10,12,14,16};
        int key=10;

        int index= linearSearch(num,key);
        if(index==-1)
        {
            System.out.println("index not found");
        }
        else
        {
            System.out.println("index of key is"+index);
        }


    }


}