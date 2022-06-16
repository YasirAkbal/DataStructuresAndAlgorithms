/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author yasir
 */
public class LongestSubstringWithoutRepeating {
    private static final int CHAR_SIZE = 256;
    
    /*
    Time Complexity -> O(n^3)
    Space Complexity -> O(1)
    */
    public static int naiveSolution(String s) {
        int n = s.length();
        int max = 0;
        int count = 0;
        
        for(int i=0;i<n;i++)  {
            count = 1;
            for(int j=i+1;j<n;j++) {
               boolean flag = true;
               for(int k=j-1;k>=i;k--) {
                   if(s.charAt(k) == s.charAt(j)) {
                       flag = false;
                       break;
                   }
               } 
               if(flag == true) {
                   count++;
                   max = Math.max(max,count);
               } else {
                   count = 1;
               }
            }
        }
        
        return Math.max(max,count);
    }
    
    private static boolean areDistinct(String s, int i, int j) {
        boolean[] visited = new boolean[CHAR_SIZE];
        
        for(int k=i;k<=j;k++) {
            if(visited[s.charAt(k)])
                return false;
            visited[s.charAt(k)] = true; 
        }
        
        return true;
    }
    
    /*
    Time Complexity -> O(n^3)
    Space Complexity -> O(1)
    */
    public int naiveSolution2(String s) {
        int max = 0;
        int n = s.length();
        
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(areDistinct(s,i,j))
                    max = Math.max(max,j-i+1);
            }
        }
        
        return max;
    }
    
    /*
    Time Complexity -> O(n^2)
    Space Complexity -> O(n)
    */
    public static int betterSolutionWithHashSet(String s) {
        int n = s.length();
        HashSet<Character> set;
        int max = 0;
        
        for(int i=0;i<n;i++) {
            set = new HashSet<>();
            for(int j=i;j<n;j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    max = Math.max(max,set.size());
                    set = new HashSet<>();
                }
                max = Math.max(max,set.size());
            }
        }
        
        return max;
    }
    
    /*
    HashSet'e göre çok daha verimli.
    Time Complexity -> O(n^2)
    Space Complexity -> O(1)
    */
    public static int betterSolutionWithHashTable(String s) {
        int n = s.length();
        int max = 0;
        
        for(int i=0;i<n;i++) {
            boolean[] visited = new boolean[CHAR_SIZE];
            
            for(int j=i;j<n;j++) {
                if(visited[s.charAt(j)]) {
                    break;
                } else {
                    max = Math.max(max,j-i+1);
                    visited[s.charAt(j)] = true;
                }
            }
        }
        
        return max;
    }
    
    /*
    Time Complexity -> BigTheta(n)
    Space Complexity -> O(1) 
    Her defasında önceki indiste biten en uzun substringin uzunluğunu tut. Stringteki ilk karakter için bu değer 1'e eşit.
    i. indeks için hesaplama yaparken 2 durum var. 
        1-) i-1 indekste biten en uzun substring içinde verilen stringin i. indeksindeki eleman yoksa. Bu durumda i. indekste biten en uzun substringin uzunluğu...
        i-1. indekste biten en uzun substringin uzunlugunun bir eksiği olacaktır.
        2-) i-1 indekste biten en uzun substring içinde verilen stringin i. indeksindeki eleman varsa. Bu durumda bu karakterin i. indekse kadar olan string içerisinde...
        en son nerede tekrar ettiği bulunur. Bu indeksin 1 fazlasından i. indekse kadar olan kısım yeni i. indekste biten en uzun substringin değeri olacaktır.
    */
    public static int efficientSolution(String s) {
        int n = s.length();
        if(n <= 1) { return n; }
        int max = 0;
        
        int[] prev = new int[CHAR_SIZE]; //Stringteki karakterler en son hangi indekste bulunmuş. for döngüsü içinde set ediliyorlar.
        Arrays.fill(prev,-1);
        int maxEnd = 1;
        prev[s.charAt(0)] = 0;
        
        for(int i=1;i<n;i++) {
            if(prev[s.charAt(i)] == -1 || prev[s.charAt(i)] < i-maxEnd) { //i. karakter i-1. indekste biten en uzun substring içinde yok
                maxEnd = maxEnd+1;
            } else { //i. karakter i-1. indekste biten en uzun substring içinde var
                maxEnd = i-prev[s.charAt(i)];
            }
            prev[s.charAt(i)] = i;
            max = Math.max(max,maxEnd);
        }
        
        return max;
    }   
}
