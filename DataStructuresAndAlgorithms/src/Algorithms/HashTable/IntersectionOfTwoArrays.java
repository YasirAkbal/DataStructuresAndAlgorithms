/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author yasir
 */
public final class IntersectionOfTwoArrays {
    private IntersectionOfTwoArrays() {}
    
    /*
    Time Complexity -> BigTheta(n+m)
    Auxiliary Space -> BigTheta(min(n,m))
    HashSet yapısında Delete işleminin maliyetli olmadığı durumda ekstra alan kullanımını minimize eden çözüm
    */
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        Set<Integer> set = new HashSet<>();
        int[] arrForSet;
        int[] arrForCheck;
        
        if(n < m) {
            arrForSet = a;
            arrForCheck = b;
        } else {
            arrForSet = b;
            arrForCheck = a;
        }
        
        for(int x : arrForSet) {
            set.add(x);
        }
        
        int count = 0;
        for(int x : arrForCheck) {
            if(set.contains(x)) {
                count++;
                set.remove(x);
            }
        }
        
        return count;
    }
}
