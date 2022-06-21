/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class RemoveDuplicatesFromSortedLL {
    SinglyNode removeDuplicates(SinglyNode head) {
        if(head == null || head.next == null) return head;
        
	SinglyNode left = head;
	SinglyNode right = head.next;
	    
	while(right != null) {
	    while(right != null && left.data == right.data) {
	        left.next = right.next;
	        right = right.next;
	    }
	    left = right;
	    if(right != null)
	        right = right.next;
	}
	    
	return head;
    } 
    
    //Aslında bu kadar basitmiş
    SinglyNode removeDuplicatesSimple(SinglyNode head) {
        SinglyNode curr = head;
        
        while(curr != null && curr.next != null) {
            if(curr.data == curr.next.data)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        
        return head;
    }
}
