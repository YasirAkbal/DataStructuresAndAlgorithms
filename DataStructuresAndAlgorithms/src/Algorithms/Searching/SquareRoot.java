/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class SquareRoot {
    private SquareRoot() {}
    
    //BigO(sqrt(x))
    public static int naiveSolution(int x) {
        int i=1;
        while(i*i <= x) {
            i++;
        }
        
        return i-1;
    }
    
    //BigO(log(x))
    public static int efficientSolution(int x) {
        int left = 1;
        int right = x;
        int answer = 1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            int mSquare = mid*mid;
            if(mSquare == x) {
                return mid;
            } else if(mSquare > x) {
                right = mid-1;
            } else {
                left = mid+1;
                answer = mid;
            }
        }
        
        return answer;
    }
}
