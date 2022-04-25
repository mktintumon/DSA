import java.io.*;
import java.util.*;

public class shortestPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static class pair{
      int v;
      String path;
      int cost; // weight

      pair(int v , String path , int cost){
         this.v = v;
         this.path = path;
         this.cost = cost;
      }
   }

   public static void algo(ArrayList<Edge>[] graph , int src){
      int n = graph.length;

      PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
      });

      boolean[] vis = new boolean[n];

      pq.add(new pair(src , src+"" , 0));

    while(pq.size() > 0){
         pair rem = pq.remove();

        if(vis[rem.v] == false){
           System.out.println(rem.v + " via " + rem.path + " @ " + rem.cost);
        } 

        vis[rem.v] = true;

        for (Edge e : graph[rem.v]) {
            if (vis[e.nbr] == false) {
                pq.add(new pair(e.nbr,rem.path + e.nbr, rem.cost + e.wt));
            }
        }
    }

   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      algo(graph , src);
      
   }
}
