import java.io.*;
import java.util.*;

public class breadthFirstTraversal {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }


   static class Pair{
      int u; // vertex
      String path;

      Pair(int u , String path){
         this.u = u;
         this.path = path;
      }
   }

   /*
        PROCESS->
        1) Seeding
        2) Remove the pair
        2) check for visited array
           -> if visited == true -> continue
           -> else do some work
        3) Mark src as visited and PRINT
        4) Add neighbours in queue , if they are not visted
   
   
   */
   public static void bft(ArrayList<Edge>[] graph , int src){
       boolean[] vis = new boolean[graph.length];

       Queue<Pair> qu = new LinkedList<>();
       qu.add(new Pair(src , src+""));

       while(qu.size() > 0){
          Pair rem = qu.remove();
          if(vis[rem.u] == true){
             continue;
          }

          vis[rem.u] = true;
          System.out.println(rem.u + "@" + rem.path);

          for(Edge e : graph[rem.u]){
             int nbr = e.nbr;

             if(vis[nbr] == false){
                qu.add(new Pair(nbr, rem.path + nbr));
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      bft(graph , src); 
   }
}
