/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class JosephusProblem {
    private JosephusProblem() { }
    
    
    //BigTheta(n)
    public static int solution(int n, int k) {
        if(n == 1) { return 0; }
        
        return (solution(n-1,k) + k) % n;
    }
}
