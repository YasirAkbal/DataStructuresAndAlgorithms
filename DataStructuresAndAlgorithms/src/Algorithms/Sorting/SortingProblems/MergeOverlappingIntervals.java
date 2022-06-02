/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author yasir
 */
public final class MergeOverlappingIntervals {
    private MergeOverlappingIntervals() {}
    
    public static ArrayList<int[]> solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int left;
        int right;
        ArrayList<int[]> result = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            while(i < n-1 && intervals[i+1][0] <= right) {
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            int[] arr = {left,right};
            result.add(arr);
        }
        
        return result;
    }
    
}
