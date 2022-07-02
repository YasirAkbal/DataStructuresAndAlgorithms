/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/find-length-of-loop/0
 */
public class FindLengthOfLoop {
    static int countNodesinLoop(SinglyNode head) {
        SinglyNode slow = head;
        SinglyNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow)
                break;
        }
        
        if(fast == null || fast.next == null)
            return 0;
        
        SinglyNode itr = slow;
        int count = 0;
        do {
            count++;
            itr = itr.next;
        } while(itr != slow);
        
        return count;
    }
}
