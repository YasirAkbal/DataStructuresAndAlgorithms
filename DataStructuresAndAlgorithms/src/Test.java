/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author yasir
 */

import Algorithms.Sorting.SortingAlgorithms.RadixSort;
import Algorithms.Mathematical.*;
import Algorithms.BitManipulation.*;
import Algorithms.Recursive.*;
import Algorithms.Arrays.*;
import Algorithms.HashTable.LongestSubArrayWithGivenSum;
import Algorithms.Searching.*;
import Algorithms.Sorting.SortingAlgorithms.*;
import Algorithms.Sorting.SortingProblems.DutchNationalFlag;
import Algorithms.Sorting.SortingProblems.KthSmallestElement;
import Algorithms.Sorting.SortingProblems.MergeOverlappingIntervals;
import Algorithms.Sorting.SortingProblems.SortArrayNegativeAndPositive;
import DataStructures.HashTable.Classes.HashNode;
import DataStructures.HashTable.Classes.HashTableChaining;
import DataStructures.HashTable.Classes.HashTableLinProb;
import Utils.ArrayUtils;
import Utils.IntArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
    private static ArrayUtils<Integer> utils = new ArrayUtils<>();
    private static IntArrayUtils intUtil = new IntArrayUtils();
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
        
        //Integer[] arr = {4,5,7,1,4,4,5,1,1,5,6,7};
        //System.out.println(KthSmallestElement.solution(arr,3));
        //SelectionSort.run(arr);
        //System.out.println(QuickSort.partitionWithCustomPivot(arr,0,arr.length-1,4));
        //utils.printArr(arr);

       
        /*MergeSort.iterative(arr);
        utils.printArr(arr);*/
        
        //Integer[] zeroToN = {335,51235,1,0,5,14,1531,12,71,5};
        //CountingSort.countSortGeneral(zeroToN);
        //BinBucketSort.binBucketSort(zeroToN);
        //ShellSort.shellSort(zeroToN);
        //RadixSort.radixSortWithCS(zeroToN);
        //utils.printArr(zeroToN);
        
        /*Integer[] negPos = {3,5,-13,15,-1,-17,35};
        SortArrayNegativeAndPositive.efficientSolution(negPos);
        util.printArr(negPos);*/
        
        /*int[] arr = {0,3,5,2,1,0,11,1,13};
        DutchNationalFlag.solution(arr);
        intUtil.printArr(arr);*/
        
        /*int[][] intervals = {{7,9},{6,10},{4,5},{1,3},{2,4}};
        ArrayList<int[]> result = MergeOverlappingIntervals.solution(intervals);
        for(int[] arr : result) {
            System.out.println("left = " + arr[0] + ", right = " + arr[1]);
        }*/
        
        /*int[] arr = {50,40,30,20,10};
        CycleSort.cycleSort(arr);
        intUtil.printArr(arr);*/
        
        /*int[] arr = {20,80,10,85,75,100,18};
        BucketSort.bucketSort(arr, 5);
        intUtil.printArr(arr);*/
        
        /*HashTableChaining<Integer,String> table = new HashTableChaining<>(20);
        table.insert(15,"onbes");
        table.insert(13,"onuc");
        table.insert(35,"otuzbes");
        
        System.out.println(table.containsKey(15));
        System.out.println(table.delete(15));
        System.out.println(table.containsKey(15));
        System.out.println(table.getItem(35));*/
        
        /*HashTableLinProb<Integer,String> table = new HashTableLinProb<>(6,0.5);
        table.insert(15,"onbes");
        table.insert(13,"onuc");
        table.insert(35,"otuzbes");
        table.insert(55,"ellibes");
        table.insert(91,"doksanbir");
        
        System.out.println(table.containsKey(35));
        System.out.println(table.insert(35,"otuzbes"));
        System.out.println(table.delete(35));
        System.out.println(table.insert(35,"otuzbes"));
        System.out.println(table.containsKey(35));
        System.out.println(table.getItem(35));
        
        System.out.println(table.resizeHashTable(15));
        
        for (HashNode<Integer,String> node : table) {
            System.out.println("Key = " + node.key + ", Value = " + node.value);
        }
        */
        
        int[] arr = {8, 3, 7};
        System.out.println(LongestSubArrayWithGivenSum.solution(arr, 7));
    }
    
}
