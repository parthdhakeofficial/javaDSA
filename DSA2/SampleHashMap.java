import java.util.*;

class SampleHashMap
{
    public static void main(String args[])
    {
        //create
        HashMap<String,Integer> hm = new HashMap<>();

        //insert-O(n)
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Indonesia",6);
        hm.put("Nepal",5);

       System.out.println(hm);

       //Get-O(1)
      // int population = hm.get("India");
     //   System.out.println(population);

       // System.out.println( hm.get("Indonesia"));
        //containsKey-O(1)
     //   System.out.println( hm.containsKey("India"));
       // System.out.println( hm.containsKey("Indonesia"));

       //Remove
     //  System.out.println( hm.remove("China"));
      // System.out.println(hm);


    //size
     // System.out.println(hm.size());

    //is empty
   // hm.clear(); //to data in map
   // System.out.println(hm.isEmpty());

   //iterate
   Set<String> keys = hm.keySet();
   System.out.println(keys);

   for(String k: keys)
   {
        System.out.println("key="+k+",value="+hm.get(k));
   }






    }
}