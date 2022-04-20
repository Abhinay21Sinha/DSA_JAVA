package package1;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergesort(int[] arr){
        if(arr.length==1)
            return arr;
        int mid=arr.length/2;
       int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
       int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
       return merge(left,right);
    }
    public static int[] merge(int[] left,int[] right){
        int[] ar=new int[left.length+right.length];
        int i=0,j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j])
            {ar[k]=left[i];
                i++;}
            else {
                ar[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            ar[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            ar[k]=right[j];
            j++;
            k++;
        }
        return ar;
    }
    public static void mergesortinplace(int[] arr,int st,int end){
        if(end-st==1)
            return;
        int mid=(st+end)/2;
        mergesortinplace(arr,st,mid);
        mergesortinplace(arr,mid,end);
        mergeinplace(arr,st,end,mid);
    }
    public static void mergeinplace(int[] arr,int st,int end,int mid){
        int[] ar=new int[end-st];
        int i=st,j=mid;
        int k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j])
            {ar[k]=arr[i];
                i++;}
            else {
                ar[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            ar[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            ar[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<ar.length;l++)
            arr[st+l]=ar[l];
    }

    public static void main(String[] args) {
        int arr[]={5,8,6,3,4,2,1};
        mergesortinplace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
