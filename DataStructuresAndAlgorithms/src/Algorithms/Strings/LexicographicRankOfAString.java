/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class LexicographicRankOfAString {
    private static final int mod = 1000000007;
    private static final int CHAR_SIZE = 256;
    
    static long findRank(String S) {
        int n = S.length();
        long[] facts = new long[n+1];
        int[] counts = new int[CHAR_SIZE];
        long result = 1;
        
        facts[0] = 1;
        for(int i=1;i<=n;i++) {
            facts[i] = (facts[i-1]*i)%mod;
        }
        
        for(int i=0;i<n;i++) {
            counts[S.charAt(i)]++;
            if(counts[S.charAt(i)] > 1) 
                return 0;
        }
        
        for(int i=1;i<CHAR_SIZE;i++) 
            counts[i] = (counts[i] + counts[i-1])%mod;
        
        for(int i=0;i<n-1;i++) {
            long mult = (counts[S.charAt(i)-1]*facts[n-i-1])%mod;
            result = (result + mult)%mod;
            
            for(int j=S.charAt(i);j<CHAR_SIZE;j++) 
                counts[j]--;
        }
        
        return result;
    } 
}
