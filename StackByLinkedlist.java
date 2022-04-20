import Node.NodeS;
public class StackByLinkedlist {
    NodeS top;
    public void push(int data){
        NodeS newn=new NodeS(data);
        if(top==null)
            top=newn;
        else{
            newn.next=top;
            top=newn;
        }
    }
    public int pop(){
        if(top==null)
            System.out.println("it is empty");
        else
        {   NodeS temp=top;
            top=top.next;
            return temp.data;
        }
        return Integer.MIN_VALUE;
    }
    public void display(){
        NodeS temp=top;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

    public static void main(String[] args) {
        StackByLinkedlist S=new StackByLinkedlist();
        S.push(10);
        S.push(20);
        S.push(50);
        S.push(70);
        S.display();
        System.out.println(S.pop());

    }
}
