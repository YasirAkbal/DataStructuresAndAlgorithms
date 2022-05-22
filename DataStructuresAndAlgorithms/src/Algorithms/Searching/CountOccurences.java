/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class CountOccurences {
    private CountOccurences() {}
    
    public static int solution(int[] arr, int x) {
        int first = FirstOccurence.iterative(arr, x);
        if(first == -1) { return 0; }
        
        return LastOccurence.iterative(arr, x) - first + 1;
    }
}
