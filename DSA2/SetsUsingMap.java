import java.util.*;

class SetsUsingMap
{
    public static void main(String args[])
    {
       /* HashSet<Integer>set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);
        set.clear();
        System.out.println(set.size());
        System.out.println(set.isEmpty());



        set.remove(2);
        if(set.contains(2))
        {
            System.out.println("set contains 2 ");
        }
         if(set.contains(3))
        {
            System.out.println("set contains 3 ");
        }
*/
 /*       HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");
        cities.add("CSN");

        System.out.println(cities);

      /*  Iterator itr = cities.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }*/

      /* for(String city:cities)
       {
        System.out.println(city);
       }*/

  /*     LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");
        lhs.add("CSN");

        System.out.println(lhs);
      //  lhs.remove("Delhi");
      //  System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");
        ts.add("CSN");

      System.out.println(ts);
*/
      //count distinct elememts

  /*    int num[]={4,3,2,5,6,7,3,4,2,1};
      HashSet<Integer> set = new HashSet<>();

      for(int i=0;i<num.length;i++)
      {
        set.add(num[i]);
      }

      System.out.println("ans="+set.size());
      */

    //union and intersection of sets

  /*  int arr1[] ={7,3,9};
    int arr2[] ={6,3,9,2,9,4};
    HashSet<Integer> set = new HashSet<>();

    //union
    for(int i=0;i<arr1.length;i++)
    {
      set.add(arr1[i]);
    }

    for(int i=0;i<arr2.length;i++)
    {
      set.add(arr2[i]);
    }

    System.out.println("union="+set.size());

    //intersection
    set.clear();
    for(int i=0;i<arr1.length;i++)
    {
      set.add(arr1[i]);
    }

    int count=0;
    for(int i=0;i<arr2.length;i++)
    {
      if(set.contains(arr2[i]))
      {
        count++;
        set.remove(arr2[i]);
      }
    }
    System.out.println("intersection="+count);
  */

    //find itineary from tickets

  /*  HashMap<String,String> tickets = new HashMap <>();
    tickets.put("Chennai","Bengaluru");
    tickets.put("Mumbai","Delhi");
    tickets.put("Goa","Chennai");
    tickets.put("Delhi","Goa");

    String start = getStart(tickets);
    System.out.print(start);
    for(String key:tickets.keySet())
    {
      System.out.print("->"+tickets.get(start));
      start = tickets.get(start);
    }
*/

  /*
  //largest subarray with sum 0
    int arr[]={15,-2,2,-8,1,7,10,23};

    HashMap<Integer,Integer> map = new HashMap<>();
    //(sum,idx)

    int sum=0;
    int len=0;

    for(int j=0;j<arr.length;j++)
    {
      sum+=arr[j];
      if(map.containsKey(sum))
      {
        len=Math.max(len,j-map.get(sum));
      }
      else
      {
        map.put(sum,j);
      }
    }

    System.out.println("largest subarray with sum as 0="+ len);
*/

      //subarray sum equal to k

      int arr[]={10,2,-2,-20,10};
      int k=-10;

      HashMap<Integer,Integer>map= new HashMap<>();
      //(sum,count)
      map.put(0,1);

      int sum=0;
      int ans=0;

      for(int j=0;j<arr.length;j++)
      {
        sum+=arr[j];//sum(j)
        if(map.containsKey(sum-k))
        {
          ans+=map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);

      }

      System.out.println(ans);


    }

    //find itineary from tickets

   /* public static String getStart( HashMap<String,String> tickets  )
    {
      HashMap<String,String> revMap = new HashMap<>();

      for(String key: tickets.keySet())
      {
        revMap.put(tickets.get(key),key);
      }

      for(String key: tickets.keySet())
      {
       if(!revMap.containsKey(key))
       {
          return key;
       }
      }
      return null;
      
    }
    */
}