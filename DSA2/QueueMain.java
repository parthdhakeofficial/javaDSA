import java.util.*;

class QueueMain
{

  
    static class Queue
    {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n)//using array
        {
            arr=new int[n];
            size=n;
            rear=-1;
        }

        public static boolean isEmpty()
        {
            return rear==-1;
        }
        
        //add fun
        public static void add(int data)
        {
            if(rear==size-1)
            {
                System.out.println("queue is full");
                return;
            }

            rear=rear+1;
            arr[rear]=data;
        }

        //remove
        public static int remove()
        {
            if(isEmpty())
            {
                System.out.println("empty queue");
                return -1;

            }

            int front=arr[0];
            for(int i=0;i<rear;i++)
            {
                arr[i]=arr[i+1];
            }
            rear=rear-1;

            return front;
        }

           //peek
    public static int peek()
    {
         if(isEmpty())
            {
                System.out.println("empty queue");
                return -1;

            }

            return Queue.arr[0];
    }
    }

 //circularQueue
 static class circularQueue
    {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        circularQueue(int n)//using array
        {
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }

        public static boolean isEmpty()
        {
            return rear==-1 && front==-1;
        }

        public static boolean isFull()
        {
            return (rear+1)%size== front;
        }
        
        //add fun
        public static void add(int data)
        {
            if(isFull())
            {
                System.out.println("queue is full");
                return;
            }
            if(front==-1)
            {
                front=0;
            }

            rear=(rear+1)%size;
            arr[rear]=data;
        }

        //remove
        public static int remove()
        {
            if(isEmpty())
            {
                System.out.println("empty queue");
                return -1;
            }

            int result=arr[front];
            
           
            
            if(rear==front)
            {
                rear=front=-1;
            }
            else
            {
                front=(front+1)%size;
            }

            return result;
        }

           //peek
    public static int peek()
    {
         if(isEmpty())
            {
                System.out.println("empty queue");
                return -1;

            }

            return arr[front];
    }
    }

        //USING LINKEDLIST
          static class Node
        {
            int data;
            Node next;

            Node(int data)
            {
                this.data=data;
                this.next=null;
            }
        }

        static class QueueUsingLinkedList
        {
            static Node head=null;
            static Node tail=null;

           

            public static boolean isEmpty()
            {
                return head==null && tail==null;
            }
            
            //add fun
            public static void add(int data)
            {
               Node newNode=new Node(data);
               if(head==null)
               {
                head=tail=newNode;
                return;
               }
               tail.next=newNode;
               tail= newNode;
            }

            //remove
            public static int remove()
            {
                if(isEmpty())
                {
                    System.out.println("empty queue");
                    return -1;

                }

                int front = head.data;
                //single element
                if(tail==head)
                {
                    tail=head=null;
                }
                else
                {
                    head=head.next;
                }

                return front;
            }

            //peek
        public static int peek()
        {
            if(isEmpty())
                {
                    System.out.println("empty queue");
                    return -1;

                }

                return head.data;
        }
    }

    

    public static void main(String args[])
    {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);


        //declare queue using java collection framework
        //Queue<Integer>q=new LinkedList<>();
        /**
         * we can declare queue using two classes
         * linkedlist
         * arraydeque
         * we can declare queue as queue bcoz queue is interface
         * 
         */


        while(!Queue.isEmpty())
        {
            System.out.println(q.peek());
            q.remove();
        }
    }

}