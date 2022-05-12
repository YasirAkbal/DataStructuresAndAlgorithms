/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class CountSetBits {
    private static final int LEN = 256;
    private static final int CHUNK_SIZE = 8;
    private int[] table = new int[LEN];
    
    //lookUpTable metodu için gerekli preprocess
    public CountSetBits() {
        for(int i=1;i<LEN;i++) {
            table[i] = (i&1) + table[i/2]; // table[i] = i%2 + table[i>>1]
        }
    }
    
    //BigTheta(1)
    public int lookUpTable(int number) {
        int result = table[number & 0xff];
        
        number = number >> CHUNK_SIZE;
        result += table[number & 0xff];
        
        number = number >> CHUNK_SIZE;
        result += table[number & 0xff];
        
        number = number >> CHUNK_SIZE;
        result += table[number & 0xff];
        
        return result;
    }
    
    //BigTheta(log2(n))
    public static int solution1(int number) {
        int result = 0;
        while(number > 0) {
            if((number & 1) == 1) { // n % 2 == 1
                result++;
            }
            number = number >> 1; // n /= 2
        }
        
        return result;
    }
    
    //BigTheta(Set olan bit sayısı)
    /*
    2lik tabanda bir sayıdan 1 çıkarıldığında LSB'den başlanarak 1 olan bit aranır.
    Bu bit bulunduğunda onun değeri 0 olur.
    Yani set edilmiş LSB bitinin 0 olduğu bir sonuca erişiriz. Bu sonuçla o iterayondaki...
    sayımızı & işlemine soktuğumuzda sonuç en düşük basamak değerine sahip ve set edilmiş bitin...
    0 yapıldığı sayı olur. Bu işlemi üzerinde işlem yaptığımız sayı 0 olana kadar devam ettiririz.
    */
    public static int brianKerningam(int number) {
        int result = 0;
        while(number > 0) {
            number = (number & (number-1));
            result++;
        }
        
        return result;
    }
}
