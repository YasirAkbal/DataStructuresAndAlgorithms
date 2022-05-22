/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 * Bir dizide, dizinin boyutunun yarısından fazla sayıda tekrar eden elemanı bulma
 */
public final class MajorityElementInAnArray {
    private MajorityElementInAnArray() {}
       
    /*
    Possible majority elemanı kendisiyle aynı değere sahip her eleman gördüğünde count değeri...
    1 azaltılıyor. Farklı elenan görüldüğünde ise 1 azaltılıyor. Böylece birbirinden farklı her...
    çift count değerini 1 azaltırken, aynı değere sahip çiftler count değerini 1 arttırıyor.
    */    
    public static int solution(int[] arr) {
       int possibleMajorityIndex = 0;
       int count = 1;
       
       //eğer dizide majority eleman olduğu kesinse bu döngü her zaman majority elemanı bulur.
       for(int i=1;i<arr.length;i++) {
           if(arr[i] == arr[possibleMajorityIndex]) {
               count++;
           } else {
               count--;
           }
           if(count == 0) {
               possibleMajorityIndex = i;
               count = 1;
           }
       }
       
       count = 0;
       for(int i=0;i<arr.length;i++) {
           if(arr[i] == arr[possibleMajorityIndex]) {
               count++;
           }
       }
       
       if(count > arr.length/2) {
           return possibleMajorityIndex;
       }
       
       return -1;
    }
}
