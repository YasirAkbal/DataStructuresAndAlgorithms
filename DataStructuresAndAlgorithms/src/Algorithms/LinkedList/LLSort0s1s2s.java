/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/0
 */
public class LLSort0s1s2s {
    static SinglyNode merge(SinglyNode[] heads, SinglyNode[] tails) {
        SinglyNode head = null;
        SinglyNode tail = null;
        
        for(int i=0;i<heads.length;i++) {
            if(heads[i] != null) {
                if(head == null) {
                    head = heads[i];
                    tail = tails[i];
                } else {
                    tail.next = heads[i];
                    tail = tails[i];
                }
            }
        }
        
        tail.next = null;
        
        return head;
    }
    
    //Function to sort a linked list of 0s, 1s and 2s.
    static SinglyNode segregate(SinglyNode head) {
        SinglyNode zerosHead = null;
        SinglyNode zerosTail = null;
        
        SinglyNode onesHead = null;
        SinglyNode onesTail = null;
        
        SinglyNode twosHead = null;
        SinglyNode twosTail = null;
        
        while(head != null) {
           if(head.data == 0) {
               if(zerosTail == null) {
                   zerosHead = head;
                   zerosTail = head;
               } else {
                   zerosTail.next = head;
                   zerosTail = zerosTail.next;
               }
           } else if(head.data == 1) {
               if(onesHead == null)  {
                   onesHead = head;
                   onesTail = head;
               } else {
                   onesTail.next = head;
                   onesTail = onesTail.next;
               }
           } else {
               if(twosHead == null) {
                   twosHead = head;
                   twosTail = head;
               } else {
                   twosTail.next = head;
                   twosTail = twosTail.next;
               }
           }
           
           head = head.next;
        }
        
        
        SinglyNode[] heads = { zerosHead, onesHead, twosHead };
        SinglyNode[] tails = { zerosTail, onesTail, twosTail };
        return merge(heads, tails);
    }
}
