import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

class CodeForGraph1
{
    static class Edge
    {
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w)
        {
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph( ArrayList<Edge>[] graph )
    {
         for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }

    /* graph a
       //0->vertex
        graph[0].add(new Edge(0,1,5));

        //1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));

        //3 vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //4 vertex
        graph[4].add(new Edge(4,2,2));

        //2's neighbors
        for(int i=0;i<graph[2].size();i++)
        {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
*/

        //graph b

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[4].add(new Edge(6,5,1));
       

    }

    /**Breath first Search
     * its like level order
     * queue is used as data structure
     * a node is visited and and all connected node are visited
     * and then moved to another node
     */

    public static void bfs(ArrayList<Edge>[]graph)
    {
        boolean vis[]=  new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                bfsUtil(graph,vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph,boolean vis[])
    {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[]=  new boolean[graph.length];

        q.add(0);//source
        
        while(!q.isEmpty())
        {
            int curr=q.remove();

            if(!vis[curr])  //visit curr
            {
                System.out.print(curr+" ");
                vis[curr]=true;

                for(int i=0;i<graph[curr].size();i++)
                {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    /**
     * Depth First Search
     * -its like preorder
     * -stack is used as data strutcure
     * -in dfs a node is visited and then only one adjacent node is visited and it goes on
     */

    public static void dfs(ArrayList<Edge>[]graph)
    {
        boolean vis[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            dfsUtil(graph,i,vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[]graph,int curr,boolean vis[])
    {
        //visit
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                dfsUtil(graph,e.dest,vis);
            }
        }
    }

    //find path by dfs
    public static boolean hasPath(ArrayList<Edge>[]graph,int src,int dest, boolean vist[])
    {
        //root case
        if(src==dest)
        {
            return true;
        }

        vist[src]=true;
        for(int i=0;i<graph[src].size();i++)
        {
            Edge e= graph[src].get(i);
            //e.dest = neighbour
            if(!vist[e.dest] && hasPath(graph,e.dest,dest,vist))
            {
                return true;
            }


        }
        return false;
    }

    public static void main(String args[])
    {
        /**
         * graph a
         *    (5)
         * 0---------1
         *      (1)/   \
         *        /     \ (3)
         *       /       \
         *      2---------3
         *      |   (1)
         *  (2) |
         *      |
         *      4
         */
     /*   int V=5;
        //int arr[]=new arr[V];
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);
        */


       /** graph b
        *     1----3
        *    /     | \
        *   0      |  5---6
        *    \     | / 
        *      2---4
        */

        int V=7;
        @SuppressWarnings("unchecked")

        //int arr[]=new arr[V];
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);
     //   bfs(graph);

      //  dfs(graph,0,new boolean[V]);

        System.out.println(hasPath(graph,0,5,new boolean[V]));

       




    }
    
}