/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalds;
import java.util.*;

public class Prim {
    private final int m = 10000;
    void print_path(int a,int b,int w){
        System.out.println(" "+a+" ---> "+b+"\t  "+w);
    }
    void prim_algo(int G[][]){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        System.out.println("From   To\tWeight");
        Map<Integer,Integer> edges = new HashMap();
        HashMap<Integer,Integer> val = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<HashMap<Integer,Integer>> values = new ArrayList<>();
        edges.put(0,0);
        for (int i=1;i<G.length;i++)
        {
            edges.put(i,Integer.MAX_VALUE);
        }
        int index=0;
        while (edges.size()!=0){
            if (edges.containsKey(index)){
                for (int j=0;j<G.length;j++)
                {
                    if(G[index][j]!=0&&edges.containsKey(j)){
                        if(G[index][j]<edges.get(j)){
                            priorityQueue.add(G[index][j]);
                            val.put(G[index][j],j);
                            val.put(m,index);
                        }
                    }
                }}
            edges.remove(index);
            union.add(index);
            if(values.isEmpty()){
                int min = priorityQueue.poll();
                print_path(val.get(m),val.get(min),min);
                index = val.get(min);
                val.remove(min);
                HashMap<Integer,Integer> map2 = new HashMap<>();
                map2.putAll(val);
                values.add(map2);
                val.clear();
            }
            else {
                int min = priorityQueue.poll();
                int source=0;
                HashMap<Integer,Integer> map2 = new HashMap<>();
                map2.putAll(val);
                values.add(map2);
                val.clear();
                int dest=0;
                for(int i=0;i<values.size();i++){
                    if(values.get(i).containsKey(min)){
                        source = values.get(i).get(m);
                        dest = values.get(i).get(min);
                        values.get(i).remove(min);
                        break;
                    }
                }
                if(!union.contains(dest)){
                    print_path(source,dest,min);
                    index = dest;
                }
            }}
    }
}

