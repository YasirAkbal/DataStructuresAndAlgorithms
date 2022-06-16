/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class AnagramSearch {
    private static final int CHAR_SIZE = 256;
    
    //O(n^2)
    public static boolean naiveSolution(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if(n < m) return false;
        
        for(int i=0;i<n-m+1;i++) {
            if(areAnagram(text, pattern, i))
                return true;
        }
        
        return false;
    }
    
    private static boolean areAnagram(String text, String pattern, int startIndex) {
        int[] count = new int[CHAR_SIZE];
        
        for(int i=0;i<pattern.length();i++) {
            count[text.charAt(startIndex+i)]++;
            count[pattern.charAt(i)]--;
        }
        
        for(int i=0;i<CHAR_SIZE;i++) {
            if(count[i] != 0)
                return false;
        }
        
        return true;
    }
    
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> O(1)
    CHAR_SIZE kadar dönen döngüler ve CHAR_SIZE boyutlu ekstra diziler, CHAR_SIZE girdinin boyutuna göre değişmediği için karmaşıkları etkilemedi.
    */
    public static boolean efficientSolution(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if(n < m) return false;  
        
        int[] cText = new int[CHAR_SIZE];
        int[] cPattern = new int[CHAR_SIZE];
        
        for(int i=0;i<m;i++) {
            cText[text.charAt(i)]++;
            cPattern[pattern.charAt(i)]++;
        }
        
        for(int i=m;i<n;i++) {
            if(areSameArrays(cText, cPattern))
                return true;
            
            cText[text.charAt(i)]++;
            cText[text.charAt(i-m)]--;
        }
        
        return false;
    }
    
    private static boolean areSameArrays(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return false;
        
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        
        return true;
    }
}
