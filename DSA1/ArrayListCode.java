import java.util.*;

class ArrayListCode
{

    public static void swap(ArrayList<Integer>list,int idx1,int idx2)
    {
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

/**
 * add 3 list to multi dimensional to arraylist
 * being table od 1,2,3
 * 
 * 
 */

    public static void addLists(ArrayList<Integer>al1,ArrayList<Integer>al2,ArrayList<Integer>al3)
    {
        for(int i=1;i<=5;i++)
        {
            al1.add(i*1);
            al2.add(i*2);
            al3.add(i*3);

        }
    } 

/*
    //container with most water
    public static int storeWater(ArrayList<Integer>height)
    {
        int maxWater=0;

        for(int i=0;i<height.size();i++)
        {
            for(int j=i+1;j<height.size();j++)
            {
                int ht = Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }

*/

    //2 pointer apparaoch 
    public static int storeWater2(ArrayList<Integer>height)
    {
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;

        while(lp<rp)
        {
            //calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater = Math.max(maxWater,currWater);

            //update ptr
            if(height.get(lp)<height.get(rp))
            {
                lp++;
            }
            else
            {
                rp--;
            }
           
        }
         return maxWater;
    }

//pair sum sum of pair in an array should be equal to traget
    //array is sorted
/*   public static boolean pairSum1( ArrayList<Integer> list,int target)
    {

        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                if(list.get(i)+list.get(j)==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
*/
//pair sum sum of pair in an array should be equal to traget
   //based on 2 pointer apparch
    public static boolean pairSum12(ArrayList<Integer> list,int target)
   {
     int lp=0;
    int rp=list.size()-1;

    while(lp !=rp)
    {
        //case1
        if(list.get(lp)+list.get(rp)==target)
        {
            return true;
        }
        //case2
        if(list.get(lp)+list.get(rp)<target)
        {
            lp++;
        }
        else    //cae3
        {
            rp--;
        }
        
    }
    return false;
   }

    //pairsum2 
    //pair sum sum of pair in an array should be equal to traget
    //array is rotated
    public static boolean pairSum2(ArrayList<Integer>ps2list,int target)
    {
        
        int pivot=-1;//not valid index
        int n =ps2list.size();
        
        //finding pivot
        for(int i=0;i<ps2list.size();i++)
        {
            if(ps2list.get(i)>ps2list.get(i+1))
            {
                pivot=i;
                break;
            }
        }

        int lp=pivot+1;//smallest
        int rp=pivot;//largest

        while(lp!=rp)
        {
            //case1
            if(ps2list.get(lp)+ps2list.get(rp)==target)
            {
                return true;
            }

            //moduloarthematic is used for lp and rp
            //case2
            if(ps2list.get(lp)+ps2list.get(rp)<target)
            {
                lp=(lp+1)%n;
            }
            else    //case3
            {
                rp=(n+rp-1)%n;
            }
        }

    return false;



    }






    public static void main(String args[])
    {
        ArrayList<Integer> list= new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //reverse print
     /*   for(int i=list.size()-1;i>=0;i--)
        {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        */

       //max element

       /*int max=Integer.MIN_VALUE;

       for(int i=0;i<list.size();i++)
       {
        if(max<list.get(i))
        {
            max=list.get(i);
        }
       }
    System.out.println("max element:"+max);

*/


  /*  int idx1=1;
    int  idx2=3;
    System.out.println(list);
    swap(list,idx1,idx2);
    System.out.println(list);
*/

   /* ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
    ArrayList<Integer>arr=new ArrayList();
    ArrayList<Integer>arr2=new ArrayList();
      ArrayList<Integer>arr3=new ArrayList();
    

    arr.add(1); arr.add(2);
    mainlist.add(arr);

    arr2.add(3); arr2.add(4);
    mainlist.add(arr2);


    for(int i=0;i<mainlist.size();i++)
    {
        ArrayList<Integer>currList =mainlist.get(i);
        for(int j=0;j<currList.size();j++)
        {
            System.out.print(currList.get(j)+" ");
        }
        System.out.println();


    }

     System.out.println(mainlist);*/

//
  /*  ArrayList<ArrayList<Integer>> mainal=new ArrayList<>();
    ArrayList<Integer>al1=new ArrayList();
    ArrayList<Integer>al2=new ArrayList();
    ArrayList<Integer>al3=new ArrayList();

      for(int i=1;i<=5;i++)
        {
            al1.add(i*1);
            al2.add(i*2);
            al3.add(i*3);

        }

    
    mainal.add(al1);
     mainal.add(al2);
      mainal.add(al3);

      System.out.println(mainal);*/

    ArrayList<Integer>height=new ArrayList<>();

    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);

   // System.out.println(storeWater(height));
    //System.out.println(storeWater2(height));

   //pair sum sum of pair in an array should be equal to traget
   
    // System.out.println( pairSum1(list,5));
        //2pa
      //   System.out.println( pairSum12(list,5));

       ArrayList<Integer>ps2list= new ArrayList<>();
       ps2list.add(11);
       ps2list.add(15);
       ps2list.add(6);
       ps2list.add(8);
       ps2list.add(9);
       ps2list.add(10);

       int target=16;
    
         System.out.println( pairSum2(ps2list,target));




    }
}