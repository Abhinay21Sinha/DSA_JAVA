package package1;

import java.util.Arrays;

public class QuickSort {
    public static void QuickSort(int[] arr,int low,int high){
        if(low>=high)
            return;
        int st=low;
        int end=high;
        int p=arr[end-1];
        while(st<=end) {
            while (arr[st] < p)
                st++;
            while (arr[end] > p)
                end--;
            if (st <= end) {
                int temp = arr[st];
                arr[st] = arr[end];
                arr[end] = temp;
                st++;
                end--;
                }

        }
        QuickSort(arr,st,high);
        QuickSort(arr,low,end);
        }

    public static void main(String[] args) {
        int[] arr={6,8,7,3,5,4,1};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
