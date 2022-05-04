import Node.NodeS;

import java.util.*;

public class Graph {
    HashMap<Integer,SinglyLinkedList> h;
   public Graph()
    {
        h=new HashMap<>();
    }
    public void insert(int v,int add,boolean edge){
       SinglyLinkedList l=h.getOrDefault(v,new SinglyLinkedList());
       l.add(add);
       h.put(v,l);
       if(edge==true)
       {
           SinglyLinkedList l1=h.getOrDefault(add,new SinglyLinkedList());
           l1.add(v);
           h.put(add,l1);
       }
    }
    public void BFS_traversal(int source){
       Queuebylinkedlist q=new Queuebylinkedlist();
       q.enqueue(source);
       HashSet<Integer> s= new HashSet();
       s.add(source);
       while(!q.isempty()){
           int front=q.dequeue();
           System.out.println(front);
           SinglyLinkedList l=h.getOrDefault(front,new SinglyLinkedList());
           NodeS temp=l.head;
           while(temp!=null) {
               if (!s.contains(temp.data)) {
                   q.enqueue(temp.data);
                   s.add(temp.data);
               }
               temp=temp.next;
           }
       }
    }
    public void DFS_traversal(int source,boolean[] visited){
        //System.out.println(source);
        visited[source]=true;
        Stack<Integer> s=new Stack<>();
        s.push(source);
       /* SinglyLinkedList s=h.get(source);
        NodeS temp=s.head;
        while(temp!=null){
            if(!visited[temp.data])
                DFS_traversal(temp.data,visited);
            temp=temp.next;
        }*/
        while(!s.isEmpty()){
            int top=s.pop();
            System.out.println(top);
            NodeS temp=h.get(top).head;
            while(temp!=null){
                if(!visited[temp.data]){
                    s.push(temp.data);
                    visited[temp.data]=true;
                }
                temp=temp.next;
            }
        }
    }
    public Map<Integer,Integer> SSSP(int source){
       Queuebylinkedlist q=new Queuebylinkedlist();
        q.enqueue(source);
        Map<Integer,Integer> m=new HashMap<>();
        for(int res:h.keySet())
            m.put(res,Integer.MAX_VALUE);
        m.put(source,0);
        while(!q.isempty()){
            int front=q.dequeue();
            SinglyLinkedList l=h.get(front);
            NodeS temp=l.head;
            while(temp!=null){
                if(m.get(temp.data)==Integer.MAX_VALUE)
                {   //s.add(temp.data);
                    m.put(temp.data,m.get(front)+1);
                    q.enqueue(temp.data);
                }
                temp=temp.next;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        Graph g=new Graph();
        g.insert(0,1,true);
        g.insert(0,2,true);
        g.insert(1,4,true);
        g.insert(2,3,true);
        g.insert(3,4,true);
        g.insert(2,4,true);
       // g.BFS_traversal(2);
         boolean[] arr={false,false,false,false,false,false,false,false,false};
       g.DFS_traversal(2,arr);

        for(Map.Entry<Integer,Integer> h:g.SSSP(1).entrySet()){
           // System.out.println(h.getKey()+" "+h.getValue());
        }

    }
}
/*
Graph traversal techniques:

1.BFS(breadth first search)
2.DFS(depth first search)

BFS uses queue data structure and DFS uses Stack data structure
SSSP(Single source shortest path)

1.BFS
2.Bellman ford algorithm
3.Dijikstra Algorithm


weighted graph does not work with BFS for single source shortest path
Dijkstra algo doesn't recognize negative cycles that is why bellman ford algo


To get MST(minimum spanning tree)
Crystal algorithm
Prim's algorithm
*/
