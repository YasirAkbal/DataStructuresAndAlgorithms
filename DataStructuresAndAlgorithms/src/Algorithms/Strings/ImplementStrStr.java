/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class ImplementStrStr {
    public static int strstr(String s, String x)
    {
       int n = s.length();
       int m = x.length();
       
       if(n < m) return -1;
       
       for(int i=0;i<n-m+1;i++) {
           int j;
           for(j=0;j<m;j++) {
               if(s.charAt(i+j) != x.charAt(j))
                break;
           }
           
           if(j == m)
               return i;
       }
       
       return -1;
    } 
}
