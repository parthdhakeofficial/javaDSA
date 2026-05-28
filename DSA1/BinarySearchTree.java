import java.util.ArrayList;

class BinarySearchTree
{
    /**Inorder traversal of bst gives a sorted sequence 
     * Inorder traversal (left,root,right)
     * Skewwd tree : 1->2->3->4  T(n)=O(H)
    */
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
        }

    }

    public static Node insert(Node root, int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        if(root.data > val)
        {
            //left subtree
            root.left = insert(root.left,val);
        }
        else
        {
            root.right = insert(root.right,val);
        }

        return root;

    }

    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key)
    {
        if(root == null)
        {
            return false;
        }

        if(root.data == key)
        {
            return true;
        }
        
        if(root.data > key)
        {
           return  search(root.left,key);
        }
        else 
        {
           return search(root.right,key);
        }
    }

     //delete a node //IMP question 

    public static Node delete(Node root, int val)
    {
        if(root.data < val)
        {
            root.right=delete(root.right,val);
        }
        else if(root.data>val)
        {
            root.left=delete(root.left,val);
        }
        else
        {//voila
            //case 1-leaf node
            if(root.left == null && root.right==null)
            {
                return null;
            }

            //case 2 - single child
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }

            //case 3 -both childern
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root)
    {
        while(root.left!=null)
        {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root ,int k1, int k2)
    {
        if(root==null)
        {
            return;
        }

        if(root.data >= k1 && root.data <=k2)
        {
            printInRange(root.left,k1,k2);
            System.out.print(root.data +" ");
            printInRange(root.right, k1 , k2 );
        }
        else if(root.data < k1)
        {
            printInRange(root.left, k1,k2);
        }
        else
        {
            printInRange(root.right, k1 , k2 );
        }

    }

    public static void printPath(ArrayList<Integer>path)
    {
        for(int i=0;i<path.size();i++)
        {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("NULL");
    }

    public static void printRoot2Leaf( Node root , ArrayList<Integer> path)
    {
        if(root==null)
        {
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right==null)
        {
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);


    }

    //Validate BST //VIMP question
    /**
     * shortcut to check Validate BST
     *  check if inorder traversal is sorted 
     * if sorted then valid else not valid
     */

    public static boolean isValidBST(Node root, Node min, Node max)
    {
        if(root == null)
        {
            return true;
        }

        if(min != null && root.data<=min.data)
        {
            return false;
        }
        else if(max !=null && root.data>= max.data)
        {
            return false;
        }

        return isValidBST(root.left, min , root)
        && isValidBST(root.right,root, max);
    }

   //Mirror bst
   public static Node createMirror(Node root)
   {
        if(root == null)
        {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
   }

   public static void preorder(Node root)
   {
        if(root == null)
        {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
   }


   //Sorted array to balanced Bst
 /*   public static Node createBST(int values2[] ,int si,int ei)
    {
        if(si>ei)
        {
            return null;
        }

        int mid=(si+ei)/2;
        Node root = new Node(values2[mid]);
        root.left=createBST(values2,si,mid-1);
        root.right= createBST(values2,mid+1,ei);
        return root;


    }

    */

 /*   public static Node balanceBSt(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }*/

    //covert bst to balanced bst
    public static void getInorder(Node root,ArrayList<Integer>inorder)
    {
        if(root==null)
        {
            return ;
        }

        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

   /* public static Node createBST2( ArrayList<Integer>inorder,int si,int ei)
    {
        if(si>ei)
        {
            return null;
        }

        int mid=(si+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left=createBST2(inorder,si,mid-1);
        root.right= createBST2(inorder,mid+1,ei);
        return root;


    }


    public static Node balanceBST2(Node root)
    {
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        //sortedinorder-> balanced BST
        root = createBST2(inorder,0,inorder.size()-1);
        return root;


    }

    //size of largest bst in bt

    static class Info
    {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size,int min, int max)
        {
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;

        }

       
    }



     public static int maxBST=0;

        public static Info largestBST(Node root)
        {
            if(root == null)
            {
                return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }

            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);

            int size = leftInfo.size+rightInfo.size+1;
            int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
            int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        

        if(root.data<=leftInfo.max || root.data>=rightInfo.min)
        {
            return new Info(false,size,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST)
        {
            maxBST = Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }

            return new Info( false,size,min,max);


    }
    */

    //merge BSTs

     public static Node createBST3( ArrayList<Integer>arr,int si,int ei)
    {
        if(si>ei)
        {
            return null;
        }

        int mid=(si+ei)/2;
        Node root = new Node(arr.get(mid));
        root.left=createBST3(arr,si,mid-1);
        root.right= createBST3(arr,mid+1,ei);
        return root;


    }


    public static Node mergeBSTs(Node root1, Node root2)
    {
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);

        //step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);

        //merge
        int i=0;
        int j=0;
        ArrayList<Integer>finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size())
        {
            if(arr1.get(i) <= arr2.get(j))
            {
                finalArr.add(arr1.get(i));
                i++;
            }
            else
            {
                finalArr.add(arr2.get(j));
                j++;
            }


        }

        while(i<arr1.size())
        {
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size())
        {
            finalArr.add(arr2.get(j));
            j++;
        }

    return createBST3(finalArr,0,finalArr.size()-1);

    }



    public static void main(String args[])
    {
        //int values[]={5,1,3,4,2,7};
       // int values2[] = {8,5,3,1,4,6,10,11,14};

       // Node root = null;

      /*  for(int i=0; i<values2.length; i++)
        {
            root = insert(root,values2[i]);
        }*/

      //  inorder(root);
      //  System.out.println();

      /*  if(search(root,1))
        {
            System.out.println("found");
        }
        else
        {
            System.out.println("not found");
        }
*/

       // root=delete(root,1);
        //System.out.println();
        // inorder(root);


       // printInRange(root, 5,11);

       //printRoot2Leaf(root,new ArrayList<>());

   /*    if(isValidBST(root,null,null))
       {
        System.out.println("valid");
       }
       else
       {
            System.out.println("not valid");
       }
       */

    //  root= createMirror(root);
     // preorder(root);


   // Node root = createBST(values2,0,values2.length-1);
   // preorder(root);

      /*  Node root= new Node(8);
        root.left= new Node(6);
        root.left.left= new Node(5);
        root.left.left= new Node(3);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);


        root=balanceBST2(root);
        preorder(root);
        */

       //size of largest bst in bt

       /* Node root= new Node(50);
        root.left= new Node(30);
        root.left.left= new Node(5);
        root.left.right= new Node(20);
        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);
        */

       // Info info = largestBST(root);
        //System.out.println("largest BST size="+maxBST);

       //merge bst

       Node root1 = new Node (2);
       root1.left = new Node (1);
       root1.right = new Node (4);


       Node root2 = new Node(9);
       root2.left = new Node(3);
       root2.right = new Node (14);

       
       
        Node root = mergeBSTs( root1,  root2);
        preorder(root);



    }
}