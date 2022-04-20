import Node.NodeD;
public class DoublyLinkedList {
    NodeD head;
    NodeD tail;
    public void add(int data){
        NodeD newnode=new NodeD(data);
        if(head==null || tail==null)
            head=tail=newnode;
        else{
            newnode.previous=tail;
            tail=newnode;
            NodeD temp=head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=newnode;
        }
    }
    public void addfirst(int data){
        NodeD newnode=new NodeD(data);
        if(head==null)
            head=newnode;
        else{
            head.previous=newnode;
            newnode.next=head;
            head=newnode;
        }
    }
    public void addIth(int p,int data){
        if(p<0)
            addfirst(data);
        else{
            NodeD newnode=new NodeD(data);
            int i=1;
            NodeD temp=head;
            while(i<p-1){
                temp=temp.next;
                i++;
            }
            NodeD ptemp=temp.next;
            ptemp.previous=newnode;
            newnode.previous=temp;
            temp.next=newnode;
            newnode.next=ptemp;
        }
    }
    public int displayR(){
            NodeD temp=tail;
            int i=0;
        while(temp!=null)
        {
            System.out.println(temp.data);
                temp=temp.previous;
                i++;

        }
        return i;
    }
    public void displayS(){
        NodeD temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void deletefront(){
          if(head==null)
              System.out.println("it is empty");
          else {
              System.out.println("deleted is"+head.data);
              head=head.next;
              head.previous=null;
          }
    }
    public void deleterear(){
        if(tail==null)
            System.out.println("it is empty");
        else{NodeD temp=tail;
            System.out.println("deleted is "+temp.data);
            tail=tail.previous;
            temp.previous=null;
            tail.next=null;
        }


    }
    public void deleteIth(int p){
        if(head==null)
            System.out.println("empty");
        else{int i=1;
            NodeD temp=head;
            while(i<p-1){
                temp=temp.next;
                i++;
            }
            NodeD ptemp=temp.next;
            System.out.println("Deleted data is "+ptemp.data);
            temp.next=ptemp.next;
            (ptemp.next).previous=temp;
            ptemp.next=ptemp.previous=null;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList D=new DoublyLinkedList();
        D.add(20);
        D.add(80);
        D.add(90);
        D.add(100);
        D.add(25);
       // D.displayR();
        //D.deleteIth(3);
        //D.addfirst(10);
        D.addIth(3,67);
        D.displayS();
    }
}
