import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryTreeusingArray<T> {
    T[] arr;
    int lastusedindex;
    public BinaryTreeusingArray(int n){
        T[] ts = (T[]) new Object[n + 1];
        arr=ts;
        lastusedindex=0;
    }
    public void insert(T val){
        if(arr.length-1==lastusedindex)
            System.out.println("array is full");
        else{
            arr[lastusedindex+1]=val;
            lastusedindex++;
        }
    }
    public void traverse(int index){
        if(index>lastusedindex)
            return;
        System.out.println(arr[index]);
        traverse(2*index);
        traverse(2*index+1);
    }
    public static void main(String[] args) {
        BinaryTreeusingArray<Integer> b=new BinaryTreeusingArray(5);
        String ch="";
        Scanner sc=new Scanner(System.in);
        int i=0;
        do{
            System.out.println("1.insert");
            System.out.println("2.traverse");
            System.out.println("enter your choice");
            i=sc.nextInt();
            switch(i){
                case 1:
                    System.out.println("enter value");
                    int n=sc.nextInt();
                    b.insert(n);
                    break;
                case 2:b.traverse(1);break;
            }
            System.out.println("Do you want to make chouce again(Y/y)?");
            ch=sc.next();
       }while(ch.equals("y") || ch.equals("Y"));

    }
}
