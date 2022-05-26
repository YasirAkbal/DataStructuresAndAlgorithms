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
import Algorithms.Searching.*;
import Algorithms.Sorting.*;
import Utils.ArrayUtils;
import java.util.Arrays;

public class Test {
    private static ArrayUtils<Integer> utils = new ArrayUtils<>();
    /**
     * @param args the command line arguments
     */
    
    private static ArrayUtils<Integer> util = new ArrayUtils<>();
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
        
        //int[] arr = {1,4,31,6,1,20,3,10,5};
        //LeadersInAnArray.solution2(arr);
        //System.out.println(MaximumDifferenceInAnArray.solution(arr));
        //int[] sortedArr = {1,2,3};
        //FreqInSortedArray.solution1(sortedArr);
        
        //System.out.println(StockBuyAndSell.solution1(arr));
        //System.out.println(TrappingRainWater.solution1(arr));
        //System.out.println(MaximumSumSubarray.solution2(arr));
        //System.out.println(MaximumCircularSubarraySum.solution2(arr));
        //System.out.println(MajorityElementInAnArray.solution(arr));
        //System.out.println(MinimumConsecutiveFlips.efficientSolution(arr));
        //System.out.println(SlidingWindowTechnique.maxKConsecutiveElements(arr, 3));
        //System.out.println(SlidingWindowTechnique.findSubarrayWithGivenSum(arr, 33));
        //SlidingWindowTechnique.N_BonacciNumber(3, 8);
        
        //int[] arr = {1,4,7,9,7,11,12,15,16};
        //System.out.println(FirstOccurence.recursive(arr, 7));
        //System.out.println(SquareRoot.efficientSolution(13));
        //System.out.println(TwoPointerApproach.isTripletSum(arr, 27));
        
        //Integer[] arr = {351,4,31,6,20,3,10,5,1};
        //SelectionSort.run(arr);
        //QuickSort.quickSort(arr);
        //utils.merge(arr, 0, 2, arr.length-1);
       
        /*MergeSort.iterative(arr);
        utils.printArr(arr);*/
        
        Integer[] zeroToN = {335,51235,1,0,5,14,1531,12,71,5};
        //CountingSort.countSort(zeroToN);
        //BinBucketSort.binBucketSort(zeroToN);
        RadixSort.radixSort(zeroToN);
        utils.printArr(zeroToN);
    }
    
}
