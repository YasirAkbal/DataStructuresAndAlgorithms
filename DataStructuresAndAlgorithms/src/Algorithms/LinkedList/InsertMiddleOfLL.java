/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class InsertMiddleOfLL {
    /*
    1 kere traversal yaparak bu işlemi gerçekleştirebiliriz.
    */
    public SingleNode insertInMid(SingleNode head, int data){
        if(head == null) return new SingleNode(data);
        
        SingleNode fast = head;
        SingleNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        SingleNode newNode = new SingleNode(data);
        newNode.next = slow.next;
        slow.next = newNode;
        
        return head;
    }
}
