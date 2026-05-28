import java.util.*;       // it import all packagr in java
import java.util.Arrays; //import package for arrays


class Sorting
{

    public static void bubbleSort(int arr[])
    {
        int n=arr.length;

        for(int turn=0;turn<n-1;turn++)
        {
            for(int e=0; e<n-1-turn;e++)       
             //here e is elements
                {
                    if(arr[e]>arr[e+1])
                    {
                        int temp= arr[e];
                        arr[e]=arr[e+1];
                        arr[e+1]=temp;
                    }
                }
        }
    }

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void selectionSort(int arr[])
    {

        for (int turn=0;turn<arr.length-1;turn++)
        {
            int minPos=turn;
            for(int e=turn+1;e<arr.length;e++)
            {
                if(arr[minPos]>arr[e])                 // to make it decesding change the condition to <
                {
                    minPos=e;   
                }
            }
            //swap
            int temp =arr[minPos];
            arr[minPos]=arr[turn];
            arr[turn]=temp;
        }
    }


    public static void insertionSort(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int curr=arr[i];
            int prev=i-1;
            //finding out correct positon to insert
            while(prev >=0 && arr[prev]>curr)   //for desending change arr[prev]<arr[curr]
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }


    public static void countingSort(int arr[])
    {
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            largest=Math.max(largest,arr[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }

        //soeting
        int j=0;
        for(int i=0 ;i<count.length;i++)
        {
            while(count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }


    public static void main(String args[])
    {
        int arr[]={5,4,1,3,2,};
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //Arrays.sort(arr);     //for in built sort dataype should be Integer and import import java.util.Arrays;
        //Arrays.sort(arr,si,ei) //arrays(nameOfArray.startIndex,endIndex)
        //Arrays.sort(arr,Collectionsofreverse)   //import java.util.Collections
        countingSort(arr);
        printarr(arr);
    }        
}