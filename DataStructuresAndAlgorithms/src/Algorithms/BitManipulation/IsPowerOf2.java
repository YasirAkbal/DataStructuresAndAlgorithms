/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class IsPowerOf2 {
    private IsPowerOf2() {}
    
    
    //BigTheta(1)
    public static boolean constatTimeSolution(int number) {
        if(number == 0) { return false; }
        return (number & (number-1)) == 0;
    }
}
