/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

/**
 *
 * @author yasir
 * Given a string arr consisting of lowercase english letters, arrange all its letters in lexicographical order using Counting Sort.
 */
public final class SortStringWithCountingSort {
    private SortStringWithCountingSort() {}
    
    public static String countSort(String arr)
    {
        int[] counts = new int[(int)('z'-'a')+1];
        char[] chars = new char[arr.length()];
        
        for(char c : arr.toCharArray()) {
            counts[(int)(c-'a')]++;
        }
        
        int index = 0;
        for(int i=0;i<counts.length;i++) {
            while(counts[i] > 0) {
                chars[index++] = (char)('a'+i);
                counts[i]--;
            }
        }
        
        return String.valueOf(chars);
    }
}
