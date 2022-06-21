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
    static SinglyNode iterative(SinglyNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        SinglyNode prev = head;
        SinglyNode curr = head.next;
        prev.next = null;
        
        while(curr != null) {
            SinglyNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    static SinglyNode recursive1(SinglyNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        SinglyNode restHead = recursive1(head.next);
        SinglyNode restTail = head.next;
        restTail.next = head;
        head.next = null;
        return restHead;
    }
    
    static SinglyNode recursive2(SinglyNode head) {
        return _recursive2(head, null);
    }
    
    private static SinglyNode _recursive2(SinglyNode curr, SinglyNode prev) {
        if(curr == null) return prev;
        
        SinglyNode currNext = curr.next;
        curr.next = prev;
        return _recursive2(currNext,curr);
    }
}
