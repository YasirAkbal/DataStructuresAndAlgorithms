/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLinkedList {
    public SinglyNode mergeTwoLists(SinglyNode list1, SinglyNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        SinglyNode head = null;
        SinglyNode tail = null;
        
        if(list1.data < list2.data) {
            head = list1;
            tail = list1;
            list1 = list1.next;
        } else {
            head = list2;
            tail = list2;
            list2 = list2.next;
        }
        
        
        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        
        if(list1 != null) {
            tail.next = list1;
        }
        
        if(list2 != null) {
            tail.next = list2;
        }
        
        return head;
    }
}
