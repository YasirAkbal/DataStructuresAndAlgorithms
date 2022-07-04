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
public class LinearCongruental implements RandomI {
    private final int c = 1664525;
    private final int b = 1013904223;
    private final int mod = (int)(Math.pow(2,31)-1);
    private final int max;
    private int lastNum = 1;
    
    public LinearCongruental() {
        this.max = (int)Math.pow(2,31);
    }
    
    public LinearCongruental(int max)  {
        this.max = max;
    }
    
    @Override
    public int nextInt() {
        lastNum = (c*lastNum+b)%mod;
        if(lastNum < 0)
            lastNum += mod;
        return lastNum%max;
    }
    
}
