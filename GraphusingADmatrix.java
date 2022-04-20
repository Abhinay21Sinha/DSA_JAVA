import java.util.HashSet;

public class GraphusingADmatrix {
    int[][] arr;
    public GraphusingADmatrix(int n){
        arr=new int[n+1][n+1];
    }
    public void insert(int v,int ad,boolean edge){
        arr[v][ad]=1;
        if(edge)
            arr[ad][v]=1;
    }
    public void BFS_traversal(int source){
        Queuebylinkedlist q=new Queuebylinkedlist();
        q.enqueue(source);
        HashSet<Integer> s= new HashSet();
        s.add(source);
        while(!q.isempty()){
            int front=q.dequeue();
            System.out.println(front);
            for(int i=1;i<arr.length;i++)
            {
                if(arr[front][i]==1 && !s.contains(i)){
                    s.add(i);
                    q.enqueue(i);
                }
            }
        }
    }
    public static void main(String[] args) {
         GraphusingADmatrix g=new GraphusingADmatrix(6);
        g.insert(1,2,true);
        g.insert(1,3,true);
        g.insert(2,4,true);
        g.insert(3,4,true);
        g.insert(3,5,true);
        g.insert(5,6,true);
        for(int i=1;i<g.arr.length;i++)
        {
            for(int j=1;j<g.arr.length;j++)
                System.out.print(g.arr[i][j]+" ");
            System.out.println();
        }
        g.BFS_traversal(2);
    }
}
