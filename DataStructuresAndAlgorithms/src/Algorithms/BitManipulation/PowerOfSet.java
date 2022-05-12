/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class PowerOfSet {
    private PowerOfSet() {}
    
    //BigTheta((2^n)*n)
    public static void solution(String word) {
        int n = word.length();
        int powSize = 1 << n; //pow(2,n)
        
        for(int count=0;count<powSize;count++) {
            for(int i=0;i<n;i++) {
                if((count & (1 << i)) != 0) { //count'ın i. bitine bak
                    System.out.print(word.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
