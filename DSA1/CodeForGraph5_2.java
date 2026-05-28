import java.util.*;


class CodeForGraph5_2
{

    static int n=4;
    static int par[]=new int[n];
    static int rank[]=new int[n];

      //krsukal algo
    static class Edge implements Comparable<Edge>
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

        @Override
        public int compareTo(Edge e2)
        {
            return this.wt-e2.wt;
        }
    }




    public static void createGraph(ArrayList<Edge> edges)
    {
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
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
    

    public static void kruskalsMST(ArrayList<Edge> edges,int V)
    {
        intit();
        Collections.sort(edges);
        int mstCost=0;
        int count=0;

        for(int i=0;count<V-1;i++)
        {
            Edge e = edges.get(i);

            //(src,dest,wt)

            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB)
            {
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }

        System.out.println("MST cost:"+mstCost);

    }


    
    public void helper(int[][]image,int sr,int sc,int color,int vis[][],int orgCol)
    {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length || vis[sr][sc]||image[sr][sc]!=orgCol)
        {
            return;
        }

        image[sr][sc]=color;


        //left
        helper(image, sr, sc-1, color,vis,orgCol);
        //right
        helper(image, sr, sc+1, color,vis,orgCol);
        //up
        helper(image, sr-1, sc, color,vis,orgCol);
        //down
        helper(image, sr+1, sc, color,vis,orgCol);

    }

    public int[][]floodFill(int[][]image,int sr,int sc,int color)
    {
        boolean vis[][]= new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }
    



    public static void main(String args[])
    {
       


     int V=4;
       ArrayList<Edge>edges =new ArrayList<>();
       createGraph(edges);
       kruskalsMST(edges,V); 
       

    


    }
}
