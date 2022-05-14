/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class HanoiProblem {
    private HanoiProblem() { }
    
    public static void solution(int n) {
        _solution(n,'A','B','C');
    }
    
    private static void _solution(int n, char a, char b, char c) {
        if(n == 0) {
            return;
        }
        
        _solution(n-1,a,c,b);
        System.out.println("Move Disc " + n + " from " + a + " to " + c);
        _solution(n-1,b,a,c);
    }
}
