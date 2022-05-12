/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class TwoOddOccurences {
    private TwoOddOccurences() { }
    
    /*
    Bir sayı dizisinde tek sayıda tekrar eden 2 sayıyı bulan algoritma
    Tüm sayıları XOR işlemine tabi tutunca sonuç tek sayıda tekrar eden 2 sayının XOR işlemine...
    tabi tutulmuş haline eşit olacaktır -> x1 ^ x2 = y
    XOR işleminde iki bit farklı değerde ise sonuç 1 olur. Dolayısıyla y'nin Rightmost set bitine bakarak...
    aradağımız tek sayıda tekrar eden 2 sayıyı 2 farklı gruba ayırabiliriz. Sonrasında FindOddOccurences...
    probleminde uyguladığımız aynı mantık uygulanır.
    */
    public static void solution(int[] numbers) {
        int xor = 0, result1 = 0, result2 = 0;
        
        for(int i=0;i<numbers.length;i++) {
            xor ^= numbers[i];
        }
        
        int sn = xor & (~(xor-1));
        
        for(int i=0;i<numbers.length;i++) {
            if((numbers[i] & sn) == 0) {
                result1 ^= numbers[i];
            } else {
                result2 ^= numbers[i];
            }
        }
        
        System.out.println("("+result1+", "+result2+")");
    }
}
