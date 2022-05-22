/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * Verilen n boyutlu dizideki her k boyutlu alt dizinin ayrı ayrı tersinin alınması
 * N = 5, K = 3
 * arr[] = {1,2,3,4,5}
 * Output: 3 2 1 5 4
 */
public final class ReverseInGroups {
    private ReverseInGroups() {}
    
    void solution(ArrayList<Integer> arr, int n, int k) {
        int K = Math.min(k,n);
        for(int i=0;i<(int)Math.ceil((float)n/K);i++)
        {
            int count = 1;
            int startIndex = i*K;
            int endIndex = Math.min((i+1)*K, n);
            int reverseEndIndex = (int)((float)startIndex+endIndex)/2;
            
            for(int j=startIndex;j<reverseEndIndex;j++) {
                int temp = arr.get(j);
                arr.set(j,arr.get(endIndex-count));
                arr.set(endIndex-count,temp);
                count++;
            }
        }
    }
    
}
