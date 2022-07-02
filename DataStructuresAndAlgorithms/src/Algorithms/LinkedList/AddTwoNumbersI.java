/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbersI {
    public SinglyNode addTwoNumbers(SinglyNode l1, SinglyNode l2) {
        int sum = l1.data + l2.data;
        int add = sum/10;
        
        SinglyNode newHead = new SinglyNode(sum%10);
        SinglyNode tail = newHead;
        
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            sum = l1.data + l2.data + add;
            add = sum/10;
            
            tail.next = new SinglyNode(sum%10);
            tail = tail.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        SinglyNode remaining = null;
        if(l1 != null)
            remaining = l1;
        else if(l2 != null)
            remaining = l2;
        
        while(remaining != null) {
            sum = remaining.data + add;
            add = sum/10;
            
            tail.next = new SinglyNode(sum%10);
            tail = tail.next;
            
            remaining = remaining.next;
        }
        
        if(add != 0) {
            tail.next = new SinglyNode(add);
            tail = tail.next;
        }
        
        return newHead;
    }
}
