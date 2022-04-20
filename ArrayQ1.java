import java.util.Scanner;
public class ArrayQ1 {
    ArrayQ1(){
        Scanner sc=new Scanner(System.in);
        int[] a=new int[7];
        int[] b=new int[9];
        int[] c=new int[a.length+b.length];
        System.out.println("Enter elements of array a");
        for(int i=0;i<a.length;i++)
            a[i]=sc.nextInt();
        System.out.println("Enter elements of array a");
        for(int i=0;i<b.length;i++)
            b[i]=sc.nextInt();
        int i=0;
        for (int ai:a) {
            c[i]=ai;
            i++;
        }
        i=0;
        for(int bi:b){
            c[a.length+i]=bi;
            i++;
        }
        System.out.println("Array c is ");
        for (int ci:c)
            System.out.println(ci);
    }
    public static void main(String[] args) {
        ArrayQ1 q=new ArrayQ1();
    }
}
