import Node.NodeS;
public class Queuebylinkedlist {
    NodeS front;
    NodeS rear;
    public void enqueue(int data){
        NodeS newn=new NodeS(data);
        if(front==null && rear==null)
            front=rear=newn;
        else{
            rear.next=newn;
            rear=newn;
        }
    }
    public int dequeue(){
        NodeS temp=new NodeS(-1);
        if(front==rear && front==null)
            System.out.println("Empty");
        else if(front==rear){
            temp= front;
            front=rear=null;
        }else{
            temp=front;
            front=front.next;
        }
        return temp.data;
    }
    public boolean isempty(){
        if(front==rear && front==null)
            return true;
        return false;
    }
    public void display(){
        NodeS temp=front;
        while(temp!=rear){
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Queuebylinkedlist Q=new Queuebylinkedlist();
        Q.enqueue(10);
        System.out.println(Q.dequeue());
    }

}
