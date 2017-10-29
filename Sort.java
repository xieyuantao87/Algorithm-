/*
* in this class, I sort an itegerger array with differenct method, 
* quick sort, merge sort, insertion sort, heap sort, bucket sort
 */
package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Yuantao Xie
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] arr=randomArray(100, 1000);
      quickSort(arr, 0, arr.length-1); 
      shuffleArray(arr);
      mergeSort(arr, 0, arr.length-1);
      shuffleArray(arr);
      insertionSort(arr);
      shuffleArray(arr);
      heapSort(arr);
      shuffleArray(arr);
      int maxVal=arr[0];
      for(int i=0; i<arr.length; i++) maxVal=arr[i]>maxVal? arr[i] : maxVal;
      bucketSort(arr, maxVal);
    }
    
    public static int[] randomArray(int length, int range){
        int[] res=new int[length];
        for(int i=0; i<length; i++)
            res[i]=(int)(Math.random()*range);
        return res;
    }
    public static void shuffleArray(int[] arr){
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--){
      
            int index = rnd.nextInt(i + 1);
            //  swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
    }
  }
     
 /* quick sort array 
    
    */
    static void quickSort(int[] arr, int low, int high){
         if (low < high)
         {

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);  
        }
    }
 /* quick sort array 
    partion function for quick sort
    */
   public static int partition (int arr[], int low, int high){
       
       int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
/* merge sort of an array
   
   */
    public static void merge(int arr[], int left, int middle, int right){
        //sizes of two subarrays
        int len1=middle-left+1, len2=right-middle;
        int[] arr1=new int[len1], arr2=new int[len2];
        
        //copy dat
        for(int i=0; i<len1; i++) arr1[i]=arr[i+left];
        for(int i=0; i<len2; i++) arr2[i]=arr[middle+1+i];
        
        // initial array index
        int i=0, j=0, k=left;
        //merge
        while(i<len1 && j<len2){
            if(arr1[i]<arr2[j]) arr[k++]=arr1[i++];
            else arr[k++]=arr2[j++];
        }
        //copy remaining elements
        while(i<len1) arr[k++]=arr1[i++];
        while(i<len2) arr[k++]=arr2[j++];
        
    }
    
    public static void mergeSort(int arr[], int left, int right){
        if(left<right){
            int middle=(left+right)/2;
            mergeSort(arr, left, middle); 
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }
    
/* insertion Sort
    
    */
    public static void insertionSort(int arr[]){
        int len=arr.length; 
        for(int i=1; i<len; i++){
            int temp=arr[i],j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    
     public static void heapify(int arr[], int len, int i){
        int largest=i; 
        int left=2*i+1, right=2*i+1; 
        
        if(left<len && arr[left]>arr[largest]) largest=left;
        if(right<len && arr[right]>arr[largest]) largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr, len, largest);  
        }
        
    }
     
/*
     heap sort
     */
    public static void heapSort(int arr[]){
        int len=arr.length; 
        for(int i=len/2-1; i>=0; i--){
            heapify(arr, len, i);
        }
        for(int i=len-1; i>=0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr, i, 0);
        }
    }
/*
    selection sort
    */
    public void selectionSort(int[] arr){
        int len=arr.length;
        for(int i=0; i<len-1; i++){
            int minIndex=i; 
            for(int j=i+1; j<len; j++){
                if(arr[j]<arr[minIndex]);
                minIndex=j;
            }
            
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    
    public static  void bucketSort(int[] arr, int maxVal){
        int[] bucket=new int[maxVal];
        Arrays.fill(arr, 0);
        for(int i : arr) bucket[i]++;
        int k=0;
        for(int i=0; i<bucket.length; i++){
            while(bucket[i]>0){
                arr[k++]=i;
                bucket[i]--;
            }
        }
    }
}
