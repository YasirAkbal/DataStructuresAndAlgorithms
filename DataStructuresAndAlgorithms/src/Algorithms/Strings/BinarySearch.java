/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 * Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 */
public class BinarySearch {
    public static int binarySubstring(int n, String str)
    {
        int count = 0;
        
        for(int i=0;i<n;i++) {
            if(str.charAt(i) == '1')
                count++;
        }
        
        return count*(count-1)/2;
    }
}
