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
    public Map<Integer,Integer> SSSP(int source){
       Queuebylinkedlist q=new Queuebylinkedlist();
       q.enqueue(source);
        Set<Integer> s=new HashSet<>();
        Map<Integer,Integer> m=new HashMap<>();
        for(int res:h.keySet())
            m.put(res,Integer.MAX_VALUE);
        m.put(source,0);
        while(!q.isempty()){
            int front=q.dequeue();
            SinglyLinkedList l=h.get(front);
            NodeS temp=l.head;
            int i=1;
            while(temp!=null){
                if(m.get(temp.data)==Integer.MAX_VALUE)
                    m.put(temp.data,i);
                temp=temp.next;
            }
            i++;
        }
        return m;
    }

    public static void main(String[] args) {
        Graph g=new Graph();
        g.insert(1,2,true);
        g.insert(1,3,true);
        g.insert(2,4,true);
        g.insert(3,4,true);
        g.insert(3,5,true);
        g.insert(5,6,true);
        g.BFS_traversal(2);
        for(Map.Entry<Integer,Integer> k:g.SSSP(1).entrySet()){
            System.out.println(k.getKey()+" "+k.getValue());
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
2.Belman ford algorithm
3.Dijikstra Algorithm
*/
