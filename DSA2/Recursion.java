class Recursion
{
    //Q1.print numbers n to 1 in decrecing order
    public static void  printDec(int n)
    {
        if (n==1) //for base case
        {
            System.out.print(1);
            return; // so zero doesn't get call
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    //print numbers from 1 to n
    public static void printInc(int n)
    {
       
        if(n==1)
        {
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");

    }

    //print factorial on num n
    public static int fact(int n)
    {
        if(n == 0) //base case
        {
            return 1; // factorial of  0 is 1.
        }

        int fnm1 = fact(n-1);    //fnm1->f(n-1)
        int fn   = n*fact(n-1);  //fn->f(n)
        return fn ;
    
    }

    //print sum of n natural numbers
    public static int sum(int n)
    {
        if(n == 1)
        {
            return 1;
        }

        int sm1 = sum(n-1);   //sm1=sum - 1
        int sum = n + sm1;
        return sum;
    } 

    //print nth fibonacci number
    public static int fibo(int n)
    {
        if(n==1)
        {
            return 1;
        }
        else if(n==0)
        {
            return 0;
        }
        int fibonm1=fibo(n-1);
        int fibonm2=fibo(n-2);
        int fibon= fibonm1 + fibonm2 ;
        return fibon;
    }

    //given array is sorted or not
    public static boolean isSorted(int arr[],int i)
    {
        if(i==arr.length-1)
        {
            return true;
        }

        if(arr[i] > arr[i+1])
        {
            return false;
        }

        return isSorted(arr,i+1);
    }

  /*  public static boolean isSorted(int arr[], int i) {
    if(i == arr.length - 1) {
        return true;
    }

    if(arr[i] > arr[i + 1]) {
        return false;
    }

    return isSorted(arr, i + 1);
}*/

    //find first occurence of element in an array
    public static int firstOcc(int waa[],int i)
    {   //compare self and then look forward
        int key =5;

        if(i==waa.length-1)
        {
            return -1;     //base case
        }

        if(waa[i]==key)
        {
            return i;
        }

      return  firstOcc(waa,i+1);
    }

     //find last occurence of element in an array
    public static int lastOcc(int waa[],int i)
    {   //look forward and then compare self
        
        int key =5;

        if(i ==waa.length) //base case
        {
            return -1;
        }

        int isFound = lastOcc(waa,i+1);

        if(isFound==-1 && waa[i]==key)
        {
            return i;
        }
        

      return isFound;
    }

    //print x^n
    public static int power(int x ,int n)
    {
        if(n==0)
        {
            return 1;   //base case
        }
       // int powxnm1 = power(x,n-1);
        //int powxn = x *powxnm1;
        //return powxn;

        //{or else can write}
        return x * power(x,n-1);
    }


    // print x^n in 0(logn)
    /* 
    case 1: n=even;
            x^n= x^n/2 *x^n/2;
            2^10= 2^5 * 2^5;   
    case 2: n=odd;
            x^n = x*x^n/2*x^n/2;
            2^5 = 2*2^2*2^2;

            n=10; power goes divideing by 2
            n/2^l=1:
            n=2^l;
            log n = l;
     */
        //print x^n in 0(logn)
        public static int oppow(int a, int n)
        {
            if(n==0)
            {
                return 1;
            }

            //int halfpow = oppow(a,n/2);
            //int halfpowsq = halfpow * halfpow;


            int halfpowsq = oppow(a,n/2)*oppow(a,n/2);

            if(n%2!=0)
            {
                 halfpowsq = a* halfpowsq;
            }

            return halfpowsq;
        }

        //given "2 x n "borad and tiles of size " 2 x 1",
        //count no of ways to tile given board 2 x 1 tiles
        //(a tile can either be placed horizonatally or vertically)

        public static int tileProblem(int n)
        {
            //base case
            if(n==0||n==1)
            {
                return 1;
            }

            // work
            // choice vertical .i.e f(n-1)
            int fnm1= tileProblem(n-1); //inner call
            //choice horizontal
            int fnm2= tileProblem(n-2); //inner call

            int totalWays = fnm1+fnm2;
            
            return totalWays; 


        }

        //remove duplicates in string "appnnacollege"
        /* base case: idx = 0 to n;
            idx=currentcharcter-'a';
            work: char->present in map[] 
                if prsent don't add if not then add
            inner case: idx-> idx+1;*/
        
        public static void removeDuplicate(int idx,StringBuilder newStr,boolean map[])
        {
            String str= "appnnacollege";
            //StringBuilder newstr=new StringBuilder("");

            //base case
            if(idx== str.length())
            {
                System.out.println(newStr);
                return;
            }   
            //work
            char currChar=str.charAt(idx);
            if(map[currChar-'a'] == true )
            {
                //duplicate
                removeDuplicate(idx+1,newStr,map);
            }        
            else
            {
                map[currChar-'a']=true;
                
                    //first time
                    
                    removeDuplicate(idx+1,newStr.append(currChar),map);
                  //  newstr.append(currChar);
            
            }
        }

        //Friends Pairing Problem
        //Given n friends, each one can remain single or can 
        //be paired up with some other friend.Each friend can
        //be paired only once .find out total no of ways in 
        //which friends can remain single or can be paired up.

        /* base case: n= 1 ways=1
                      n=2  ways=2
                      .: n=1||n=2 return n;
            work:   to find total ways
                    choice : 
                    single          pair
                    1  (n-1)        2       (n-2)
                       f(n-1)     (n-1)     f(n-2)
                            pair choices    After 1 pair ways
                            pair ways = (n-1)*(n-2);
                            eg:  friend 'a' can be paired with 'b,c,d,e,f,g,h'

            totalways=f(n-1)+(n-1)*(n-2);
        */
        public static int friendsPairing(int n)
        {
            //base case
            if(n==1||n==2)
            {
                return n;
            }
           /* //choice
            //single
            int fnm1= friendsPairing(n-1);
            //pair
            int fnm2 = friendsPairing(n-2);
            int pairways = (n-1)* fnm2;

            int totalWays= fnm1 + fnm2;
            return totalWays;*/

            return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);

        }

        //print all binary strings of size N without consecutive ones

        /* binary string are stringa in which string only has 0 and 1 as chacter
           eg:
                let n=0; then possible combinatons:0; //base case
                let n=3;
                possible combinations :
                                        000
                                        001
                                        010
                                        100
                                        101
                observations:
                conclude:
                         that ZERO can be freely palced any where
                         resulting in combinations:000;001;010;
                         And ONE can only placed after or before ZERO
                         resulting in combinations:100;101;
                 */
        public static void printBinaryStrings(int n,int lastplace,String str)
        {
            //base case
            if(n==0)
            {
                System.out.println(str);
                return;
            }
            printBinaryStrings(n-1,0,str+"0");

            if(lastplace ==0)
            {
                printBinaryStrings(n-1,1, str+"1");
            }

        }

        //Tower of hanoi
        //n is no of plates to be transeferd from one tower to other
        public static void towerOfHanoi(int n,String Start ,String Help, String End )
        {
            //base case
            if(n==0)
            {
                System.out.println("no disk to transfer");
                return;
            }
            else if(n==1)
            {
                System.out.println("transfer disk  "+ n + "  from  "+Start+"  to  "+End);
                return;
            }
            towerOfHanoi(n-1, Start ,End, Help );
             System.out.println("transfer disk  "+ n +"  from  "+Start+"  to  "+End);
             
            towerOfHanoi( n-1, Help , Start, End );
        

        }

        //


    public static void main(String args[])
    {
        int n = 5;
        //  printDec(n);  
       // printInc(n);
      // System.out.println(fact(n));
            //System.out.println(sum(n));
    //System.out.println(fibo(n));

    int arr[]={1,2,3,4,5};
    //System.out.println(isSorted(arr,0));

    int waa[]={8,3,6,9,5,10,2,5,3};
    //System.out.println(firstOcc(waa,0));
    //System.out.println(lastOcc(waa,0));

    //System.out.println(power(2,10));

    //System.out.println(oppow(2,5));

   // System.out.println(tileProblem(4));

   //removeDuplicate(0,new StringBuilder(""),new boolean [26]);

   // System.out.println(friendsPairing(3));
    
   // printBinaryStrings(3,0,new String(""));

    
    towerOfHanoi(3,"T1" , "T2", "T3" );



    }
}