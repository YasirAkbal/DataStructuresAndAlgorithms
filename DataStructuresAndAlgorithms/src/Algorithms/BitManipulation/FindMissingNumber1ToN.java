/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class FindMissingNumber1ToN {
    private FindMissingNumber1ToN() {}
    
    /*
    FindOddOccurences probleminin çözümündekiyle aynı mantık. Çift sayıda XOR işlemine sokulan sayılar..
    birbirini ekarte eder.
    BigTheta(log2(n))
    numbers = 1 den n+1'e kadar olan sayılar ama bu sayılardan biri eksik. (n = numbers.length)
    */
    public static int solution(int[] numbers) {
        int result = 0;
        for(int number: numbers) {
            result ^= number;
        }
        
        for(int i=1;i<=numbers.length+1;i++) {
            result ^= i;
        }
        
        return result;
    }
}
