import java.util.*;
//import java.util.LinkedList;

public class LinkedList
{
    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    public void addFirst(int data)
    {
        //step1=create a new node
        Node newNode = new Node(data);
        size++;

        if(head==null)
        {
            head=tail=newNode;
            return;
        }

        //step2=newnode next=head
        newNode.next=head; //link

        //step 3= head =newnode
        head=newNode;

    }

    public void addLast(int data)
    {
        //step1=create a new node
        Node newNode = new Node(data);
        size++;

        if(head==null)
        {
            head=tail=newNode;
            return;
        }

        //step2=newnode next=head
        tail.next=newNode; //link

        //step 3= head =newnode
        tail=newNode;

    }

    public void print()
    {
        if(head==null)
        {
            System.out.println("ll is empty");
            return;
        }

        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx,int data)
    {
        if(idx==0)
        {
            addFirst(data);
            return;
        }

        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1)
        {
            temp=temp.next;
            i++;
        }

        //i=idx-1; temp->prev
        newNode.next=temp.next;
        temp.next=newNode;



    }

    public int removeFirst()
    {
        if(size==0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1)
        {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast()
    {
         if(size==0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1)
        {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        //prev:size-2
        Node prev=head;
        for(int i=0;i<size-2;i++)
        {
            prev=prev.next;
        }

        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;


    }

//search key in iterative way
    public int itrSearch(int key)
    {
        Node temp=head;
        int i=0;

        while(temp!=null)
        {
            if(temp.data==key)
            {
                return i;
            }
            temp=temp.next;
            i++;
        }
        //key not found
        return -1;
    }

//search key using recursion

//helper fun for recurrsion search

    public int helper(Node head , int key)
    {
        if(head==null)
        {
            return -1;
        }

        if(head.data==key)
        {
            return 0;
        }

        int idx=helper(head.next,key);
        if(idx==-1)
        {
            return -1;
        }

        return idx+1;
    }


    public void reverse()
    {
        Node prev =null;
        Node curr=tail = head;  //in java value are assgained right to lrft 
        Node next;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }


    public int recSearch(int key)
    {
        return helper( head , key);
    }


    //find and remove nth node from front
    public void removeNthNodeFromEnd(int n)
    {

        //calculate size
        int sz=0;
        Node temp=head;

        while(temp!=null)
        {
            temp=temp.next;
            sz++;
        }

        //remove first
        if(n==sz)
        {
            head=head.next;
            return;
        }

        //sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        
        while(i<iToFind)
        {
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
        return;
    }


    //CHECK linkedlist is panlindrome

    //slow fast approach
    //to find mid
    public Node findMid(Node head)
    {
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next; //+1
            fast=fast.next;//+2
        }
        return slow;
    }

    public boolean checkPanlindrome()
    {
        if(head==null||head.next==null)
        {
            return true;
        }

        //step1-find mid
        Node midNode=findMid(head);

        //step2-reverse 2nd half 
        Node prev=null;
        Node curr=midNode;
        Node next;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;//right half head
        Node left=head;

        //step3-cheak right and left half
        while(right!=null)
        {
            if(left.data!=right.data)
            {
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;

    }

    //to find is cycle means like a vesion of circular linked list where it can also be linked in middle node
    //detect a cycle in linked list
    public static boolean isCycle()
    {
        Node slow =head;
        Node fast= head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next; //+1
            fast=fast.next.next;    //+2

           if( slow==fast)
           { //cycle exits
            return true;
           }
        }
        return false; //cycle doesn't exits
    }


    public static void removeCycle()
    {
        //detcet cycle
        Node slow =head;
        Node fast= head;
        boolean cycle=false;// to check cycle is presenrt
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next; //+1
            fast=fast.next.next;    //+2
            if(fast==slow)
            {
                cycle=true;
                break;
            }
          
        
        }
          if(cycle ==false)
            {
                return;
            }

        // find meeting point
        /**to find meeeting point 
         * when slow==fast
         * slow=head;
         * fast still where slow==fast
         * now both slow and fast =+1
         * i.e. slow=+1 fast=+1
         * and then last node = previous of fast 
         * make last node point to NULL 
         * cycle removed
         */

        slow=head;
        Node prev=null;//last node

        while(slow!=fast)
        {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //remove cycle
        //last node->null
        prev.next=null;
    }

    //MERGESORT on linkedlist

    private static Node getMid(Node head)
    {
        Node slow=head;
        Node fast=head.next;

        while(fast!=null&& fast.next!=null)
        {
            slow =slow.next;
            fast=fast.next.next;

        }
        return slow;//mid node

    }


    private static Node merge(Node head1,Node head2)
    {
        Node mergeLL=new Node(-1);
        Node temp=mergeLL;

        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while(head1!=null)
        {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null)
        {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergeLL.next;
    }


    public static Node mergeSort(Node head)
    {
        //base case
        if (head==null||head.next==null)
        {
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left Z& right ms
        Node rightHead= mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }


/*
    public static void zigZag()
    {
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null)
        {
           slow=slow.next;
           fast=fast.next.next;
        }
        Node mid=slow;

        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        
        while(curr!=null)
        {
            next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }


        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        //alt merge-zigzag merge
        while(left !=null && right!=null)
        {
            nextL=left.next;
            left.next=right;
            if(nextL==null)
            { break;}
            nextR=right.next;
            right.next=left;

            left=nextL;
            right=nextR;
        }

    }*/

    //copy
    public static void zigZag() {
    // Step 1: Find the mid-point
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    Node mid = slow;

    // Step 2: Reverse the second half
    Node curr = mid.next;
    mid.next = null; // Break the first half from the second half
    Node prev = null;
    Node next;

    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // Step 3: Zigzag merge (alternate merge)
    Node left = head;
    Node right = prev; // Head of the reversed second half
    Node nextL, nextR;

    while (left != null && right != null) {
        nextL = left.next;  // Store the next node of left
        left.next = right;  // Link current left node to right
        if (nextL == null) {
            break; // Break if no more nodes in the left half
        }
        nextR = right.next; // Store the next node of right
        right.next = nextL; // Link current right node to next left

        // Move pointers forward
        left = nextL;
        right = nextR;
    }
}




    public static void main(String args[])
    {
      LinkedList l1 = new LinkedList();


       // l1.print();
       // l1.addFirst(2);
        //l1.print();
       /// l1.addFirst(1);
       // l1.print();
      //  l1.addLast(3);
       // l1.print();
        //l1.addLast(4);
       // l1.print();

        //l1.add(2,9);
        //l1.print();

      //  System.out.println(l1.size);
       // l1.removeFirst();
      //  l1.print();

        //l1.removeLast();
      //  l1.print();
        //System.out.println(l1.size);

      //  l1.add(3,8);
        //l1.add(1,10);
        //l1.print();
        //caling merge sort
        ///l1.head= l1.mergeSort(l1.head);
        //l1.print();
       

       // System.out.println(l1.itrSearch(3));

       // System.out.println(l1.recSearch(3));
       //l1.reverse();
       //l1.print();

        //l1.removeNthNodeFromEnd(3);
       // l1.print();

      //  System.out.println(l1.checkPanlindrome()); */
       
       /* head=new Node(1);
        head.next=new Node(2);
       // head.next=temp;
        head.next.next=new Node(3);//insufficint/improper data
        head.next.next.next=head;*/
       
      //  head=new Node(1);
        //Node temp=new Node(2);
      //  head.next=temp;
        //head.next.next=new Node(3);
        //head.next.next.next=temp;
        //1->2->3->2

       // System.out.println(isCycle());
     //   removeCycle();
        //System.out.println(isCycle());

        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.print();
        l1.zigZag();
        l1.print();


    /**INbuit functions of linked list */
    //import java.util.LinkedList
    //creating linked list
   // java.util.LinkedList<Integer>ll=new java.util.LinkedList<>();

    //add
   /* ll.addLast(1);
    ll.addLast(2);
    ll.addFirst(0);
    //0->1->2
    System.out.println(ll);
    //remove
    ll.removeLast();
    ll.removeFirst();
    System.out.println(ll);
    */




















    }




}