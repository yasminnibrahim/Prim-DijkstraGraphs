/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalds;
import java.util.*;

public class Dijkstra_algo {

    void print_path(Map<Integer,Integer> parent,int source,int dest,ArrayList<Integer> weights){
        System.out.println("From "+source+" to "+dest);
        Stack<Integer> s = new Stack<>();
        int end=0;
        while (end!=-10){
            end = parent.get(dest);
            if(end!=-10){
                s.push(end);
                s.push(dest);
            }
            dest = end;
        }
        int dest1;
        while (!s.isEmpty()){
            dest1 = s.pop();
            end = s.pop();
            System.out.println(end+"->"+dest1);
        }
        int sum=0;
        for(int i = 0; i < weights.size(); i++)
            sum += weights.get(i);
        System.out.println("Weight of path = "+sum+"\n");
    }
    void dijkstra_algo(int G[][],int s){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Map<Integer,Integer> parent = new HashMap<>();
        ArrayList<Integer> chain = new ArrayList<>();
        HashMap<Integer,Integer> dist = new HashMap<>();
        HashMap<Integer,Integer> values = new HashMap<>();
        HashMap<Integer,Integer> edges = new HashMap<>();
        HashMap<Integer,Integer> path_val = new HashMap<>();
        int index = s;
        System.out.println("Shortest path :\n");
        for (int i=0;i<G.length;i++)
        {
            if(i==s){
                dist.put(s,0);
                edges.put(i,0);
                continue;
            }
            edges.put(i,0);
            dist.put(i,Integer.MAX_VALUE);
        }
        parent.put(s,-10);
        while (edges.size()!=0){
            if(index==-10){
                index = edges.get(0);
                s=index;
                edges.clear();
                dist.clear();
                for (int i=0;i<G.length;i++)
                {
                    if(i==s){
                        dist.put(s,0);
                        edges.put(i,0);
                        continue;
                    }
                    edges.put(i,0);
                    dist.put(i,Integer.MAX_VALUE);
                }
                System.out.printf("The program will restart from node (%d) as it hava no in degree  \n\n",index);
                chain.clear();
                values.clear();
                parent.clear();
                parent.put(s,-10);
                path_val.clear();
            }
            for (int j=0;j<G.length;j++){
                if(G[index][j]!=0&&edges.containsKey(j)&&j!=index){
                    if(dist.get(j)>=dist.get(index)+G[index][j]){
                        dist.put(j,(dist.get(index)+G[index][j]));
                        priorityQueue.add(dist.get(j));
                        parent.put(j,index);
                        values.put(dist.get(j),j);
                        path_val.put(dist.get(j),G[index][j]);
                }
                }
            }
                if(priorityQueue.isEmpty()){
                    edges.remove(index);
                    index = parent.get(index);
                    if(chain.size()!=0)
                    chain.remove(chain.size()-1);
                    continue;
                }
                edges.remove(index);
                int min = priorityQueue.poll();
                int source =index;
                chain.add(path_val.get(min));
                index=values.get(min);
                path_val.clear();
                values.remove(min);
                print_path(parent,s,index,chain);
                edges.remove(source);
                priorityQueue.clear();
                    }
    }
}