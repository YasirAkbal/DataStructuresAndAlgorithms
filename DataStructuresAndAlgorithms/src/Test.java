/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author yasir
 */

import Algorithms.Mathematical.*;
import Algorithms.BitManipulation.*;
import Algorithms.Recursive.*;
import Algorithms.Arrays.*;
import Utils.ArrayUtils;
import java.util.Arrays;

public class Test {
    private static ArrayUtils<Integer> utils = new ArrayUtils<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PrimeFactors.efficientSolution1Optimized(105);
        //AllPrimesToN.inefficientSolution(153);
        /*CountSetBits c = new CountSetBits();
        System.out.println(c.lookUpTable(0));*/
        /*int[] arr = {3,4,4,3,5,1,1,5};
        System.out.println(FindOddOccurences.solution1(arr));*/
        /*int[] arr = {1,2,3,5,6};
        System.out.println(FindMissingNumber1ToN.solution(arr));*/
        /*int xor = 3;
        System.out.println(xor & (~(xor - 1)));
        System.out.println(~2);
        int[] arr = {3,4,4,3,5,1,1,5,7,1,1,9};
        TwoOddOccurences.solution(arr);*/
        //PowerOfSet.solution("abcd");
        //GenerateSubsets.solution("abc");
        //HanoiProblem.solution(2);
        //System.out.println(RopeCuttingProblem.solution(25, 5, 14, 12));
        //System.out.println(SumOfDigits.solution(43));
        //System.out.println(Algorithms.Recursive.Palindrome.solution("selam"));
        //System.out.println(JosephusProblem.solution(4, 3));
        /*int[] arr = {10,5,2,3,6};
        System.out.println(SubsetSumProblem.solution1(arr, 31));*/
        //AllPermutations.solution1("ABC");
        //AllPermutations.solution2("ABC");
        
        //Integer[] arr = {1,2,3,4,5};
        //utils.reverse(arr);
        //System.out.println(SecondLargestInArray.solution(arr));
        //LeftRotateAnArray.leftRotateDTimesSolution4(arr, 2);
        
        int[] arr = {5,-2,3,4};
        //LeadersInAnArray.solution2(arr);
        //System.out.println(MaximumDifferenceInAnArray.solution(arr));
        //int[] sortedArr = {1,2,3};
        //FreqInSortedArray.solution1(sortedArr);
        
        //System.out.println(StockBuyAndSell.solution1(arr));
        //System.out.println(TrappingRainWater.solution1(arr));
        //System.out.println(MaximumSumSubarray.solution2(arr));
        System.out.println(MaximumCircularSubarraySum.solution2(arr));
    }
    
}
