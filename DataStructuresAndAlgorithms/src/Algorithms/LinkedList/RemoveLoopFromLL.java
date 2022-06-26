/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class RemoveLoopFromLL {
    public static void removeLoop(SinglyNode head){
        SinglyNode slow = head;
        SinglyNode fast = head;
        SinglyNode prevSlow = head;
        
        while(fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        if(slow != fast)
            return;
            
        if(slow == head)
        {
            prevSlow.next = null;
            return;
        }
            
        slow = head;
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = null;
    }
}
