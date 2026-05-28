class DividenConquer
{
    public static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /* mid=(si+ei)/2;
        OR mid=si+(ei-si)/2;
        */

       //Merge Sort
       public static void mergeSort(int arr[],int si, int ei)
       {    
            //base case
            if(si>=ei)
            {
                return;
            }

            //work
            int mid= (si+ei)/2;
            //left part
            mergeSort(arr, si, mid);
            //right part
            mergeSort(arr, mid+1, ei);

            //merge
            merge(arr,si,mid,ei);

       }

       public static void merge(int arr[],int si,int mid,int ei)
       {
        //if original array is size 6 then its si=0 and ei=5
        //.: 6=5-0+1;   ->    size=ei-si+1;
        //we add 1 due to 0_based index system
        int temp[]=new int[ei-si+1];
        
        //iterator for left part
        int i = si; //i=si i.e 0 bcoz loop si to mid
        //iterator for right part
        int j=mid+1;  //j=mid+1 i.e. 4 bcoz loop mid+1 to ei
        //iterator for temp array
        int k=0;    //k=si of temp[]

    //loop compares,sortes and merges array
        while(i<=mid && j<=ei)
        {
            if(arr[i]<arr[j])
            {
                temp[k]=arr[i];
                i++;
                k++;
            }
            else//(arr[j]<arr[i])
            {
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

        //if elements remain single

        //left part
        while(i<=mid)
        {
            temp[k++]=arr[i++];
            //temp[k]=arr[i];
            //k++;i++;
        }

        //right part
        while(j<=ei)
        {
            temp[k++]=arr[j++];
            //temp[k]=arr[j];
            //k++;j++;
        }

        //copy temp array to original array
        for(k=0,i=si;k<temp.length;k++,i++)
        {
            arr[i]=temp[k];
        }
     }

        //Quick Sort
        public static void quickSort(int arr[],int si,int ei)
        {
            //base case
            if(si>=ei)
            {
                return;
            }

            //pivot to be taken as last element(but pivt can be taken as any element)
            int pIdx = partition(arr,si,ei);

            //quick sort left
            quickSort(arr, si, pIdx-1);
            //quick sort right
            quickSort(arr, pIdx+1, ei);


        }

        public static int partition(int arr[],int si,int ei)
        {
            int pivot=arr[ei];
            int i =si-1; //to make space for smaller elements than pivot i=si-1; si can be nay value

            for(int j =si;j<ei;j++)
            {
                if(arr[j]<=pivot)
                {
                    i++;//make space
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;

                    
                }
            }
                i++;
                
                    int temp=pivot; //
                    arr[ei]=arr[i];    //have swap value in array not in variable .; arr[ei is used not variable pivot]
                    arr[i]=temp;

                    return i;   //bcoz pivot is stored in i;
        }

    //Search in Rotated Sorted Array
    /** input:aorted,rotated array with distinct numbers
     * (in ascending order) it is rotated at pivot point.
     * Find index of given element.
     */
    public static int searchSortedRotated(int arr[],int tar,int si,int ei)
    {
        //base case
        if(si>ei)
        {
            return -1;
        }

        int mid = si+(ei-si)/2;

        //case found
        if(arr[mid]==tar)
        {
            return mid;
        }

        //mid on L1
        if(arr[si]<=arr[mid])
        {
            //case a:left
            if(arr[si]<=tar && tar<=arr[mid])
            {
               return searchSortedRotated(arr,tar,si,mid-1);
            }
            //case b:right
            else
            {
                return searchSortedRotated(arr,tar,mid+1,ei);
            }
        }
        
        //mid on L2
        else
        {
            //case c: right 
            if(arr[mid]<=tar && tar<=arr[ei])
            {
              return    searchSortedRotated(arr,tar,mid+1,ei);
            }
            //case d:left
            else
            {
               return   searchSortedRotated(arr,tar,si,mid-1);
            }
        }
        
    }


    public static void main(String args[])
    {   //merge sort 
    /*
        int arr[]={6,3,9,5,2,8};
        mergeSort( arr,0,arr.length-1);
        printArr(arr);*/

        //Quick Sort

       /* int arr[]={6,3,9,8,2,5};
        quickSort( arr, 0,arr.length-1);
        printArr(arr);*/

        //Search sorted and rotated array

        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        int tarIdx= searchSortedRotated(arr,target,0,arr.length-1);
        System.out.println(tarIdx);
    }
}