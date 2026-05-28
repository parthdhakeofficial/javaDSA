class StringGetShortestPath
{

    public static float getShortestPath(String path)
    {

        float x=0;
        float y=0;

        for(int i =0 ;i<path.length();i++)
        {
            char dir = path.charAt(i);

            //south
            if(dir=='S')
            {
                   y--; 
            }
            //north
            else if(dir=='N')
            {
                y++;
            }
            //west
            else if(dir=='W')
            {
                x--;
            }
            //east
            else
            {
                x++;
            }

        }

        float X2 =x*x;
        float Y2 =y*y;

        return (float)Math.sqrt(X2+Y2);
    }


        public static String substring(String str,int si,int ei)
        {
            String substr="";
            for(int i=si;i<ei;i++)
            {
                substr+=str.charAt(i);

            }
            return substr;
        }

    /*public static void printLargestString(String fruits,String largest)
    {


        for(int i=1;i<fruits.length;i++)
        {
            if(largest.compareto(fruits[i]))
            {
                laregst=fruits[i];
            }
        }
        System.out.println(largest);
    }
*/

    public static String toUpperCase(String str)
    {
        StringBuilder sb = new StringBuilder();

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++)
        {
            if( str.charAt(i)==' '&& i<str.length()-1)
            {
                sb.append(str.charAt(i));
                i++;

                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else
            {
                sb.append(str.charAt(i));
            }

        }
            return sb.toString();

    }


    public static String compresion(String str)
    {
        String newStr="";

        for(int i=0; i<str.length();i++)
        {
            Integer count=1;

            while(i<str.length()-1&& str.charAt(i)==str.charAt(i+1))
            {
                count ++;
                i++;

            }

            newStr+=str.charAt(i);
            if(count>1)
            {
                newStr+=count.toString();
            }
        }
        return newStr;

    }


    public static void main(String args[])
    {
        //String path="WNEENESENNN";

        //System.out.println(getShortestPath(path));

                //substr

        ///tring str = "helloworld";

        //in java there is a function to print substring is present in java.
       // System.out.println(str.substring(0,7));

        // System.out.println(substring(str,0,7));



        //code to print largest string 

       /* String fruits[] = {"apple","mango","banana"};
        
        String largest= fruits[0];

            for(int i=1;i<fruits.length;i++)
            {
                if((largest.compareto(fruits[i]))<0)
                    {
                        largest=fruits[i];
                    }
            }
        System.out.println(largest);*/

        //System.out.println(printLargestString);


        // code using StringBuilder

       /* StringBuilder sb = new StringBuilder("");

        for(char ch='a';ch<='z';ch++)
        {
            sb.append(ch);
        }

        System.out.println(sb);*/

        // code to convert first letter in upper case of sentence

       /* String str= "hi, i am parth";

        System.out.println(toUpperCase(str));
*/


        // code for string compresion

        String str="aaabbccdd";
        System.out.println(compresion(str));


        
        
        }
}