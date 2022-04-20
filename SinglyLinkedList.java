import Node.NodeS;
public class SinglyLinkedList {
    NodeS head;
    public void add(int data){
        NodeS n=new NodeS(data);
        if(head==null)
            head=n;
        else{
            NodeS temp=head;
            while(temp.next!=null)
                temp= temp.next;
            temp.next=n;
        }
    }
    public void display(){
        NodeS temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void addfirst(int data){
        NodeS n=new NodeS(data);
        if(head==null)
            head=n;
        else{
            n.next=head;
            head=n;
        }
    }
    public int no_of_nodes(){
        int n=0;
        NodeS temp=head;
        while(temp!=null)
        {n++;
            temp=temp.next;}
        return n;
    }
    public void AddatIth(int p,int data){
        NodeS temp=head;
        NodeS newn=new NodeS(data);
        p--;
        int n=no_of_nodes();
        if(p<0)
            addfirst(data);
        else if(p>n)
            add(data);
        else{
            temp=head;
            for(int i=0;i<p-1;i++)
                temp=temp.next;
                newn.next=temp.next;
                temp.next=newn;
        }
    }
    public void delete(String s){
        if(s.equals("front")){
            System.out.println("Data deleted is"+head.data);
            head=head.next;
        }
        else if(s.equals("rear")){
            NodeS temp=head;
            NodeS ptemp=temp.next;
            while(ptemp.next!=null)
            {temp=ptemp;
                ptemp=ptemp.next;}
            System.out.println("Data deleted is"+ptemp.data);
            temp.next=null;
        }
    }
    public void deleteAtIth(int p){
        if(p<1)
            delete("front");
        else if(p>no_of_nodes())
            delete("rear");
        else{
            int i=1;
            NodeS temp=head;
            while(i<p-1){
                i++;
                temp=temp.next;
            }
            NodeS pi=temp.next;
            System.out.println("deleted element"+pi.data);
            temp.next=pi.next;
        }
    }
    public int count(NodeS temp){
        if(temp==null){
            return 0;
        }
        return 1+count(temp.next);
    }

    public static void main(String[] args) {
        SinglyLinkedList L=new SinglyLinkedList();
        L.add(20);
        L.add(60);
        L.add(70);
        L.add(80);
        //L.AddatIth(3,10);
        //L.display();
        //L.delete("rear");
        System.out.println(L.count(L.head));
    }
}



