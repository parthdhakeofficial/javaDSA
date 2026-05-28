//import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;

class BinaryTrees2
{

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    static class BinaryTree
    {
        static int idx=-1;

        public static Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx]==-1)
            {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }

    }


    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        int lh =height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }

    //cal diameter of binary tree       //apporach1
 /*   public static int diameter1(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        int leftDiam=diameter1(root.left);
        int leftHt=height(root.left);
        int rightDiam=diameter1(root.right);
        int rightHt=height(root.right);

        int selfDiam= leftHt + rightHt + 1;

        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
    } 
*/

 /*   static class Info
    {
        int diam;
        int ht;

        public Info(int diam,int ht)
        {
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static Info diameter(Node root)
    {
        if(root==null)
        {
            return new Info(0,0);
        }


        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam=Math.max(Math.max(leftInfo.diam , rightInfo.diam), leftInfo.ht+ rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam,ht);
    }

    //subtree of another tree

    public static boolean isIndentical(Node node,Node subRoot)
    {
        if(node==null && subRoot==null)
        {
            return true;
        }
        else if(node==null||subRoot==null)
        {
            return false;
        }

        if(!isIndentical(node.left,subRoot.left))
        {
            return false;
        }
        if(!isIndentical(node.right,subRoot.right))
        {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root,Node subRoot)
    {
        if(root.data == subRoot.data)
        {
            if(isIndentical(root,subRoot))
            {
                return true;
            }
        }

       // boolean leftAns = isSubtree(root.left, subRoot);
       // boolean rightAns = isSubtree(root.right,subRoot);

       // return leftAns||rightAns;

        return isSubtree(root.left, subRoot)||isSubtree(root.right,subRoot);

    }
    */

    static class Infotv
    {
        Node node;
        int hd;

        public Infotv(Node node,int hd)
        {
            this.node=node;
            this.hd=hd;

        }
    }

    public static void topView(Node root)
    {
        //level order
        Queue<Infotv>q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min=0;
        int max=0;
        q.add(new Infotv(root,0));
        q.add(null);

        while(!q.isEmpty())
        {
            Infotv curr=q.remove();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                 if(!map.containsKey(curr.hd))    //.containsKey() is fun if it contains returns true or returns false
            {
                map.put(curr.hd,curr.node);
            }

            if(curr.node.left!=null)
            {
                q.add(new Infotv(curr.node.left,curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }

            if(curr.node.right!=null)
            {
                q.add(new Infotv(curr.node.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }

            }

           
            for(int i=min;i<=max;i++)
            {
                if (map.get(i) != null)
                {
                System.out.print(map.get(i).data+" ");
                }
            }
            System.out.println();



        }


    }

    public static void Kthlevel(Node root, int level,int k)
    {
        if(root==null)
        {
            return;
        }

        if(level == k)
        {
            System.out.print(root.data+" ");
            return;
        }

        Kthlevel(root.left,level+1,k);
        Kthlevel(root.right,level+1,k);
    }


  /*  public static boolean getPath(Node root, int n,ArrayList<Node>path)
    {
        if(root==null)
        {
            return false;
        }

        path.add(root);

        if(root.data == n)
        {
            return true;
        }

        boolean foundLeft=getPath(root.left,n,path);
        boolean foundRight=getPath(root.right,n,path);

        if(foundLeft||foundRight)
        {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    public static Node lca(Node root,int n1,int n2)
    {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n1,path2);

        

        for(int i=0;i<path1.size() && path2.size();i++)
        {
            if(path1.get(i)!=path2.get(i))
            {
                break;
            }
        }

        Node lca = path.get(i-1);
        return lca;


    }
    */


   public static Node lca2(Node root,int n1,int n2)
   {
       if(root == null)
       {
        return null;
       }
       
       
        if(root.data==n1|| root.data==n2)
        {
            return root;
        }

        Node leftlca =lca2(root.left,n1,n2);
        Node rightlca =lca2(root.right,n1,n2);

        if(rightlca== null)
        {
            return leftlca;
        }

        if(leftlca==null)
        {
            return rightlca;
        }

        return root;

   }

   public static int lcaDist(Node root,int n )
   {
        if(root==null)
        {
            return -1;
        }

        if(root.data==n)
        {
            return 0;
        }

        int leftDist = lcaDist(root.left,n);
        int rightDist = lcaDist(root.right,n);

        if(leftDist==-1 && rightDist==-1)
        {
            return -1;
        } 
        else if(leftDist==-1)
        {
            return rightDist+1;
        }
        else
        {
            return leftDist+1;
        }
   }


   public static int minDist(Node root, int n1, int n2)
   {
        Node lca = lca2(root,n1,n2);

        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);

        return dist1+ dist2;

   }

   public static int KAncester(Node root,int n,int k)
   {
        if(root == null)
        {
            return -1;
        }

        if(root.data ==n)
        {
            return 0;
        }

        int leftDist = KAncester(root.left,n,k);
        int rightDist = KAncester(root.right,n,k);

        if(leftDist == -1 && rightDist == -1)
        {
            return -1;
        }

        int max=Math.max(leftDist,rightDist);
        if(max+1 == k)
        {
            System.out.println(root.data);
        }

        return max+1;
   }


   public static int transfrom(Node root)
   {
        if(root == null)
        {
            return 0;
        }

        int leftChild = transfrom(root.left);
        int rightChild = transfrom(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0:root.left.data;
        int newRight = root.right == null ? 0:root.right.data;

        root.data= newLeft + leftChild + newRight + rightChild;
        return data;
   }

   public static void preorder(Node root)
   {
        if(root == null)
        {
            return ;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
   }


    public static void main(String args[])
    {

       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);


       Node subRoot= new Node(2);
       subRoot.left=new Node(4);
       subRoot.right=new Node(5);


      // System.out.println(diameter(root).diam);
       //System.out.println(diameter(root).ht);

      // System.out.println(isSubtree(root,subRoot));

      // topView(root);

    //  int k=2;
      //Kthlevel(root ,1 , k);

     //   int n1=4;
       // int n2=5;
      //  System.out.println(lca(root,n1,n2).data);

    //   int n1=4;
      // int n2=6;
       // System.out.println(lca2(root,n1,n2).data);

         //System.out.println(minDist(root,n1,n2));


        // int n=5;
       //  int k=1;

       //  KAncester(root,n,k);

       transfrom(root);
       preorder(root);


    }
}