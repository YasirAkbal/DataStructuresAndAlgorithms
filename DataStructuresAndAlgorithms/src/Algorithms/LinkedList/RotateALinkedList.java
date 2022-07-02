/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class RotateALinkedList {
    //https://leetcode.com/problems/rotate-list/
    public SinglyNode rotateRight(SinglyNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;
        
        SinglyNode rightKth = head;
        SinglyNode tail = head;
        
        int i;
        for(i=1;i<=k && tail.next != null;i++) {
            tail = tail.next;
        }
        
        if(k%i == 0) {
            return head;
        } else if(i < k) {
            int mod = k%i;
            tail = head;
            for(i=1;i<=mod && tail.next != null;i++) 
                tail = tail.next;
        }
        
        while(tail.next != null) {
            tail = tail.next;
            rightKth = rightKth.next;
        }
        
        SinglyNode newHead = rightKth.next;
        rightKth.next = null;
        tail.next = head;
        
        return newHead;
    } 
    
    
    //https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/0
    public SinglyNode leftRotate(SinglyNode head, int k) {
        SinglyNode kthNode = head;
        
        for(int i=0;i<k-1;i++) {
            kthNode = kthNode.next;
        }
        
        SinglyNode tail = kthNode;
        while(tail.next != null)
            tail = tail.next;
        
        tail.next = head;
        SinglyNode newHead = kthNode.next;
        kthNode.next = null;
        
        return newHead;
    }
}
