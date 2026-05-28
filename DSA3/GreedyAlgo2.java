import java.util.*;

public class GreedyAlgo2
{
    static class Job
    {
        int deadline;
        int profit;
        int id;

        public Job(int i,int d,int p)
        {
            id=i;
            deadline=d;
            profit=p;
        }

    }


    public static void main(String args[])
    {
        //job sequencing
        /*
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};

       ArrayList<Job> jobs = new ArrayList<>();

for (int i = 0; i < jobsInfo.length; i++) {
    jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
}

Collections.sort(jobs, (a, b) -> b.profit - a.profit);


        ArrayList<Integer> seq = new ArrayList<>();

        int time=0;

        for(int i=0;i<jobs.size();i++)
        {
            Job curr= jobs.get(i);

            if(curr.deadline>time)
            {
                seq.add(curr.id);
                time++;
            }
        }

        //print seq
        System.out.println("max jobs="+seq.size());
        for(int i=0;i<seq.size();i++)
        {
            System.out.println(seq.get(i)+" ");
        }
        System.out.println();
*/

        //chocola problem
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4}; //m-1
        Integer costHor[]={4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0 ;
        int v=0;
        int hp=1;
        int vp=1;
        int cost=0;

        while(h<costHor.length && v<costVer.length)
        {
            if(costVer[v]<=costHor[h])
            {//horizontal cut
                cost+=(costHor[h]*vp);
                hp++;
                h++;

            }
            else //vertical cut
            {
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h< costHor.length)
        {
            cost+=(costHor[h]*vp);
            hp++;
            h++;
        }

        while(v<costVer[v]*hp)
        {
             cost+=(costVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println("min cost of cuts"+cost);

    }
}