import java.util.*;

import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

class QueueProblems
{
  /*  public static void printNonRepeating(String str)
    {
        int freq[]=new int[26];
        Queue<Character> q= new LinkedList<>();

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1)
            {
                q.remove();
            }

            if(q.isEmpty())
            {
                System.out.print(-1+" ");
            }
            else
            {
                System.out.print(q.peek()+" "); 
            }
            System.out.println();
        }

    }
    */

/*
    //interleave two halves of queue
    public static void interLeave(Queue <Integer> q)
    {
        Queue<Integer> firstHalf =new LinkedList<>();
        int size =q.size();

        for(int i=0;i<size/2;i++)
        {
            firstHalf.add(q.remove());

        }

        while(!firstHalf.isEmpty())
        {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

    }
    */
/*
    public static void reverse(Queue <Integer> q)
    {
        Stack <Integer> s = new Stack<>();

        while(!q.isEmpty())
        {
            s.push(q.remove());
        }

        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
    }*/

    //implementation Stack using Deque
    static class Stack
    {
        Deque <Integer> deque = new LinkedList<>();

        public void push(int data)
        {
            deque.addLast(data);
        }

        public int pop()
        {
            return deque.removeLast();
        }

        public int peek()
        {
            return deque.getLast();
        }
    }

     //implementation queue using Deque
     static class Queue
     {
        Deque<Integer> deque =new LinkedList<>();

        public void add(int data)
        {
            deque.addLast(data);
        }

        public int pop()
        {
            return deque.removeFirst();
        }

        public int peek()
        {
            return deque.getFirst();
        }
     }

    public static void main(String args[])
    {
       // String str="aabccxb";
        //printNonRepeating( str);

      /*  Queue<Integer> q =new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        //interLeave(q);
/*
        

       /* while(!q.isEmpty())
        {
            System.out.print(q.remove()+" ");
        }
        System.out.println();*/

       /* reverse(q);

        while(!q.isEmpty())
        {
            System.out.print(q.remove()+" ");
        }*/

      /* Deque<Integer> deque = new LinkedList<>();

       deque.addFirst(1);
       deque.addFirst(2);
       deque.addLast(3);
       deque.addLast(4);
       System.out.println(deque);
       deque.removeFirst();
       System.out.println(deque);
       deque.removeFirst();
       System.out.println(deque);

       System.out.println("first el ="+ deque.getFirst());
       System.out.println("last el="+ deque.getLast());
       */
/*
      Stack ss = new Stack();
      ss.push(1);
      ss.push(2);
      ss.push(3);
      System.out.println("peek="+ss.peek());
      System.out.println(ss.pop());
      System.out.println(ss.pop());
      System.out.println(ss.pop());
      */

     Queue q =new Queue();

     q.add(1);
     q.add(2);
     q.add(3);

     System.out.println(q.peek());

    System.out.println( q.pop());
     System.out.println( q.pop());
      System.out.println( q.pop());
   
   

    }
}