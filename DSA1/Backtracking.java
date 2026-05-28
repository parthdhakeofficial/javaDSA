class Backtracking
{
    public static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Backtracking of array
    public static void changeArr(int arr[],int i,int val)
    {
        //base case
        if(i == arr.length)
        {
            printArr(arr);
            return;
        }
        //recurrsion(work)
        arr[i]=val;
        changeArr(arr, i+1, val+1); //funn call
        arr[i]=val-2;               //backtraking step
    }

    //find subsets
    //SUBSET of sets = 2^n;
    public static void findSubsets(String str,String ans,int i)
    {
        //base case
        if(i==str.length())
        {
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
            System.out.println(ans);
            }
            return;
        }
        //recurrsion

        //yes choice
        findSubsets(str,ans+str.charAt(i),i+1);
        //No choice
        findSubsets(str,ans,i+1);
    }

    //find permutation
    /**
     * permutation of n elements = n!
     */
    public static void findpermutaion(String str,String ans)
    {
        //base case
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        //recurrsion
        for(int i=0;i<str.length();i++)
        {
            char curr = str.charAt(i);
            //'abcde'=.'ab'+'de'='abde';
            String Newstr = str.substring(0,i)+str.substring(i+1,str.length());
            findpermutaion( Newstr, ans+curr);
        }
    }

    //N-queens
    /**
     * place n queens on a NxN chessboard 
     * such that no queens can attack each other
     * let N=4;
     */

    //
    public static void nQueens(char board[][],int row)
    {
        //base case
        if(row == board.length)
        {
            printBoard(board);
            count++;
            return;
        }
        //column loop
        for(int j=0;j<board.length;j++)
        {
            if(isSafe(board, row,j))
            {
                board[row][j]='Q';
                nQueens( board, row+1);   //recurrsion
                board[row][j]='_';         //backtracking
            }
        }
    }
    /**
       _ _ _ _
       _ _ _ _
       _ _ _ _
       _ _ _ _

     */
    public static boolean isSafe(char board[][],int row,int col)
    {
        //vertical up
        for(int i=row-1;i>=0;i--)       //j i.e column will remain constant 
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }
        //diagonal left up
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j-- )
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1, j =col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        return true;
    }

    //print board
    public static void printBoard(char board[][])
    {
        System.out.println("-------chess board-------");
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count =0;


    //Gird ways
    /**gridd is n*m
     * find total no of ways to reach from(0,0) cell to (n-1,m-1)
     * and we can only move to right and down side
     * here gird id 3*3
     */

    /**
     * for 
     * no right turn = no of coln = m
     * no down turn = no of row =n
     * 
     * acc to permutation
     * (n-1+m-1)!/(n-1)!(m-1)!
     * 
     * rrdd
     * ddrr
     * rdrd
     * drdr
     * drrd
     * drrd
     * 
     */

    public static int gridsWays(int i,int j,int n,int m)
    {
       //base case
       if(i==n-1 && j==m-1)     //i=last cell && j=last cell
       {
        return 1;
       }
       else if(i==n||j==n)    //i=length of row j= l of col
       {
        return 0;
       }

        //way 1 move right
        int w1=gridsWays(i,j+1 ,n, m);
        //way 2 move down
         int w2=gridsWays(i+1,j,n, m);

        return w1+w2;
    }

    //sodoku solver code
    public static boolean sudokuSolver(int sudoku [][],int row ,int col)
    {
        //base case
        if(row==9&&col==0)
        {
            return true;
        }
        
        //recurrsion

        int nextRow=row,nextCol=col+1;

        if(col+1==9)
        {
            nextRow=row+1;
            nextCol=0;
        }


        if(sudoku[row][col]!=0)
        {
            return sudokuSolver(sudoku , nextRow , nextCol);
        }

        for(int digit=1;digit<=9;digit++)
        {
            if(isSafe(sudoku,row,col,digit))
            {
                sudoku[row][col]=digit;

                if(sudokuSolver(sudoku , nextRow , nextCol))
                {//solution exit
                    return true;
                }
                 sudoku[row][col]=0;
            }
        }
        return false;
    }

    //issafesudoku
   // public static boolean isSafe(int sudoku[][], int row, int col, int digit)
    public static boolean isSafe(int sudoku[][],int row ,int col,int digit)
    {
        //row
        for(int i=0;i<=8;i++)
        {
            if(sudoku[i][col]==digit)
            {
                return false;
            }
        }

        //column
        for(int j=0;j<=8;j++)
        {
            if(sudoku[row][j]==digit)
            {
                return false;
            }
        }

        //grid
        //sudoku row=9/**
        // row idx=0,1,2
        // if divide by 3 then =0 
        //  row idx=3,4,5
        // if divide by 3 then =1
        //  row idx=6,7,8
        // if divide by 3 then =2 
        // 
        // and when after dividing multiplied by 3
        // 0*3=0;1*3;2*3=6*
        // to locate col/


        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(sudoku[i][j]==digit)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int sudoku[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(sudoku [i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main (String args[])
    {
        //backtracking of arrays
        /*int arr[]=new int[5];
        changeArr(arr,0,1);             //tc=O(n)   sc=O(n)
        printArr(arr);*/

        //find Subsets
       /* String str ="abc";
        findSubsets( str,"", 0);*/

        //find permutation
       /* String str="abc";           //tc=n*n!
        findpermutaion( str,"");*/

        //N queens
       // int n=4;
        //char board[][]=new char[n][n];
        //initialize
        /*for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='_';
            }
        }

       nQueens(board,0);    //all ways

       // no of ways
        System.out.println("total ways to solve n queens:"+count);

        //check solvable and print any one only
            /**
             * change return type of nQueens functions
             * from void to boolean
             * then if row == board.length
             * return true;
             * and
             * if(nQunees(board,row+1))
             * {return true}
             * 
             * and at end return false 
             * 
             * AND
             * in main function
             * if(nQueens(board,0))
             * {
             *  System.out.println("soln is possible")
             * } else{
             *  S.o.pln("soln is not possiable")}
             */

            //gird ways
          /*   int n=3,m=3;
           System.out.println(  gridsWays( 0,0,n,m ));*/
    

        //sudoku solver

        int sudoku[][]={ {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}     
     };

    if(sudokuSolver( sudoku, 0, 0))
    {
        System.out.println("soln exist");
        printSudoku(sudoku);

    
    }
    else
    {
     System.out.println("soln doesnot exist");   
    }








    }
}