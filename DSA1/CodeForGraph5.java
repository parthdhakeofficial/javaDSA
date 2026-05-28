import java.util.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


class CodeForGraph5
{

    

   //edge for cheapest flights for k stops
   static class Edge
    {
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int wt)
        {
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }

    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];


    //Edge for connenring cities
    static class CityEdge implements Comparable<CityEdge>
    {
        int dest;
        int cost;

        public CityEdge(int d,int c)
        {
            this.dest=d;
            this.cost=c;
        }

        @Override
        public int compareTo(CityEdge e2)
        {
            return this.cost-e2.cost;//ascending
        }
    }

   
    public static int connectCities(int cities[][])
    {
        PriorityQueue<CityEdge>pq=new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];

        pq.add(new CityEdge(0,0));
        int finalCost=0;

        while(!pq.isEmpty())
        {
            CityEdge curr=pq.remove();
            if(!vis[curr.dest])
            {
                vis[curr.dest]=true;
                finalCost+=curr.cost;

                for(int i=0;i<cities[curr.dest].length;i++)
                {
                    if(cities[curr.dest][i]!=0 && !vis[i])
                    {
                        pq.add(new CityEdge(i,cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }


    public static void createGraph(ArrayList<Edge> graph[])
    {
       /*  int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++)
        {
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];

            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
*/




    }

   



    static class Info
    {
        int v;
        int cost;
        int stops;

        public Info(int v,int c, int s)
        {
            this.v=v;
            this.cost=c;
            this.stops=s;

        }
    }

    public static int cheapestFlight(int n,int src,int dest,int k)
    {
        ArrayList<Edge> graph[]= new ArrayList[n];
        createGraph(graph);

        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=src)
            {
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue <Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

         
        
        while(!q.isEmpty())
        {
         Info curr = q.remove();


            
            if(curr.stops>k)
            {
                break;
               
            }

            for(int i=0;i<graph[curr.v].size();i++)
        {
            Edge e= graph[curr.v].get(i);
            int u=e.src;
            int v=e.dest;
            int wt=e.wt;

            if(dist[u]!=Integer.MAX_VALUE && curr.cost+wt<dist[v]&& curr.stops<=k)
            {
                dist[v]=dist[u]+wt;
                q.add(new Info(v,dist[v],curr.stops+1));
            }
        }
        }

        

        //dist[dest]
        if(dist[dest]==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return dist[dest];
        }
    }


    public static void intit()
    {
        for(int i=0;i<n;i++)
        {
          
                par[i]=i;
            
        }

    }

    public static int find(int x)
    {
        if(x==par[x])
        {
            return x;
        }

        return find(par[x]);
    }

    public static void union(int a,int b)
    {
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]== rank[parB])
        {
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB])
        {
            par[parA]=parB;
        }
        else
        {
            par[parB]=parA;
        }

    }
    

    public static void main(String args[])
    {
        /*int n=4;
       // int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dest=3;
        int k=1;

    //  System.out.println(cheapestFlight( n, src, dest, k)); 
    */    


   /*int cities[][]={{0,1,2,3,4},
                    {1,0,5,0,7},
                    {2,5,0,6,0},
                    {3,0,6,0,0},
                    {4,7,0,0,0}};

                     System.out.println(connectCities( cities));
*/

     /*   intit();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
        */

      



    }

   

}