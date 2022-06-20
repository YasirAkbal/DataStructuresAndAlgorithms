/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class ReverseALinkedList {
    SingleNode iterative(SingleNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        SingleNode prev = head;
        SingleNode curr = head.next;
        prev.next = null;
        
        while(curr != null) {
            SingleNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    SingleNode recursive(SingleNode curr, SingleNode prev) {
        if(curr == null) { return null; }
        
        if(curr.next == null) {
            curr.next = prev;
            prev.next = null;
            return curr;
        } else {
            return recursive(curr.next,curr);
        }
    }
}
