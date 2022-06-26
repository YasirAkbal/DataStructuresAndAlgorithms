/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class Pairwise_Swap {
    //dataları swaplayarak
    public static SinglyNode dataSwap(SinglyNode node) {
        if(node == null || node.next == null) return node;
        
        SinglyNode curr = node;
        
        while(curr != null && curr.next != null) {
            
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            
            curr = curr.next.next;
        }
        
        return node;
    } 
    
    //referansları değiştirerek
    public static SinglyNode referenceSwap(SinglyNode node)
    {
        if(node == null || node.next == null) return node;
        
        SinglyNode prev = node;
        SinglyNode curr = node.next.next;
        
        node = node.next;
        node.next = prev;
        
        while(curr != null && curr.next != null) {
            SinglyNode next = curr.next.next;
            
            curr.next.next = curr;
            prev.next = curr.next;
            curr.next = next;
            
            prev = curr;
            curr = next;
        }
        
        prev.next = curr;
        return node;
    }
}
