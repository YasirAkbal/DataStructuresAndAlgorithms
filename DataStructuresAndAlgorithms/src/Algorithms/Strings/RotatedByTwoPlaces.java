/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
 */
public class RotatedByTwoPlaces {
    public static boolean isRotated(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n != m) return false;
        
        boolean isLeftRotated = true;
        for(int i=2;i<n+2;i++) {
            if(str1.charAt(i%n) != str2.charAt(i-2)) {
                isLeftRotated = false;
                break;
            }
        }
        
        boolean isRightRotated = true;
        for(int i=n-2;i<2*n-2;i++) {
            if(str1.charAt(i%n) != str2.charAt(i-n+2)) {
                isRightRotated = false;
                break;
            }
        }
        
        return isLeftRotated || isRightRotated;
    }  
}
