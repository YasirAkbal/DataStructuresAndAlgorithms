/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1#
 */
public class EvenOddDatasLinkedList {
    SinglyNode divide(int N, SinglyNode head){
        if(N <= 1) return head;
        
        SinglyNode evensHead = null;
        SinglyNode evensTail = null;
        
        SinglyNode oddsHead = null;
        SinglyNode oddsTail = null;
        
        while(head != null) {
            if(head.data%2 == 0) {
                if(evensHead == null) {
                    evensHead = head;
                    evensTail = head;
                } else {
                    evensTail.next = head;
                    evensTail = evensTail.next;
                }
                
            } else {
                if(oddsHead == null) {
                    oddsHead = head;
                    oddsTail = head;
                } else {
                    oddsTail.next = head;
                    oddsTail = oddsTail.next;
                }
            }
               
            head = head.next;
        }
        
        if(oddsTail != null)
            oddsTail.next = null;
        
        if(evensTail != null)
            evensTail.next = oddsHead;
        
        return evensHead != null ? evensHead : oddsHead;
    }
}
