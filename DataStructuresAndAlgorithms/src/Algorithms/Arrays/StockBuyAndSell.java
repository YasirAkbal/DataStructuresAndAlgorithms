/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class StockBuyAndSell {
    private StockBuyAndSell() {}
    
    
    //BigTheta(n)
    public static int solution1(int[] arr) {
      int currentMax;
      int sumProfit = 0;
      
      for(int i=arr.length-1;i>0;i--) {
          currentMax = arr[i];
          while(i > 0 && arr[i] > arr[i-1]) {
              i--;
          }
          sumProfit += currentMax - arr[i];
      }
      
      return sumProfit;
    }
}
