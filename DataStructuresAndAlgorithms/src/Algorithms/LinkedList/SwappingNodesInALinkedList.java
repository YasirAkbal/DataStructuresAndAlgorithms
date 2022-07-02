/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class SwappingNodesInALinkedList {
    void swap(SinglyNode firstPrev, SinglyNode secondPrev) {
        SinglyNode first = firstPrev.next;
        SinglyNode second = secondPrev.next;
        
        firstPrev.next = second;
        SinglyNode temp = second.next;
        if(first.next != second)
            second.next = first.next;
        else
            second.next = first;
        
        secondPrev.next = first;
        first.next = temp;
    }
    
    public SinglyNode swapNodes(SinglyNode head, int k) {
        if(head.next == null) return head;
        else if(head.next.next == null) { //sadece 2 eleman var
            head.next.next = head;
            SinglyNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        
        SinglyNode itr = head;
        int i;
        for(i=1;itr!=null && i < k-1;itr=itr.next, i++){}
        if(itr == null || itr.next == null)
            return head;
        
        //K == N
        if(itr.next.next == null) {
            SinglyNode prev = itr;
            itr = itr.next;
            SinglyNode temp = head.next;
            
            prev.next = head;
            head.next = itr.next;
            itr.next = temp;
            head = itr;
        } else if(k == 1) { //K == 1
            SinglyNode tailPrev = head;
            while(tailPrev.next.next != null) {
                tailPrev = tailPrev.next;
            }
            
            SinglyNode tail = tailPrev.next;
            
            tail.next = head.next;
            tailPrev.next = head;
            head.next = null;
            head = tail;
        } else { //K > 1 && K < N
            SinglyNode firstKPrev = itr;
            
            SinglyNode lastKPrev = null;
            SinglyNode lastK = head;
            
            itr = itr.next.next;
            while(itr != null) {
                itr = itr.next;
                lastKPrev = lastK;
                lastK = lastK.next;
            }
 
            swap(firstKPrev, lastKPrev);
        }
        
        return head;
    }
}
