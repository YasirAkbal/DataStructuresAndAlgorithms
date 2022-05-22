/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class MinimumConsecutiveFlips {
    private MinimumConsecutiveFlips() {}
    
    public static int solution(int[] arr) {
        int flipCountZeros = 0;
        int flipCountOnes = 0;
        
        for(int i=0;i<arr.length-1;i++) {
            if((arr[i] ^ arr[i+1]) == 1) {
                if(arr[i] == 0) { flipCountZeros++; }
                else { flipCountOnes++; }
            }
        }
        
        if(arr[arr.length-1] == 0) { flipCountZeros++; }
        else { flipCountOnes++; }
        
        int selectedBitForFlip = flipCountZeros <= flipCountOnes ? 0 : 1;
        
        int start = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == selectedBitForFlip) {
                if(start == -1) { start = i; }
            } else if(start != -1) {
                System.out.println("From " + start + " to " + (i-1));
                start = -1;
            }
        }
        
        if(arr[arr.length-1] == selectedBitForFlip) {
            System.out.println("From " + start + " to " + (arr.length-1));
        }
        
        return selectedBitForFlip;
    }
    
    /*
    Dizideki ilk bitin grup sayısı diğer bitin grup sayısından ya 1 fazladır ya da eşittir.
    Bu yüzden ilk grubun tersi bulunarak en sayıda flip yaptıracak bit bulunabilir.
    */
    public static int efficientSolution(int[] arr) {
        int selectedBitForFlip = (arr[0] == 0) ? 1 : 0;
        
        int start = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == selectedBitForFlip) {
                if(start == -1) { start = i; }
            } else if(start != -1) {
                System.out.println("From " + start + " to " + (i-1));
                start = -1;
            }
        }
        
        if(arr[arr.length-1] == selectedBitForFlip) {
            System.out.println("From " + start + " to " + (arr.length-1));
        }
        
        return selectedBitForFlip;
    }
}
