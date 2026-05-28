import java.util.*;

class MainStack
{
  /*  static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    static class StackLinkedList
    {
        //  //stack using linkedlist
        //top = head
        static Node head =null;


        public static boolean isEmpty()
        {
            return head == null;
        }

        //push
        public static void push(int data)
        {
            Node newNode= new Node(data);

            if(isEmpty())
            {
                head=newNode;
                return;
            }
            newNode.next=head;
            head= newNode;
        }

        //pop
        public static int pop()
        {
            if(isEmpty())
            {
                return -1;
            }

            int top=head.data;
            head=head.next;
            return top;

        }

        //peek
        public static int peek()
        {
             if(isEmpty())
            {
                return -1;
            }

            return head.data;
        }

    }/*

  /*  static class StackArrayList
    {
       
        //stack using arraylist
         static ArrayList<Integer>list=new ArrayList<>();

            //is Empty
            public static boolean isEmpty()
            {
                return list.size()==0;
            }

            //isfull not applicable as aaraylist is dyanamic(not fixed) in size.

            //push
            public static void push(int data)
            {
                list.add(data);
            }

            //peek
            public static int peek()
            {
                //base case
                if(isEmpty())
                {   return -1;  }

                //return top
                return list.get(list.size()-1);
            }

            //pop
            public static int pop()
            {
                  //base case
                if(isEmpty())
                {   return -1;  }

                //to store value before delete
                int top = list.get(list.size()-1);
                //delete value
                list.remove(list.size()-1);
                return top;
            }

       
               
        }*/

       //imp
       public static void pushAtBottom(Stack<Integer>s,int data)
       {
            if(s.isEmpty())
            {
                s.push(data);
                return;
            }
            
            int top = s.pop();
            pushAtBottom(s,data);
            s.push(top);
       }

       public static String reverseString(String str)
       {
            Stack<Character> s = new Stack <>();
            int idx=0;
            while(idx<str.length())
            {
                s.push(str.charAt(idx));
                idx++;
            } 

            StringBuilder result = new StringBuilder("");
            while(!s.isEmpty())
            {
                char curr= s.pop();
                result.append(curr);
            }

            return result.toString();
       }

       public static void reverseStack(Stack<Integer> s)
       {
            if(!s.isEmpty())
            {
                return;
            }

            int top=s.pop();
            reverseStack(s);
            pushAtBottom(s,top);
       }

        public static void printStack(Stack<Integer> s)
        {
            while(!s.isEmpty())
                {   
                    System.out.println(s.peek());
                    s.pop();
                }
        }

        //Stock span problem
        /**
         * span -> max no of consectivr days for which price <= today price
         * 
         */

        public static void stockSpan(int stocks[],int span[])
        {
            Stack <Integer> s= new Stack<>();
            span[0]=1;
            s.push(0);

            for(int i=1;i<stocks.length;i++)
            {
                int currPrice=stocks[i];
                while(!s.isEmpty() && currPrice > stocks[s.peek()])
                {
                    s.pop();

                }
                if(s.isEmpty())
                {
                    span[i]=i+1;
                }
                else
                {
                    int prevHigh=s.peek();
                    span[i]=i-prevHigh;
                }

                s.push(i);
            }
        }


        //find next greater element code
        public static void findNxtGreater(int arr[],Stack<Integer> s,int nxtgreater[])
        {
             for(int i=arr.length-1;i>=0;i--)
              {
                //1 while
                while(!s.isEmpty() && arr[s.peek()]<= arr[i])
                {
                    s.pop();
                }

                //2 if-else
                if(s.isEmpty())
                {
                    nxtgreater[i]=-1;
                }
                else
                {
                    nxtgreater[i]=arr[s.peek()];
                }

                //3 push in s
                s.push(i);

              }

              for(int i=0;i<nxtgreater.length;i++)
              {
                System.out.print(nxtgreater[i]+" ");
              }
              System.out.println();


            }

        


        public static void main(String args[])
            {
                //Stack s = new Stack();


               /* Stack<Integer> s =new Stack<>();

                s.push(1);
                s.push(2);
                s.push(3);

                //pushAtBottom(s,4);

               /* while(!s.isEmpty())
                {   
                    System.out.println(s.peek());
                    s.pop();
                }*/

               /* String str="abc";
                String result = reverseString(str);
                System.out.println(result);
                */

               /*
            
               reverseStack(s);
               printStack(s);*/


               /*int stocks[]={100,80,60,70,60,85,100};
               int span[]=new int[stocks.length];
               stockSpan(stocks,span);

               for (int i=0;i<span.length;i++)
               {
                    System.out.println(span[i]+" ");
               }*/

              //find nxt grater no
              int arr[]={6,8,0,1,3};
              Stack<Integer> s = new Stack<>();
              int nxtgreater[]=new int[arr.length];

              findNxtGreater( arr, s, nxtgreater);
            

             
            }

     
        }
        