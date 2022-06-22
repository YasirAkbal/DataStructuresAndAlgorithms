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
    
    public static SinglyNode recursive(SinglyNode head, int k) {
        SinglyNode curr = head;
        SinglyNode prev = null;
        int count = 1;
        
        while(curr != null && count <= k) {
            SinglyNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
            count++;
        }
        
        if(curr != null)
            head.next = recursive(curr, k);
        
        return prev;
    }
    
    public static SinglyNode iterative(SinglyNode head, int k) {
        SinglyNode curr = head;
        SinglyNode prev;
        int count;
        SinglyNode newHead = null;
        SinglyNode prevTail = null;
        
        while(curr != null) {
            count = 0;
            prev = null;
            SinglyNode first = curr;
            while(curr != null && count < k) {
                SinglyNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                count++;
            }
            
            if(newHead == null)
                newHead = prev;
            else {
                prevTail.next = prev;
            }
            prevTail = first;
        }
        
        return newHead;
    }
}
