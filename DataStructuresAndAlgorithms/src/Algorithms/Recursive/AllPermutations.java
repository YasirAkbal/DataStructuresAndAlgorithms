/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class AllPermutations {
    private AllPermutations() {}
    
    public static void solution1(String str) {
        _solution1(str, "");
    }
    
    private static void _solution1(String str, String branch) {
        if(str.isEmpty()) { 
            System.out.println(branch);
            return;
        }
        
        for(int i=0;i<str.length();i++) {
            _solution1(str.substring(0, i) + str.substring(i+1),branch+str.charAt(i));
        }
    }
    
    
    
    public static void solution2(String str) {
        String[] arr = str.split("");
        _solution2(arr, 0);
    }
    
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void _solution2(String[] arr, int i) {
        if(i == arr.length -1 ) { 
            System.out.println(String.join("", arr));
            return;
        }
        
        for(int j=i;j<arr.length;j++) {
            swap(arr,i,j);
            _solution2(arr,i+1);
            swap(arr,j,i);
        }
    }
}
