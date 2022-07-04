/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.RandomNumber.Algorithms;

import Algorithms.RandomNumber.Abstract.RandomI;

/**
 *
 * @author yasir
 * p ve q asal sayı
 * M = p*q
 * s = [0, M-1] arasında keyfi bir değer
 */
public class BlumBlumShub implements RandomI {
    private final int p = 4729; 
    private final int q = 3413;
    private final int M;
    private int lastNumber;
    
    public BlumBlumShub() {
        M = p*q;
        int s = (int)(M - M*0.31); // [0, M-1] arasında keyfi bir sayı seçiliyor
        lastNumber = (s*s)%M;
        if(lastNumber < 0)
            lastNumber += M;
    }

    @Override
    public int nextInt() {
        lastNumber = (lastNumber*lastNumber)%M;
        if(lastNumber < 0)
            lastNumber += M;
        return lastNumber;
    }
    
    
}
