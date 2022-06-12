/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * Girdi olan verilen textteki, girdi olarak pattern'ın tüm başlangıç indekslerini bulmak. String Pattern Search
 */
public class PatternSearch {
    /*
    Time Complexity -> O((n-m+1)*m)
    Auxiliary Space -> O(1)
    Tekrarlı durumlarda en kötü durum oluşur. Örn; text = "AAAAAA", pattern = "AAA".
    */
    public static ArrayList<Integer> naivePatternSearch(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int j;
        for(int i=0;i<n-m+1;i++) {
           for(j=0;j<m;j++) {
               if(text.charAt(i+j) != pattern.charAt(j)) {
                   break;
               }
           }  
           if(j == m) {
               result.add(i);
           }
        }
        
        return result;
    }
    
    /*
    Pattern'ın tekrar etmediği biliniyorsa Naive Pattern Search Algoritması optimize edilebilir.
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> O(1)
    */
    public static ArrayList<Integer> optimizedNaivePatternSearch(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int j;
        for(int i=0;i<n-m+1;) {
           for(j=0;j<m;j++) {
               if(text.charAt(i+j) != pattern.charAt(j)) {
                   break;
               }
           }  
           if(j == m) {
               result.add(i);
           }
           
           if(i == 0)
               i++;
           else
               i += j;
        }
        
        return result;
    }
    
    
    /*
    mod -> cok büyük sayılarla uğraşmamak için
    d -> hash fonksiyonunda basit olarak karakterlerin Unicode değerlerini toplamak yerine onları ağırlıklandırarak topluyoruz. Bu ağırlık değeri ise d...
    d değerinin üssü windowdaki ilk eleman için m-1 değerini alırken son eleman için 0 değerini alıyor. (m = pattern stringinin boyutu)
    Bu algoritmada ilk olarak karakterlerinin eşitliğini kontrol etmek yerine öncelikle pattern ve sliding window için hash değerlerinin eşitliğini kontrol ediyoruz.
    Hash değerleri eşitse karakterlerin eşitlikleri kontrol ediliyor. Üzerinde arama yapılan text'in en baştan başlanarak her m boyutlu(pattern stringinin boyutu)...
    window'unun hash değeri hesaplanıyor. Bu işlemi verimli bir şekilde gerçekleştirebilmek için her bir sonraki pencere'nin hash değerini hesaplamak için önceki pencerenin...
    hash değerinden faydalanılıyor. 
    */
    /*
    Time Complexity -> O((n-m+1)*m)
    *Worst Case -> BigTheta((n-m+1)*m) -> Kötü bir hash fonksiyonu ve pattern'nin tekrar ettiği durumlarda. Worst case'de naive'den daha yavaş çalışır(ektsra hash hesaplamaları nedeniyle)
    *Average and Best Cese -> BigTheta(n+m)
    */
    private static final int mod = 101;
    private static final int d = 256;
    public static ArrayList<Integer> rabinKarpAlgorithm(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int dPowMinusOne = 1;
        int windowHash = 0;
        int patHash = 0;
        
        for(int i=0;i<m-1;i++) 
            dPowMinusOne = (dPowMinusOne*d)%mod;

        for(int i=0;i<m;i++) { // t[0]*5^(m-1) + t[1]*5^(m-2) + ... + t[m-1]*5^0
            windowHash = (windowHash*d + text.charAt(i))%mod;
            patHash = (patHash*d + pattern.charAt(i))%mod;
        }
        
        for(int i=0;i<n-m+1;i++) {
            if(windowHash == patHash) {
                int j;
                for(j=0;j<m;j++) {
                    if(text.charAt(i+j) != pattern.charAt(j))
                        break;
                }
                if(j == m)
                    result.add(i);
            }
            
            if(i < n-m) { //zaten en son window'a ulaşmışsan bir sonraki window olmayacağı için hash değeri hesaplama. aksi halde indexbounds hatası alınacak.
                windowHash = (d*(windowHash - dPowMinusOne*text.charAt(i)) + text.charAt(i+m))%mod;
                if(windowHash < mod) //hash negatifse pozitif yap.
                    windowHash += mod;
            }
        }
        
        return result;
    }
}
