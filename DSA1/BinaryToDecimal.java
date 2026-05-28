class BinaryToDecimal
{


    public static void bintodec(int binNum)
    {
        int myNum= binNum;
        int pow=0;
        int decNum=0;

        while(binNum>0)
        {
            int lastDigit= binNum%10;
            decNum = decNum+ (lastDigit + (int)Math.pow(2,pow));
            
            
            //Math.pow is a inbuilt function in java in parametre we (base,power;)
            // Math.pow has a fuction takes double as input and returns double 
            //Hence we typecast it using int datatype i.e.(int)function
        
            pow++;

            binNum = binNum/10;
        }

        System.out.println("decimal of"+myNum+"="+decNum);
    }



    
    public static void main(String args[])
    {
        bintodec(101);

    }



}