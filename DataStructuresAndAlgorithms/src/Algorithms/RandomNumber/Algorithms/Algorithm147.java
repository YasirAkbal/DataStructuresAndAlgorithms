/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.RandomNumber.Algorithms;

import Algorithms.RandomNumber.Abstract.RandomI;

/**
 *
 * @author yasir
 * 0'dan küçük ve 7 tane ondalık basamağı olabilir sayı seçilir -> 0.a1a2a3a4a5a6a7
 * a7 =  5 dışındaki tek rakamlardan biri
 */
public class Algorithm147 implements RandomI {
    private double lastNum = 0.3781467;
    private final double pow = Math.pow(2, 31)-1;
     
    @Override
    public int nextInt() {
        double mult = 147*lastNum;
        lastNum = mult - (int)mult;
        return (int)(lastNum*pow);
    }
    
}
