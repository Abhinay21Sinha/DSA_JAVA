import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import Node.BinaryTreenode;
public class BinaryTree{
    Scanner sc=new Scanner(System.in);
     BinaryTreenode<Integer> root;
    public BinaryTreenode insert(BinaryTreenode<Integer> root,int val){
        if(root==null)
        {root=new BinaryTreenode(val);
             return root;}
        if(root.left==null)
            root.left= insert(root.left,val);
        else if(root.right==null)
            root.right= insert(root.right,val);
        else
            root.left= insert(root.left,val);
        return root;
    }
    public static BinaryTreenode SkewtoB(BinaryTreenode root,int st,int end,int[] arr){
        if(end-st==1)
        {
            root=new BinaryTreenode(arr[st]);
            return root;
        }
        int m=(end-1+st)/2;
        root=new BinaryTreenode(arr[m]);
        root.left=SkewtoB(root.left,st,m,arr);
        root.right=SkewtoB(root.right,m+1,end,arr);
        return root;

    }
    public static void preorder(BinaryTreenode<Integer> root){
        if(root==null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static boolean BSTornot(BinaryTreenode<Integer> root){
        boolean f, g;
        if(root.left==null || root.right==null)
            return true;
        if(root.data<root.left.data)
            return false;
        else
            f= BSTornot(root.left);
        if(root.data>=root.right.data)
            return false;
        else
             g= BSTornot(root.right);
        return f&&g;
    }
    public static void printnbetrange(BinaryTreenode<Integer> root,int n1,int n2){
        if(root==null)
            return;
        if(root.data>=n1 && root.data<=n2)
        {
            System.out.println(root.data);
            printnbetrange(root.left,n1,n2);
            printnbetrange(root.right,n1,n2);
        }else if(root.data>=n1)
            printnbetrange(root.left,n1,n2);
        else
            printnbetrange(root.right,n1,n2);
    }
    public static int maxelement(BinaryTreenode<Integer> root,int max){
        if(root==null)
            return max;
        if(root.left==null && root.right==null)
        {
            max=root.data;
            return max;
        }
        int max1=maxelement(root.left,max);
        int max2=maxelement(root.right,max);
        if(max1>max2)
            return max1;
        else
            return max2;
    }
     int sum;
    public  void replacewithsum(BinaryTreenode<Integer> root1,int val){
        if(root1==null)
            return;
        if(root1.data==val)
        {  int temp=root1.data;
           root1.data=sum;
           sum=sum+temp;
           return;
        }
        replacewithsum(root1.left,val);
        replacewithsum(root1.right,val);
    }
    public static void deleteNode(BinaryTreenode<Integer> root,int val,BinaryTreenode<Integer> leaf){

    }
    public static BinaryTreenode insertR(BinaryTreenode<Integer> temp,int data){
        if(temp==null)
        {  temp= new BinaryTreenode(data);
        return temp;}
        if(temp.data>=data)
            temp.left=insertR(temp.left,data);
        else
            temp.right=insertR(temp.right,data);
        return temp;
    }
    public static void main(String[] args) {
        BinaryTreenode<Integer> root=null;
        BinaryTree t=new BinaryTree();
        BinaryTree t1=new BinaryTree();
        int[] arr={5,6,7,8,9,10,11};
        LinkedList<Integer> l=new LinkedList<>();
            t.root=SkewtoB(t.root,0,arr.length,arr);
            int[] arr2={30,20,50,25,35,40,10};
            for(int i:arr2)
                t1.root= insertR(t1.root,i);
            Arrays.sort(arr2);
            for(int i=arr2.length-1;i>=0;i--){
                t1.replacewithsum(t1.root,arr2[i]);
            }
            preorder(t1.root);


    }
}
