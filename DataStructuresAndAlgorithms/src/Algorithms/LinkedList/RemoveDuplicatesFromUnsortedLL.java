/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

import java.util.HashSet;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/0
 */
public class RemoveDuplicatesFromUnsortedLL {
    public SinglyNode removeDuplicates(SinglyNode head)  {
        if(head == null || head.next == null) return head;
        
        HashSet<Integer> set = new HashSet<>();
        SinglyNode newHead = head;
        SinglyNode tail = head;
        set.add(tail.data);
        
        head = head.next;
        while(head != null) {
            if(!set.contains(head.data)) {
                set.add(head.data);
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        
        tail.next = null;
        
        return newHead;
    }
}
