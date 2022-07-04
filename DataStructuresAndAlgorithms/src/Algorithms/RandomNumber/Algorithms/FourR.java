/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.RandomNumber.Algorithms;

import Algorithms.RandomNumber.Abstract.RandomI;

/**
 *
 * @author yasir
 */
public class FourR implements RandomI {
    private final int R = 2;
    private final int powForLastR = (int)Math.pow(10, R);
    private final int powForFirstR = (int)Math.pow(10, 3*R);
    private int lastNum = 53178196; //4*R basamak adedi 
    
    private void removeFirstR() {
        lastNum %= powForFirstR; 
    }
    
    private void removeLastR() {
        lastNum /= powForLastR;
    }
    
    @Override
    public int nextInt() {
        removeFirstR();
        removeLastR();
        lastNum *= lastNum;
        return lastNum;
    }
}
