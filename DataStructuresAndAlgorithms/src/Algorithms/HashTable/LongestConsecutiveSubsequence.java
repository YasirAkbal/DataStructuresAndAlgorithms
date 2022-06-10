/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author yasir
 */
public class LongestConsecutiveSubsequence {
    public static int naiveSolution(int arr[], int N) {
        int max = 1;
        int count = 1;
        Arrays.sort(arr);
        
        for(int i=1;i<N;i++) {
            if(arr[i] == arr[i-1]+1) {
                count++;
            } else if(arr[i] != arr[i-1]) {
                max = Math.max(max,count);
                count = 1;
            }
        }
        
        return Math.max(count,max);
    }
    
    public static int efficientSolution1(int arr[], int N) {
       HashMap<Integer, Integer> map = new HashMap<>();
	   int result = 1;
	   
	   for(int x: arr) {
	       map.put(x,1);
	   }
	   
	   for(int i=0;i<N;i++) {
	       int elem = arr[i]+1;
	       while(map.containsKey(elem)) {
	           map.put(arr[i],map.get(arr[i])+map.get(elem));
	           map.remove(elem);
	           elem++;
	       }
	       result = Math.max(map.getOrDefault(arr[i],1),result);
	   }
	  
	   
	   return result;
    }
    
    //en iyi çözüm bu
    public static int efficientSolution2(int arr[], int N) {
	    HashSet<Integer> set = new HashSet<>();
	    int result = 1;
	    
	    for(int x: arr) {
	        set.add(x);
	    }
	    
	    for(Integer x: set) {//toplamda set'in uzunlugunun 2 katı kadar lookup olacak(lineer)
	        if(!set.contains(x-1)) { //x'in 1 eksiği dizide yoksa x serinin ilk elemanıdır.
	            int i = 1;
	            while(set.contains(x+i)) { //x'in baslangıc elemani oldugu serinin sonraki elemanlarını ara
	                i++;
	            }
	            result = Math.max(i, result);
	        }
	    }
	    
	    return result;
    }
}
