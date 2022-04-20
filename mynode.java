import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.Scanner;

public class mynode {
    int data;
    mynode left,right;
    boolean rightthread;
    int lcount;
    int rcount;
    public mynode(int data){
        this.data=data;
        this.rightthread=false;
        lcount=rcount=0;
    }


}
class tree4{
    public mynode root;
    public mynode leftMost(mynode n)
    {
        if (n == null)
            return null;

        while (n.left != null)
            n = n.left;

        return n;
    }
    public mynode insert(mynode root, mynode Nodes){
        if(root==null)
        {root=Nodes;
            return root;}
        if(root.left==null)
            root.left= insert(root.left,Nodes);
        else if(root.right==null)
            root.right= insert(root.right,Nodes);
        else
        {
            root.left=insert(root.left,Nodes);
        }
        return root;
    }
    public mynode insertR(mynode root, mynode Node)
    {

        // Condition when root is NULL
        if (root == null) {
            return Node;
        }
        if (root.rcount == root.lcount) {
            root.left = insertR(root.left, Node);
            root.lcount += 1;
        }
        else if (root.rcount < root.lcount) {
            if (isPBT(root.lcount)) {
                root.right = insertR(root.right, Node);
                root.rcount += 1;
            }
            else {
                root.left = insertR(root.left, Node);
                root.lcount += 1;
            }
        }
        return root;
    }
    public boolean isPBT(int count)
    {
        count = count + 1;

        // Loop to check the count is in
        // the form of 2^(n-1)
        while (count % 2 == 0)
            count = count / 2;
        if (count == 1)
            return true;
        else
            return false;
    }
    public int inOrder(mynode root)
    {  int c=0;
        mynode cur = leftMost(root);
        while (cur.right!=cur) {
            c++;


            // If this node is a thread node, then go to
            // inorder successor
            if (cur.rightthread)
                cur = cur.right;
            else // Else go to the leftmost child in right
                // subtree
                cur = leftMost(cur.right);
        }
        return c;
    }
    public void inorderB(mynode root){
        if(root==null)
            return;
        inorderB(root.left);
        System.out.println(root.data);
        inorderB(root.right);
    }
}
class Test567{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] num=str.split(" ");
        str="";
        HashMap<String,Integer> h=new HashMap<>();
        HashMap<String,Integer> d=new HashMap<>();
        h.put("one",1);
        h.put("two",2);
        h.put("three",3);
        h.put("four",4);
        h.put("five",5);
        h.put("six",6);
        h.put("seven",7);
        h.put("eight",8);
        h.put("nine",9);
        h.put("zero",0);
        d.put("double",2);
        d.put("triple",3);
        d.put("quad",4);
        d.put("penta",5);
        d.put("hexa",6);
        d.put("septa",7);
        d.put("octa",8);
        d.put("nona",9);
        d.put("deca",10);
        for(int i=0;i<num.length;i++){
            if(h.containsKey(num[i]))
                str=str+h.get(num[i]);
            else
            {
                for(int j=0;j<d.get(num[i])-1;j++)
                    str=str+h.get(num[i+1]);
            }
        }
        System.out.println(str);
        mynode[] m=new mynode[str.length()];
        for(int i=0;i<str.length();i++)
            m[i]=new mynode(str.charAt(i)-'0');
        tree4 t=new tree4();
        m[0].left=m[1];
        m[0].right=m[2];
        m[1].left=m[3];
        m[1].right=m[4];
        m[2].left=m[5];
        m[2].right=m[6];
        m[3].left=m[7];
        m[3].right=m[8];
        m[4].left=m[9];
        mynode d1=new mynode(Integer.MIN_VALUE);
        d1.right=d1;
        d1.left=m[0];
        m[4].right=m[0];
        m[4].rightthread=true;
        m[7].right=m[3];
        m[7].rightthread=true;
        m[8].right=m[1];
        m[8].rightthread=true;
        m[9].right=m[4];
        m[9].rightthread=true;
        m[5].right=m[2];
        m[5].rightthread=true;
        m[6].right=d1;
        m[6].rightthread=true;

    }
}
