/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author yasir
 * Given an array of distinct integers, find all the pairs having both negative and positive values of a number in the array.
 */
public class PositiveNegativePair {
    public static ArrayList<Integer>findPairs(int arr[], int n) { 
    	ArrayList<Integer> result = new ArrayList<>();
    	HashSet<Integer> set = new HashSet<>();
    	
    	for(int x: arr) {
    	    if(set.contains(x*-1)) {
    	        int add = x < 0 ? x : x*-1;
    	        result.add(add);
    	        result.add(add*-1);
    	    }
    	    set.add(x);
    	}
    	
    	return result;
    } 
}
