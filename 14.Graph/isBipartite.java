import java.io.*;
import java.util.*;

public class isBipartite {
   /*
      CONCEPT 

      1) Not cyclic -> bipartite
      2) cyclic
               --> even length -> bipartite
               --> odd length ->  not bipartite
   
      NOTE :-
           * Odd length cycle -> if levels for same vertex is different
           * Even length cycle -> if levels for same vertex is same  
   
   */
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

   public static class Pair{
      int v;
      int level;

      Pair(int v , int level){
          this.v = v;
          this.level = level;
      }
   }


   public static boolean bipartite(ArrayList<Edge>[] graph , int src , int[] visited){
      Queue<Pair> qu = new LinkedList<>();
      qu.add(new Pair(src , 0));

      // remove -> mark -> work -> add
      while(qu.size() != 0){
         Pair rem = qu.remove();

         if(visited[rem.v] != -1){
             // check for level -> if different level means odd length cycle
             if(rem.level != visited[rem.v]){
                return false;
             }
         }
         else{
            visited[rem.v] = rem.level;
         }

         for(Edge e : graph[rem.v]){
            if(visited[e.nbr] == -1){
               qu.add(new Pair(e.nbr , rem.level+1));
            }
         }
      }

      return true;
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

      int[] visited = new int[vtces];
      Arrays.fill(visited , -1);

      for(int v=0 ; v<vtces ; v++){
         if(visited[v] == -1){
            boolean checkBipartite = bipartite(graph , v , visited);
            if(checkBipartite == false){
               System.out.println("false");
               return;
            }
         }
      }

      System.out.println("true");
   }
}
