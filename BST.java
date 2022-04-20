import Node.BinaryTreenode;

public class BST {
    BinaryTreenode<Integer> root;
    public void insert(int val,BinaryTreenode<Integer> root1){
        if(root==null)
        {root= new BinaryTreenode(val);
            root=root1;
            return;}
        if(root.data<val)
            insert(val,root.right);
       else if(root.data>val)
            insert(val,root.right);

    }
    public void preorder(BinaryTreenode root){
        if(root==null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        BST B=new BST();
        int[] arr={4,5,1,7,6};
        for(int i=0;i<arr.length;i++)
            B.insert(arr[i],B.root);
        B.preorder(B.root);
    }
}
