/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author yasir
 */
public final class ArrayUtils<T extends Number> {
    
    public void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int sum(T[] arr) {
        int sum = 0;
        
        for(int i=0;i<arr.length;i++) { 
            sum += (int)arr[i];
        }
        
        return sum;
    }
    
    private int calculateUpperBoundForReverse(int from, int to) {
        return (from+to)/2;
    }
    
    public void reverse(T[] arr) {
        _reverse(arr,0,arr.length,calculateUpperBoundForReverse(0, arr.length));
    }
    
    public void reverse(T[] arr, int from) {
        _reverse(arr,from,arr.length+from,calculateUpperBoundForReverse(from, arr.length));
    }
    
    public void reverse(T[] arr, int from, int to) {
        _reverse(arr,from,to,calculateUpperBoundForReverse(from, to));
    }
    
    private void _reverse(T[] arr, int from, int len, int upperBound) {
        for(int i=from;i<upperBound;i++) {
            swap(arr,i,len-i-1);
        }
    }
    
    public void printArr(T[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void merge(Integer[] arr, int left, int mid, int right) {
        int[] result = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }
        
        for(;i<=mid;i++,k++) { result[k] = arr[i]; }
        for(;j<=right;j++,k++) { result[k] = arr[j]; }
        
        for(i=left;i<=right;i++) {
            arr[i] = result[i-left];
        }
    }
}
