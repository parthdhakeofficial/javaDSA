class ButterflyPattern
{
    public static void main(String args[])
    {
        int n = 4;


        //1st half 
        for (int r=1;r<=n;r++)
        {

            //stars
            for(int c=1;c<=r;c++)
            {
                System.out.print("*");
            }

            //space
            for(int c=1;c<=2*(n-r);c++)
            {
                System.out.print(" ");
            }

            //star
            for(int c=1;c<=r;c++)
            {
                System.out.print("*");
            }

            System.out.println();
        }


        //2nd half mirror image
        for(int r=n;r>=1;r--)
        {

            //stars
            for(int c=1;c<=r;c++)
            {
                System.out.print("*");
            }

            //space
            for(int c=1;c<=2*(n-r);c++)
            {
                System.out.print(" ");
            }

            //star
            for(int c=1;c<=r;c++)
            {
                System.out.print("*");
            }

            System.out.println();


        }

    

        
    }


}