/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class RabinKarp {
    private static int d = 256;
    public static boolean search(String pat, String txt, int q) {
        int n = txt.length();
        int m = pat.length();
        int dPowMinusOne = 1;
        int patHash = 0;
        int windowHash = 0;
        
        for(int i=0;i<m-1;i++)
            dPowMinusOne = (dPowMinusOne*d)%q;
        
        for(int i=0;i<m;i++) {
            patHash = (patHash*d + pat.charAt(i))%q;
            windowHash = (windowHash*d + txt.charAt(i))%q;
        }

        for(int i=0;i<n-m+1;i++) {
            if(patHash == windowHash) {
                int j;
                for(j=0;j<m;j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) 
                        break;
                }
                if(j == m)
                    return true;
            }
            
            if(i < n-m) {
                windowHash = (d*(windowHash-dPowMinusOne*txt.charAt(i)) + txt.charAt(i+m))%q;
                if(windowHash < 0)
                    windowHash += q;
            }
        }
        
        return false;
    }
}
