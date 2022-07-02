/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

import java.util.Stack;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    /*
    Time Complexity -> BigTheta(n)
    Space Complexity -> BigTheta(n)
    */
    boolean solution1(SinglyNode head) {
        Stack<Integer> stack = new Stack<>();
        SinglyNode itr = head;
        
        while(itr != null) {
            stack.push(itr.data);
            itr = itr.next;
        }
        
        itr = head;
        while(!stack.empty()) {
            if(stack.pop() != itr.data)
                return false;
            itr = itr.next;
        }
        
        return true;
    }
    
    
    /*
    Time Complexity -> BigTheta(n)
    Space Complexity -> BigTheta(1)
    Listenin bağlantılarını değiştiriyor. Fakat palindrome kontrolü sağlandıktan sonra listenin reverse edilen yarısı tekrar reverse edilerek liste orjinal haline getirilebilir.
    */
    boolean isPalindrome(SinglyNode head) {
        if(head == null || head.next == null) return true;
        
        SinglyNode slow = head;
        SinglyNode fast = head;
        
        SinglyNode prev = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            
            SinglyNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        SinglyNode right = fast == null ? slow : slow.next;
        SinglyNode left = prev;
        
        while(right != null && left != null) {
            if(right.data != left.data)
                return false;
            right = right.next;
            left = left.next;
        }
        
        return true;
    } 
}
