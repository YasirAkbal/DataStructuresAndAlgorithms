/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class PowerOfNumber {
    private PowerOfNumber() { }
    
    
    //BigTheta(log2(n))
    //Divide and Conquer'a benzer bir yaklaşım var
    public static int powerRecursive(int number, int x) {
        if(x == 0) { return 1; }
        
        int result = powerRecursive(number, x/2);
        result *= result;
        
        if(x%2 == 0) { return result; }
        //Eğer x tek ise 1 çarpma işlemi eksik yapılmıştır.
        //resulti burada tekrar input olarak verilen sayı ile çarp
        else { return result*number; }
    }
    
    
    //BigTheta(log2(n))
    /*
    Üs değerini 2'lik tabanda düşün.
    Son biti 1 ise result *= temp olur. 0'sa hiçbir işlem yapılmaz.
    Her iterasyon sonunda üs 2'ye bölünür yani son biti atılır.
    19 -> 10011 -> her bir bit 3^(2^i) çarpanını ifade eder;
    3^19 = 1*3^16 * 0*3^8 * 0*3^4 * 0*3^2 * 0*3^1
    */
    public static int powerIteratif(int number, int x) {
        int result = 1;
        int temp = number;
        
        while(x > 0) {
            if(x % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
            x /= 2;
        }
        
        return result;
    }
}
