import java.util.*;

class GraphSupplemental
{

    static int n=4;
    static int par[]=new int[n];
    static int rank[]=new int[n];

      
    static class Edge 
    {
        int src;
        int dest;
        
        public Edge(int s,int d)
        {
            this.src=s;
            this.dest=d;
           
        }

     
    }



    @SuppressWarnings("unchecked")

    public static void createGraph(ArrayList<Edge>[] graph)
    {
        for (int i = 0; i < graph.length; i++) 
        {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }



    public static void topSort(ArrayList<Edge>graph[],int curr,boolean[] vis, Stack<Integer>s)
    {
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e= graph[curr].get(i);
            if(!vis[e.dest])
            {
               topSort(graph,e.dest,vis,s);
             
            }
        }

        s.push(curr);
    } 

   


    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[])
    {
        vis[curr]=true;
        System.out.println(curr+" ");

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e= graph[curr].get(i);
            if(!vis[e.dest])
            {
               //topSort(graph,e.dest,vis,s);
               dfs(graph,e.dest,vis);
            }
        }

    }

    

    @SuppressWarnings("unchecked")

    public static void kosaraju(ArrayList<Edge> graph[],int V)
    {
        //Step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[]= new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                topSort(graph,i,vis,s);
            }
        }

        //Step2
        ArrayList<Edge>transpose[]=new ArrayList[V];

        for(int i=0;i<V;i++)
        {
           transpose[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                Edge e= graph[i].get(j);
                //e.src->e.dest
                transpose[e.dest].add(new Edge(e.dest,e.src));//reverse edge
            }
        }

        //step3

        Arrays.fill(vis, false);

        while(!s.isEmpty())
        {
            int curr=s.pop();
            if(!vis[curr])
            {
                System.out.print("SCC->");
                dfs(transpose,curr,vis);
                System.out.println();
            }
        }


    }


    // TarajanAlgo_bridgeInGraph
    public static void createGraph2(ArrayList<Edge>graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));

    }

    public static void dfs2(ArrayList<Edge>graph[],int curr, int par,int dt[], int lowdt[],boolean vis[], int time[])
    {
        vis[curr]=true;
        dt[curr]=lowdt[curr]=++time[0];

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e= graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par)
            {
                continue;
            }
            else if(!vis[neigh])
            {
                dfs2(graph, neigh,  par, dt, lowdt, vis, time);
                lowdt[curr]=Math.min(lowdt[curr],lowdt[neigh]);
                if(dt[curr]<lowdt[neigh])
                {
                    System.out.println("BRidge:"+curr+"----"+neigh);
                }
            }
            else
            {
                lowdt[curr]=Math.min(lowdt[curr],dt[neigh]);          
            }
        }


    }

    public static void tarjanBridge(ArrayList<Edge>graph[],int V)
    {
        int dt[]=new int[V];
        int lowdt[]=new int[V];
        int time[]= {0};
        boolean vis[] = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs2(graph,i,-1,dt,lowdt,vis,time);
            }
        }

    }

     // TarajanAlgo_ArculationPoint
    public static void createGraph3(ArrayList<Edge>graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
       

        graph[4].add(new Edge(4,3));
       
    }


    public static void dfs3(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],int time,boolean vis[],boolean ap[])
    {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int childern =0;

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            
            if(par == neigh)
            {
                continue;
            }
            else if(vis[neigh])
            {
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
            else
            {
                dfs3(graph,neigh,curr,dt,low,time,vis,ap);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(par!=-1 && dt[curr]<= low[neigh])
                {
                   // System.out.println("Ap :"+curr);
                   ap[curr]=true;
                }
                childern ++;
            }
        }

        if(par==-1 && childern>1)
        {
           // System.out.println("Ap:"+curr);
           ap[curr]=true;
        }


    }

    public static void getAP(ArrayList<Edge>graph[],int V)
    {
        int dt[]= new int[V];
        int low[]= new int[V];
        int time=0;
        boolean vis[]= new boolean[V];
        boolean ap[]= new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs3(graph,i,-1,dt,low,time,vis,ap);
            }
        }

        //print all Aps
        for(int i=0;i<V;i++)
        {
            if(ap[i])
            {
                System.out.println("Ap:"+i);
            }
        }


    }

    public static void main(String args[])
    {

    //Strongly connected componenets in graph
   /*  int V=5;

      ArrayList<Edge>graph[]=new ArrayList[V];
      createGraph(graph);

      kosaraju( graph, V);
      */

    // TarajanAlgo_bridgeInGraph
   /* int V=6;

    ArrayList<Edge> graph[]= new ArrayList[V];
    createGraph2(graph);
    tarjanBridge(graph,V);
    */

   //arculationPoint
   int V=5;

   ArrayList<Edge> graph[]= new ArrayList[V];
   createGraph3(graph);

   getAP(graph,V);

    }
}