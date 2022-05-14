/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class RopeCuttingProblem {
    private RopeCuttingProblem() { }
    
    
    //BigO(3^n)
    public static int solution(int n, int a, int b, int c) {
        if(n <= 0) { return 0; }
        int[] arr = { a, b, c };

        int max = -1;
        
        for(int x : arr) {
            if(x <= n) {
                int tempResult = 1 + solution(n-x,a,b,c);
                if(tempResult > max) {
                    max = tempResult;
                }
            }
        }
        
        
        return max == 0 ? -1 : max;
    }
}
