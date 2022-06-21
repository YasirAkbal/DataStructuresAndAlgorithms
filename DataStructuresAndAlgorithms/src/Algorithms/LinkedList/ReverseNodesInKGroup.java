/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class ReverseNodesInKGroup {
    public SinglyNode mySolution(SinglyNode head, int k) {
        if(head == null || head.next == null) return head;
        
        SinglyNode left = head;
        SinglyNode right = head;
        int count = 1;
        SinglyNode newHead = null;
        SinglyNode lastTail = null;
        
        while(right != null && right.next != null) {
            while(right.next != null && count < k) {
                right = right.next;
                count++;
            }

            if(count == k) {
                SinglyNode next = right.next;
                right.next = null;
                SinglyNode temp = ReverseALinkedList.recursive2(left);
                
                if(newHead==null) 
                    newHead = right;
     
                if(lastTail != null) 
                    lastTail.next = temp;
                
                lastTail = left;
                left = right = next;
            } else if(lastTail != null){
                lastTail.next = left;
            }
            
            count = 1;
        }
        
        if(lastTail != null) {
            lastTail.next = left;
        }
        
        return newHead;
    } 
}
