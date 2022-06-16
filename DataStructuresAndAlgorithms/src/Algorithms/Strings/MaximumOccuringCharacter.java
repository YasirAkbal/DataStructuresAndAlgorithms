/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class MaximumOccuringCharacter {
    private static final int CHAR_SIZE = 256;

    public static char getMaxOccuringChar(String line) {
        int[] counts = new int[CHAR_SIZE];
        int n = line.length();
        int max = 0;

        for(int i=0;i<n;i++) {
            counts[line.charAt(i)]++;
        }
        
        for(int i=1;i<CHAR_SIZE;i++) {
            if(counts[i] > counts[max]) {
                max = i;
            }
        }
        
        return (char)max;
    }
}
