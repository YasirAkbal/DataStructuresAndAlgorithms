/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/0
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    class RandomNode {
        int data;
        RandomNode next, arb;

        RandomNode(int d) { 
            data = d;
            next = arb = null; 
        }   
    }
    
    RandomNode copyList(RandomNode head) {
        if(head == null) return null;

        RandomNode curr = head;
        RandomNode temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = new RandomNode(curr.data);

            curr.next.next = temp;
            curr = temp;
        }
        
        RandomNode result = head.next;
        curr = head;
        while(curr != null && curr.next != null) {
            RandomNode newNode = curr.next;
            temp = newNode.next;
                
            if(curr.arb != null)
                newNode.arb = curr.arb.next;
            
            curr = temp;
        }
        
        curr = head;
        while(curr != null && curr.next != null) {
            RandomNode newNode = curr.next;
            temp = newNode.next;
            
            if(newNode.next != null)
                newNode.next = newNode.next.next;
            curr.next = temp;
               
            curr = curr.next;
        }
        
        return result;
    }
}
