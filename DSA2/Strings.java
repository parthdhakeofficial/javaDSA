class Strings
{

    public static void printletters(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }


    public static boolean panlindrome(String str)
    {
        for(int i=0; i<str.length()/2;i++)
        {
            int n=str.length();
            if(str.charAt(i)!=str.charAt(n-1-i))
            {
                return false;
            }

        }
        return true;
    }




    public static void main(String args[])
    {
        //char arr[]={'a','b','c','d'};
        //String str ="abcd";
        //String str2 = new String("xyz1994"):

        // Strings are immutable i.e. they cannot change
        // to change we have to a new string in memory 



        //concatrnation
       // String firstname="parth";
        //String lastname="patil";
        //String fullname=firstname +" "+ lastname;

        //printletters(fullname);

      //  String str="noon";
        // System.out.println(panlindrome(str));



    }
}