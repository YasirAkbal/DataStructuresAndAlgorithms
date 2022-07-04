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
public class Engel implements RandomI {
    private double lastNum = 0.27343;
    private final double x = 1.226;
    private final double pow = Math.pow(2, 31)-1;
    
    @Override
    public int nextInt() {
        lastNum = Math.pow(lastNum+x, 8);
        lastNum = lastNum - (int)lastNum;
        return (int)(lastNum*pow);
    }
    
}
