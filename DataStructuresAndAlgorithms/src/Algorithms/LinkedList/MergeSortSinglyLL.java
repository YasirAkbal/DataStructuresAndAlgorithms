/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/sort-list/
 */
public class MergeSortSinglyLL {
    SinglyNode merge(SinglyNode head1, SinglyNode head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        SinglyNode newNode;
        SinglyNode tail;
        if(head1.data < head2.data) {
            newNode = head1;
            head1 = head1.next;
        } else {
            newNode = head2;
            head2 = head2.next;
        }
        tail = newNode;
        
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null)
            tail.next = head1;
        else if(head2 != null)
            tail.next = head2;
        
        return newNode;
    }
    
    public SinglyNode sortList(SinglyNode head) {
        if(head == null || head.next == null) return head;
        
        SinglyNode slow = head;
        SinglyNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        SinglyNode next = slow.next;
        slow.next = null;
        
        SinglyNode left = sortList(head);
        SinglyNode right = sortList(next);
        
        return merge(left, right);
    }
}
