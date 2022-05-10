/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class PrimeFactors {
    private PrimeFactors() { }
    
    public static void solution1(int number) { // O(n*sqrt(n)*logn)
        for(int i=2;i<number;i++) { //O(n)
            if(IsPrime.efficientSolution1(i)) { //O(sqrt(n))
                int x = i;
                while(number % x == 0) { // O(logn)
                    System.out.print(i + " ");
                    x *= i;
                }
            }
        }
    }
    
    //BigTheta(sqrt(n)) -> Worst case = prime olma durumu
    public static void efficientSolution1(int number) {
        if(number <= 1) { return; }
        
        //BigO(sqrt(n))
        for(int i=2;i*i<=number;i++) {
            //BigO(logn)
            //Worst case'de bu while dongusune girmez
            while(number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }
        
        //en büyük asal bölen tek sayıda ise buraya düşer
        if(number > 1) {
            System.out.print(number);
        }
    }
    
    //BigTheta(sqrt(n)) -> Worst case = prime olma durumu
    public static void efficientSolution1Optimized(int number) {
        if(number <= 1) { return; }
        while(number % 2 == 0) {
            System.out.print(2 + " ");
            number /= 2;
        }
        while(number % 3 == 0) {
            System.out.print(3 + " ");
            number /= 3;
        }
        
        //BigO(sqrt(n))
        for(int i=5;i*i<=number;i+=6) {
            //BigO(logn)
            //Worst case'de bu while dongulerine girmez
            while(number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
            while(number % (i+2) == 0) {
                System.out.print((i+2) + " ");
                number /= (i+2);
            }
        }
        
        //number > 1
        if(number > 3) {
            System.out.print(number);
        }
    }
}
