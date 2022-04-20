package Questions;

public class InsertionSort {
    public static void insertsort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i;
            while(j>0 && arr[j-1]>temp){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        int arr[]={9,7,23,78,6};
        insertsort(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
