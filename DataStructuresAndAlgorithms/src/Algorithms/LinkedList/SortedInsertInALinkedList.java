/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * head'ı verilen sıralı(küçükten büyüğe) linked list'e sıralanmış olma durumunu bozmadan eleman ekleme
 */
public class SortedInsertInALinkedList {
    SinglyNode solution(SinglyNode head, int data) {
        if(head == null) return null; //ll boşsa
        
        SinglyNode newNode = new SinglyNode(data);
        if(data < head.data) { //eklenecek eleman headdeki elemandan küçükse corner case oluşur.
            newNode.next = head;
            return newNode;
        } else {
            SinglyNode curr = head;
            
            while(curr.next != null && curr.next.data < data) {
                curr = curr.next;
            }
            
            newNode.next = curr.next;
            curr.next = newNode;
            return head;
        }
    }
}
