package Node;

public class ThreadedTreeNode {
    public int data;
    public ThreadedTreeNode left,right;
    boolean rightthread;
    public ThreadedTreeNode(int data)
    {this.data=data;}
}

class ThreadedBinaryTree{
    ThreadedTreeNode root;
    public ThreadedTreeNode leftMost(ThreadedTreeNode n)
    {
        if (n == null)
            return null;

        while (n.left != null)
            n = n.left;

        return n;
    }
    public ThreadedTreeNode insert(ThreadedTreeNode root,ThreadedTreeNode Nodes){
        if(root==null)
        {root=Nodes;
            return root;}
        if(root.left==null)
            root.left= insert(root.left,Nodes);
        else if(root.right==null)
            root.right= insert(root.right,Nodes);
        else
            root.left= insert(root.left,Nodes);
        return root;
    }
    public void inOrder(ThreadedTreeNode root)
    {
        ThreadedTreeNode cur = leftMost(root);
        while (cur.right!=cur) {
            System.out.printf("%d ", cur.data);

            // If this node is a thread node, then go to
            // inorder successor
            if (cur.rightthread)
                cur = cur.right;
            else // Else go to the leftmost child in right
                // subtree
                cur = leftMost(cur.right);
        }
    }
    public void inorderB(ThreadedTreeNode root){
        if(root==null)
            return;
        inorderB(root.left);
        System.out.println(root.data);
        inorderB(root.right);
    }

    public static void main(String[] args) {
        ThreadedBinaryTree t=new ThreadedBinaryTree();
        ThreadedTreeNode n1=new ThreadedTreeNode(10);
        ThreadedTreeNode n2=new ThreadedTreeNode(20);
        ThreadedTreeNode n3=new ThreadedTreeNode(30);
        ThreadedTreeNode n4=new ThreadedTreeNode(40);
        ThreadedTreeNode d=new ThreadedTreeNode(Integer.MIN_VALUE);
        d.left=n1;
        d.right=d;
        t.root= t.insert(t.root,n1);
        t.root= t.insert(t.root,n2);
        t.root= t.insert(t.root,n3);
        t.root= t.insert(t.root,n4);
        n4.right=n2;
        n4.rightthread=true;
        n2.right=n1;
        n2.rightthread=true;
        n1.rightthread=false;
        n3.right=d;
        n3.rightthread=true;
        t.inOrder(t.root);
    }

}
