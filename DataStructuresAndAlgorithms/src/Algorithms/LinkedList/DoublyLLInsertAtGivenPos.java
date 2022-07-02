/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/0
 */
public class DoublyLLInsertAtGivenPos {
    void addNode(DoublyNode head_ref, int pos, int data) {
        DoublyNode itr = head_ref;

        for (int i = 0; i < pos; i++) {
            itr = itr.next;
        }

        DoublyNode newNode = new DoublyNode(data);
        if (itr.next == null) {
            itr.next = newNode;
            newNode.prev = itr;
        } else {
            newNode.prev = itr;
            newNode.next = itr.next;

            itr.next.prev = newNode;
            itr.next = newNode;
        }
    }
}
