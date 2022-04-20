class NodeBT{
    int data;
    NodeBT left;
    NodeBT right;
    public NodeBT(int data){
        this.data=data;
    }
}


public class BST2 {
    static NodeBT root;
    public static void preorder(NodeBT root){
        if(root==null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }
    public static void insert(int data){
        NodeBT newn=new NodeBT(data);
        if(root==null)
        {root=newn;
            return;}
        NodeBT temp=root;
        while(true){
            if(root.data>=data){
                if(temp.left==null){
                    temp.left=newn;
                    return;
                }else
                    temp=temp.left;
            }else{
                if(temp.right==null){
                    temp.right=newn;
                    return;
                }else
                    temp=temp.right;
            }
        }
    }
    public static NodeBT insertR(int data,NodeBT temp){
        if(temp==null)
        {  return new NodeBT(data);}
        if(temp.data>=data)
            temp.left=insertR(data,temp.left);
        else
            temp.right=insertR(data,temp.right);
        return temp;
    }
    public static int count(NodeBT root){
        if(root.left==null && root.right==null)
            return 1;
         if(root.left==null)
             return 1+count(root.right);
         else if(root.right==null)
             return 1+count(root.left);
         else
           return 1+count(root.right)+count(root.left);
    }

    public static void main(String[] args) {
        BST2 B=new BST2();
        root=insertR(15,root);
        root=insertR(30,root);
        root=insertR(40,root);
        root=insertR(10,root);
        preorder(root);
        System.out.println(count(root));
    }
}
