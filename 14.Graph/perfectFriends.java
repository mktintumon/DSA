import java.io.*;
import java.util.*;

public class perfectFriends {

   public static class Edge{
      int src;
      int nbr;

      Edge(int src , int nbr){
         this.src = src;
         this.nbr = nbr;
      }
   }

    public static void getAllComp(ArrayList<Edge>[] graph , ArrayList<ArrayList<Integer>> comps){
      boolean[] visited = new boolean[graph.length];
    
      for(int v=0 ; v<graph.length ; v++){
          if(visited[v] == false){
             ArrayList<Integer> temp = new ArrayList<>();
             getSingleComp(graph , v , temp , visited);
             comps.add(temp);
          }
      }
   }

   
   
   public static void getSingleComp(ArrayList<Edge>[] graph , int src ,ArrayList<Integer> temp , boolean[] visited){
      temp.add(src);   
      visited[src] = true; 

    for(Edge e : graph[src]){
        if(visited[e.nbr] == false){
        getSingleComp(graph , e.nbr , temp , visited);
        }
    }
   }


   public static void solve(ArrayList<Edge>[] graph){
       ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
       getAllComp(graph , comps);

       int count = 0;
       for(int i=0 ; i<comps.size() ; i++){
          for(int j=i+1 ; j<comps.size() ; j++){
             int size1 = comps.get(i).size();
             int size2 = comps.get(j).size();

             count += size1 * size2;
          }
       }

       System.out.println(count);
   }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0 ; i<graph.length ; i++){
         graph[i] = new ArrayList<>();
      }   

      for (int i = 0; i < k; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);

         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

       solve(graph);
   }

}