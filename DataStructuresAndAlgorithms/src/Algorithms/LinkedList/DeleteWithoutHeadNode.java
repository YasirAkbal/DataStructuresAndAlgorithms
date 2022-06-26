/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 */
public class DeleteWithoutHeadNode {
    
    /*
    Tail haric herhangi bir yerde bulunan bir node'un constant zamanda linked listten silinmesi
    */
    static void deleteNode(SinglyNode del)
    {
        SinglyNode next = del.next;

        del.data = next.data;
        del.next = del.next.next;
    }
}
