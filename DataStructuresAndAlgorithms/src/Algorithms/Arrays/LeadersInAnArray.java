/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class LeadersInAnArray {
    private LeadersInAnArray() {}
    
    
    //BigO(n^2)
    public static void solution1(int[] arr) {
        int i;
        for(i=0;i<arr.length;i++) {
            boolean isLeader = true;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            
            if(isLeader) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    
    
    //BigTheta(n)
    public static void solution2(int[] arr) {
        int currentLeader = arr[arr.length-1];
        System.out.print(currentLeader + " ");
        
        for(int i=arr.length-2;i>0;i--) {
            if(currentLeader < arr[i]) {
                currentLeader = arr[i];
                System.out.print(currentLeader + " ");
            }
        }
    }
}
