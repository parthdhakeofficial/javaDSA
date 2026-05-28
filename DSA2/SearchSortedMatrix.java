class SearchSortedMatrix
{
    public static boolean staircaseSearch(int matrix[][],int key)
    {
        int i=0;//row
        int n=matrix.length;
        int m=matrix[0].length;
        int j=m-1;//col

// condering (0,m-1)
        while(i<n && j>0)
        {
            if(key==matrix[i][j])
            {
                System.out.println("key found at index ("+i+","+j+")");
                
                return true;
            }
            else if(key<matrix[i][j])
            {
                j--;
            }
            else     //(key>matrix[i][j])
            {
                i++;
            }

        }

        System.out.println("key is not found");
        return false;
        
    }

/*
    public staticm boolean staircase(int matrix[][],int key)
    {
        {
            int i=n-1;
            int j=0;

            while(j<m && i>0)
            {
                if(key == matrix[i][j])
                {
                 //found
                }
                else if( key<matrix[i][j])
                {
                    i--;
                }
                else      //i.e. (key>matrix[i[j]])
                {
                    j++;
                }

                return true;
            }

            //not found
            // return false;
        }
    }
*/

    public static void main(String args[])
    {
        int matrix[][]={ {10,20,30,40},
                         {15,25,35,45},
                         {27,29,37,48},
                         {32,33,39,50} };

        int key =33;
        
        staircaseSearch(matrix,key);
    }
}