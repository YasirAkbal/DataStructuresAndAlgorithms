/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import java.util.Arrays;

/**
 *
 * @author yasir
 */
public final class MeetingTheMaxGuests {
    private MeetingTheMaxGuests() {}
    
    public static int solution(int[] arrive, int[] leave) {
        Arrays.sort(arrive);
        Arrays.sort(leave);
        int n = arrive.length;
        
        int max = 1;
        int count = 1;
        
        int i = 1;
        int j = 0;
        
        while(i < n && j < n) {
            if(arrive[i] <= leave[j]) {
                count++; i++;
            } else {
                count--; j++;
            }
            max = Math.max(max,count);
        }
        
        return max;
    }
}
