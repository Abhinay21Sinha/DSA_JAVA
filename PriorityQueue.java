import Node.NodeP;

public class PriorityQueue {
    NodeP front;
    NodeP rear;

    public void enqueue(int data, int priority) {
        NodeP newn = new NodeP(data, priority);
        if (front == null || newn.priority < front.priority) {
            newn.next = front;
            front = newn;
            rear = newn;
        } else {
            NodeP temp = front;
            while (temp.next != null && newn.priority >= temp.next.priority)
                temp = temp.next;
            newn.next = temp.next;
            temp.next = newn;
        }
    }

    public void dequeue() {
        NodeP temp = front;
        NodeP ptemp = temp.next;
        while (ptemp.next != null) {
            temp = ptemp;
            ptemp = ptemp.next;
        }
        System.out.println("deleted " + ptemp);
        temp.next = null;
    }

    public void display() {
        NodeP temp = front;
        while (temp != null) {
            System.out.println(temp.data + " " + temp.priority);
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        PriorityQueue P = new PriorityQueue();
        P.enqueue(10, 6);
        P.enqueue(15, 3);
        P.enqueue(18, 9);
        P.dequeue();
        P.display();
    }

}