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
import Algorithms.HashTable.LongestCommonSubarrayWithGivenSum;
import Algorithms.HashTable.LongestSubArrayWithGivenSum;
import Algorithms.Searching.*;
import Algorithms.Sorting.SortingAlgorithms.*;
import Algorithms.Sorting.SortingProblems.DutchNationalFlag;
import Algorithms.Sorting.SortingProblems.KthSmallestElement;
import Algorithms.Sorting.SortingProblems.MergeOverlappingIntervals;
import Algorithms.Sorting.SortingProblems.SortArrayNegativeAndPositive;
import Algorithms.Strings.Anagram;
import Algorithms.Strings.AnagramSearch;
import Algorithms.Strings.CheckStringSubSeqAnother;
import Algorithms.Strings.LeftMostNonRepeatingElement;
import Algorithms.Strings.LeftMostRepatingCharacter;
import Algorithms.Strings.PatternSearch;
import Algorithms.Strings.ReverseWordsInString;
import DataStructures.DynamicArray.DynamicArray;
import DataStructures.HashTable.Classes.HashNode;
import DataStructures.HashTable.Classes.HashTableChaining;
import DataStructures.HashTable.Classes.HashTableLinProb;
import DataStructures.LinkedLists.Abstract.ILinkedList;
import DataStructures.LinkedLists.DoublyCircularLinkedList;
import DataStructures.LinkedLists.SinglyLinkedList;
import Utils.ArrayUtils;
import Utils.IntArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

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
        
        /*int[] arr = {8, 3, 7};
        System.out.println(LongestSubArrayWithGivenSum.solution(arr, 7));*/
        
        /*int[] arr1 = {0,0,0};
        int[] arr2 = {1,1,1};
        
        System.out.println(LongestCommonSubarrayWithGivenSum.solution(arr1, arr2));
        System.out.println(LongestCommonSubarrayWithGivenSum.efficientSolution(arr1, arr2));*/
        
        //System.out.println(CheckStringSubSeqAnother.solution("ABCDEF", "ABCDEF"));
        /*System.out.println(Anagram.solution1("selam", "elmas"));
        System.out.println(Anagram.solution2("selam", "elmas"));
        System.out.println(Anagram.solution3("selam", "elmas"));*/
        
        //System.out.println(LeftMostRepatingCharacter.solution3("hbcdac"));
        
        /*System.out.println(LeftMostNonRepeatingElement.solution1("aabcd"));
        System.out.println(LeftMostNonRepeatingElement.solution2("aabcd"));*/
   
        /*String s = "selam ben yasir";
        char[] sArr = s.toCharArray();
        System.out.println(ReverseWordsInString.solution(s));
        
        ReverseWordsInString.efficientSolution(sArr);
        System.out.println(new String(sArr));*/
        
        /*ArrayList<Integer> indexes = PatternSearch.rabinKarpAlgorithm("selam el aa", "el");
        for(int i: indexes) {
            System.out.print(i + " ");
        }*/
        
        /*ArrayList<Integer> indexes = PatternSearch.constructLPSArray("abbabb");
        for(int i: indexes) {
            System.out.print(i + " ");
        }*/
        
        //System.out.println(AnagramSearch.naiveSolution("geeksforgeeks", "frof"));
        
        /*SingleLinkedList<Integer> mySLL = new SingleLinkedList<>();
        DoublyCircularLinkedList<Integer> myDCLL = new DoublyCircularLinkedList<>();
        LLTestCases(mySLL);
        System.out.println("<---------------------->");
        LLTestCases(myDCLL);*/
        
        DynamicArray<Integer> dynArr = new DynamicArray<>(Integer.class,1);
        dynArr.append(2);
        dynArr.append(23);
        dynArr.append(52);
        dynArr.append(153);
        dynArr.remove(2);
        dynArr.insert(2, 52);
        
        for(Integer i: dynArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(dynArr.size());
        System.out.println(dynArr.get(1));
    }
    
    private static void LLTestCases(ILinkedList<Integer> llist) {
        llist.addLast(3);
        llist.addLast(35);
        llist.insert(2, -13);
        llist.addLast(11);
        llist.addFirst(31);
        
        llist.printAll();
        System.out.println(llist.contains(3));
        System.out.println(llist.get(6));
        System.out.println(llist.isEmpty());
        System.out.println(llist.getFirst());
        System.out.println(llist.getLast());
        System.out.println(llist.search(-13));
        System.out.println(llist.removeFirst());
        llist.printAll();
        System.out.println(llist.removeLast());
        llist.printAll();
        System.out.println(llist.remove(2));
        System.out.println(llist.removeLast());
        System.out.println(llist.removeFirst());
        llist.printAll();
    }
}
