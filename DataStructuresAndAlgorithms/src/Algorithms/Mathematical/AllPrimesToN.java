/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

import java.util.Arrays;

/**
 *
 * @author yasir
 */
public final class AllPrimesToN {
    private void AllPrimesToN() { }
    
    //BigO(n*sqrt(n))
    public static void inefficientSolution(int n) {
        for(int i=2;i<=n;i++) {
            if(IsPrime.efficientSolution1(i)) {
                System.out.print(i + " ");
            }
        }
    }
    
    //sieve of eratosthenes
    //BigO(n*loglogn)
    public static void efficientSolution(int n) {
        if(n < 2) { return; }
        
        boolean[] isPrimeArr = new boolean[n+1];
        Arrays.fill(isPrimeArr, true);
        
        for(int i=2;i*i<=n;i++) { 
            if(isPrimeArr[i]) { 
                int j = 2;
                while(i*j <= n) { 
                    isPrimeArr[i*j] = false;
                    j++;
                }
            }
        }
        
        for(int i = 2;i<n+1;i++) {
            if(isPrimeArr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
