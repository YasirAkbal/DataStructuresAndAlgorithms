/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class NthNodeFromEndOfLL {
    //listeyi 2 kere traverse ediyor
    int naiveSolution(SingleNode head, int n) {
    	int size = 0;
    	SingleNode itr = head;
    	
    	while(itr != null) {
    	    size++;
    	    itr = itr.next;
    	}
    	
    	if(n > size)
    	    return -1;
    	
    	itr = head;
    	for(int i=0;i<size-n;i++) {
    	    itr = itr.next;
    	}
    	
    	return itr.data;
    }
    
    //listeyi 1 kere traverse ediyor
    int efficientSolution(SingleNode head, int n) {
        if(head == null) return -1;
        
        SingleNode left = head;
        SingleNode right = head;
        
        for(int i=0;i<n-1;i++) {
            right = right.next;
            if(right == null)
                return -1;
        }
        
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        
        return left.data;
    }
}
