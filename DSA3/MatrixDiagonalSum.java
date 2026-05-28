class MatrixDiagonalSum
{

    public static int diagonalSum(int matrix[][])
    {
        int sum=0;                                                                          //  1   2   3   4
                                                                                            //  5   6   7   8
       // for(int i=0;i<matrix.length;i++)                                                  //  9   10  11  12
       // {//                                                                               //  13  14  15  16
           // for(int j=0;j<matrix.length;j++)
            //{
              //  if(i==j)
                //{                                                       time complexcity is O(n^2)
                  //  sum+=matrix[i][j];
                //}
                //else if(i+j==matrix.length-1)
                //{
                  //  sum+=matrix[i][j];
               // }/
            //}
       // }

        //lets write it for linear time complexcity i.e. O(n)

        for(int i=0;i<matrix.length;i++)
        {
            //primary diagonal
            sum+=matrix[i][i];

            if(i!=matrix.length-i-1)
            {
                //secondary diagonal
                sum+=matrix[i][matrix.length-i-1];
            }

        }




        return sum;
    }


    public static void main(String args[])
    {
        int matrix[][]= { {1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}, };

                          System.out.println(diagonalSum(matrix));

    }
}