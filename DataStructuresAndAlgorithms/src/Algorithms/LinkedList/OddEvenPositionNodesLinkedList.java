/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenPositionNodesLinkedList {
    public static SinglyNode oddEvenList(SinglyNode head) {
        if(head == null || head.next == null) return head;
        
        SinglyNode oddsTail = head;
        SinglyNode oddsHead = oddsTail;
        
        SinglyNode evensTail = head.next;
        SinglyNode evensHead = evensTail;
        
        SinglyNode itr = head.next.next;
        boolean isOdd = true;
        while(itr != null) {
            if(isOdd) { //odd
                oddsTail.next = itr;
                oddsTail = oddsTail.next;
            } else { //even
                evensTail.next = itr;
                evensTail = evensTail.next;
            }
            
            isOdd = !isOdd;
            itr = itr.next;
        }
        
        if(evensTail != null)
            evensTail.next = null;   
        
        oddsTail.next = evensHead;
        
        return oddsHead;
    }
}
