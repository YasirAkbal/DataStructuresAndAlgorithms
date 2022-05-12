/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 * Bir sayı dizinde tek sayıda tekrarlanan sayıyı bulma
 */
public final class FindOddOccurences {
    private FindOddOccurences() { }
    
    /*
    x ^ 0 = x
    x ^ x = 0
    x ^ y = y ^ x
    x ^ (y ^ z) = (x ^ y) ^ z
    XOR işleminde değişme özelliği olduğu için x sayısının bulunduğu bir ara toplamla, x sayısını...
    ardışık XOR işlemine sokmak işlemi değiştirmez. Örn;...
    x^(y^x) = k olsun. Değişme özelliğinde (y^x) = (x^y) yazılabilir. x^(x^y) = k oldu...
    Birleşme özelliğinden (x^x)^y = k yazılabilir. x^x = 0 olacaktır. 0^y = y olur.
    Yani bir XOR işlem dizisindeki bir sayı çift sayıda işleme sokuluyorsa kendi kendini ekarte eder.
    */
    public static int solution1(int[] numbers) {
        int result = 0;
        
        for(int i=0;i<numbers.length;i++) {
            result = result ^ numbers[i];
        }
        
        return result;
    }
}
