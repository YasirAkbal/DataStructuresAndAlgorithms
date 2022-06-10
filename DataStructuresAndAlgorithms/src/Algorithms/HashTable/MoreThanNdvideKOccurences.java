/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yasir
 */
public class MoreThanNdvideKOccurences {
    //https://leetcode.com/problems/majority-element-ii/
    /*
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> O(n) : Dizideki distinct eleman sayısı
    */
    public static List<Integer> timeEfficient(int[] nums, int k) {
        //int k = 3;
        int n = nums.length;
        double ratio = (double)n/k;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x: nums) {
            map.put(x,map.getOrDefault(x,0)+1);   
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > ratio) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
    
    
    /*
    Time Complexity -> O(n*k)
    Auxiliary Space -> O(k)
    Bellek kullanımı açısından diğerine göre çok daha efektif. Diğer çözümde HashTable'da max n eleman olurken burada max k-1 tane olabilir
    Moore Algoritması -> Arrays dizinindeki MajorityElementInAnArray algoritması
    */
    public static List<Integer> memoryEfficient(int[] arr, int k) {
        int n = arr.length;
        double ratio = (double)n/k;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else if (map.size() < (k-1)) { //sonuc listesinde en fazla k-1 eleman olabilir.
                map.put(arr[i], 1);
            } else {
                List<Integer> toDelete = new ArrayList<>();
                for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    if(entry.getValue() == 1)
                        toDelete.add(entry.getKey());
                    else
                        map.put(entry.getKey(), entry.getValue()-1);
                }
                for(int num: toDelete)
                    map.remove(num);
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int count = 0;
            for(int x: arr) {
                if(x == entry.getKey()) {
                    count++;
                }
            }
            
            if(count > ratio) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}
