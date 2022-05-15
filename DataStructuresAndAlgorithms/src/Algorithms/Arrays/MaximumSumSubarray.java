/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

import java.util.Arrays;


/**
 *
 * @author yasir
 */
public final class MaximumSumSubarray {
    private MaximumSumSubarray() {}
    
    //Time Complexity -> BigTheta(n)
    //Auxiliary Space -> BigTheta(n)
    public static int solution1(int[] arr) {
        int[] tabu = new int[arr.length+1];
        boolean isAllPositive = true;
        boolean isAllNegative = true;
        int sum = 0;
        int globalMax = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++) {
            tabu[i+1] = arr[i] + tabu[i];
            isAllPositive = isAllPositive && (arr[i] >= 0);
            isAllNegative = isAllNegative && (arr[i] <= 0);
            if(arr[i] > globalMax) {
                globalMax = arr[i];
            }
            sum += arr[i];
        }
        
        if(isAllPositive) { return sum; }
        else if(isAllNegative) { return globalMax; }

        return MaximumDifferenceInAnArray.solution(tabu);
    }
    
    
    //Time Complexity -> BigTheta(n)
    //Auxiliary Space -> BigTheta(1)
    /*
    0'dan j'ye kadar olan dizide olabilecek maksimum toplamı maxEnding değişkeninde tut.
    Bir sonraki elemana bakılırken bu diziden bir önceki elemana kadar olabilecek ....
    maksimum toplam(maxEnding) ile arr[i]'yi topla. Eğer sonuç arr[i]'den büyükse max sub array...
    arr[i]'yi de kapsayacak şekilde sağa doğru genişlemeye devam edecektir. Eğer bu sonuç...
    arr[i]'den küçükse arr[i] ile yeni bir olası max sub array oluşturulmuş olacaktır.
    Tüm olası max sub arraylerin toplamı hesaplandığında bunlardan en büyüğü sonuç olacaktır.
    */
    public static int solution2(int[] arr) {
        //arr[i] ile bir subarrayin max toplamını tutar.
        int maxEnding = arr[0];
        int result = arr[0];
        
        for(int i=1;i<arr.length;i++) {
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }
        
        return result;
    }
}
