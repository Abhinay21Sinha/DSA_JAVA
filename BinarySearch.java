package Questions;
import java.util.Scanner;
public class BinarySearch {
    static boolean binarySearch(String s,int st,int end,char target){
        if(st>=end)
            return false;
        int mid=(st+end-1)/2;
        if(s.charAt(mid)>target)
            return binarySearch(s,st,mid-1,target);
        else if(s.charAt(mid)<target)
            return binarySearch(s,mid+1,end,target);
        else
            return true;
    }
        static int frequency(String s,char ch){
        int f=0;
        for(int i=0;i<s.length();i++)
            if(ch==s.charAt(i))
                f++;
            return f;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String res="";
        int[] a=new int[26];
        for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(a[i]!=0){
                char ch=(char)(i+97);
                res=res+ch;
            }
        }
        char[] fg=res.toCharArray();
       for(int i=0;i<res.length()-1;i++){
           for(int j=0;j<res.length()-1;j++){
                if(frequency(s,fg[j])>frequency(s,fg[j+1])){
                    char temp=fg[j];
                   fg[j]=fg[j+1];
                   fg[j+1]=temp;
              }
          }
        }
        String res1="";
        for(int i=0;i<fg.length;i++)
            res1=res1+fg[i];
        System.out.println(res1);
        System.out.println("For binary search enter a target variable");
        String target=sc.next();
        System.out.println(binarySearch(res,0,res.length(),target.charAt(0)));
        }

    }

