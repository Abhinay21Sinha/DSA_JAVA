public class CircularQueue {
    int beg;
    int end;
    int Queue[];
    public CircularQueue(int n){
        beg=end=-1;
        Queue=new int[n];
        for(int i=0;i<n;i++)
            Queue[i]=Integer.MIN_VALUE;
    }
    public void enqueue(int data){
        if(beg==((end+1)%Queue.length))
            System.out.println("it is full");
        else if(beg==-1 && end==-1){
            beg=end=0;
            Queue[beg]=data;
        }else{
            end=(end+1)%Queue.length;
            Queue[end]=data;
        }
    }
    public void dequeue(){
        if(beg==end)
            System.out.println("Queue is empty");
        else
        {
            System.out.println("deleted element is "+Queue[beg]);
            beg=(beg+1)%Queue.length;
        }
    }
    public void display(){
        for(int i=beg;i!=end;i=(i+1)%Queue.length)
            System.out.println(Queue[i]);
       System.out.println(Queue[end]);
    }

    public static void main(String[] args) {
        CircularQueue Q=new CircularQueue(8);
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.enqueue(50);
        Q.enqueue(60);
        Q.enqueue(70);
        Q.enqueue(80);
        Q.dequeue();
        Q.enqueue(90);
        Q.dequeue();
        Q.enqueue(100);
        Q.display();
    }

}
