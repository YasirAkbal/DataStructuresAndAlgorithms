/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Algorithms.RandomNumber;

import Algorithms.Mathematical.AllPrimesToN;
import Algorithms.RandomNumber.Abstract.RandomI;
import Algorithms.RandomNumber.Algorithms.Algorithm147;
import Algorithms.RandomNumber.Algorithms.BlumBlumShub;
import Algorithms.RandomNumber.Algorithms.Engel;
import Algorithms.RandomNumber.Algorithms.FourR;
import Algorithms.RandomNumber.Algorithms.LinearCongruental;

/**
 *
 * @author yasir
 */
public class RandomTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //dist(new Algorithm147());
        //dist(new BlumBlumShub());
        //dist(new Engel());
        //dist(new FourR());
        dist(new LinearCongruental());
    }
    
    static void dist(RandomI rand) {
        int max = 100;
        int[] counts = new int[max];
        
        for(int i=0;i<100000;i++) {
            counts[rand.nextInt()%max]++;
        }
 
        for(int i=0;i<max;i++) {
            System.out.println("sayi = " + i + ", count = " + counts[i]);
        }
    }
}
