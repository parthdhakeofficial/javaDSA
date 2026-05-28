class EquiPyramid

{
    public static void main(String args[])
    {
        int n =5;

        for (int i=1;i<=n;i++)
        {
            //step 1 print empty spaces
            for(int j=0; j<=(n-1);j++ )
            {
                System.out.print(" ");
            }
        }

        //step2 start printing nos

        int num = 1;
        boolean increasing = true;

        while(num>0)
        {
            System.out.println(num);

            if(num==1)
            {
                increasing = false;
            }

            if(increasing == true)
            {
                num++;
            }
            else
            {
                num--;
            }

        }

         //   System.out.println();

    }

}