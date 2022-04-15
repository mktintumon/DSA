import java.io.*;
import java.util.*;

// for checking connected graph -> [ components.size() == 1 ]-> return true or false

public class getConnectedComp {
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

   // func for all component 
   public static void getAllComp(ArrayList<Edge>[] graph , ArrayList<ArrayList<Integer>> comps){
      boolean[] visited = new boolean[graph.length];
    
      // travel in vertices in a loop
      for(int v=0 ; v<graph.length ; v++){
          if(visited[v] == false){
             ArrayList<Integer> temp = new ArrayList<>();
             getSingleComp(graph , v , temp , visited);
             comps.add(temp);
          }
      }
   }

   
   // func for getting single component
   public static void getSingleComp(ArrayList<Edge>[] graph , int src ,ArrayList<Integer> temp , boolean[] visited){
       
    temp.add(src);   // add
    visited[src] = true; // mark

    for(Edge e : graph[src]){
        // check for nighbour marking and call to neighbour
        if(visited[e.nbr] == false){
        getSingleComp(graph , e.nbr , temp , visited);
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      // call
      getAllComp(graph , comps);

      System.out.println(comps);
   }
}