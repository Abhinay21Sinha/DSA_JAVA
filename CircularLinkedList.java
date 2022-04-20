import Node.NodeS;
public class CircularLinkedList {
    NodeS head;
    public void add(int data){
        NodeS newn=new NodeS(data);
        if(head==null)
        {head=newn;
            head.next=head;}
        else{
            NodeS temp=head .next;
            while(temp.next!=head)
                temp=temp.next;
            newn.next=temp.next;
            temp.next=newn;
        }
    }
    public void addIth(int p,int data){
        if(head==null)
            add(data);
        else{
            NodeS newn=new NodeS(data);
            NodeS temp=head;
            int i=1;
            while(i<p-1){
                temp=temp.next;
                i++;
            }
            newn.next=temp.next;
            temp.next=newn;
        }
    }
    public void addfirst(int data){
        NodeS newn=new NodeS(data);
        if(head==null){
            head=newn;
            newn.next=head;
        }
        else{
            NodeS temp=head;
            while(temp.next!=head)
                temp=temp.next;
            newn.next=temp.next;
            temp.next=newn;
            head=newn;
        }
    }
    public int no_of_nodes(){
        int n=1;
        NodeS temp=head.next;
        while(temp!=head)
        {n++;
            temp=temp.next;}
        return n;
    }
    public void delete(int p){
        if(head==null)
            System.out.println("it is empty");
        else if(p<=0 || p>=no_of_nodes())
        {
            NodeS temp=head;
            NodeS ptemp=temp.next;
            while(ptemp.next!=head)
            {temp=ptemp;
                ptemp=ptemp.next;}
            System.out.println("Deleted node is "+ptemp.data);
            temp.next=head;
        }
        else{
            NodeS temp=head;
            int i=0;
            while(i<p-2)
            {temp=temp.next;
                i++;}
            NodeS p1=temp.next;
            temp.next=p1.next;

        }


    }
    public void deletefirst(){
        if(head==null)
            System.out.println("empty");
        else{
            NodeS temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=head.next;
            head=head.next;
        }
    }
    public void display(){
        NodeS temp=head.next;
        System.out.println(head.data);
        while(temp!=head)
        { System.out.println(temp.data);
            temp=temp.next;}
    }

    public static void main(String[] args) {
        CircularLinkedList C=new CircularLinkedList();
        C.add(10);
        C.add(20);
        C.add(30);
        C.add(40);
        C.add(50);
       // C.display();
        C.addIth(3,25);
        C.display();
    }
}
