/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class CheckIfAStringIsSubsequenceOfOther {
    public static boolean isSubSequence(String A, String B)
    {
        int m = A.length();
        int n = B.length();
        
        int j = 0;
        for(int i=0;i<n;i++) {
            if(B.charAt(i) == A.charAt(j)) {
                j++;
            }
            if(j == m)
                return true;
        }
        
        return false;
    }
}
