import java.util.*;

class Matrix2dArray
{

    public static boolean search(int matrix [][],int key)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if (matrix[i][j]== key )
                {
                System.out.println("found at cell ("+ i +"," + j + ")");    
                }
                 
                 return true;
                //else
                //{
                  //  System.out.println("cell not found");
                //}
            }
        }
          System.out.println("not found cell");
        return false;
    }

    public static void main(String args[])
    {
        int matrix[][] = new int [3][3];
        int n = matrix.length;
        int m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

      // System.out.println("enter values for matrix");
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]= sc.nextInt();
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
         search(matrix,5);

    }

   
}