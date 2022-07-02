/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {
    public SinglyNode reverse(SinglyNode node) {
        SinglyNode prev = null;
        
        while(node != null) {
            SinglyNode temp = node.next;
            
            node.next = prev;
            prev = node;
            node = temp;
        }
        
        return prev;
    }
    
    public SinglyNode addTwoNumbers(SinglyNode first, SinglyNode second) {
        first = reverse(first);
        second = reverse(second);
        
        int sum = first.data + second.data;
        int add = sum/10;
        SinglyNode newHead = new SinglyNode(sum%10);
        SinglyNode tail = newHead;
        
        first = first.next;
        second = second.next;
        while(first != null && second != null) {
            sum = first.data + second.data + add;
            add = sum/10;
            
            tail.next = new SinglyNode(sum%10);
            tail = tail.next;
            first = first.next;
            second = second.next;
        }
        
        SinglyNode remaining = null;
        if(first != null)
            remaining = first;
        else if(second != null)
            remaining = second;
        
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
        
        newHead = reverse(newHead);
        return newHead;
    }
}
