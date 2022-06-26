/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

import java.util.Stack;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/0/
 */
public class IntersectionPointInYShappedLinkedLists {

    /*
    Time Complexity -> BigTheta(m+n)
    Auxiliary Space -> BigTheta(m+n) (HashSet kullanılarak BigTheta(m) ile de yapılabilir)
     */
    int withStack(SinglyNode head1, SinglyNode head2) {
        if (head1 == null || head2 == null) {
            return -1;
        }

        Stack<SinglyNode> stack1 = new Stack<>();
        Stack<SinglyNode> stack2 = new Stack<>();

        while (head1 != null) {
            stack1.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            stack2.add(head2);
            head2 = head2.next;
        }

        SinglyNode prev = stack1.peek();
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.pop() != stack2.peek()) {
                return prev.data;
            }
            prev = stack2.pop();
        }

        return -1;
    }

    /*
    Time Complexity -> BigTheta(m+n)
    Auxiliary Space -> BigTheta(1)
     */
    int intersectPoint(SinglyNode head1, SinglyNode head2) {
        SinglyNode itr = head1;
        int size1 = 0;
        int size2 = 0;

        while (itr != null) {
            size1++;
            itr = itr.next;
        }

        itr = head2;
        while (itr != null) {
            size2++;
            itr = itr.next;
        }

        SinglyNode longList;
        SinglyNode shortList;
        if (size1 > size2) {
            longList = head1;
            shortList = head2;
        } else {
            longList = head2;
            shortList = head1;
        }

        int count = Math.abs(size1 - size2);
        for (int i = 0; i < count; i++) {
            longList = longList.next;
        }

        while (longList != null && shortList != null) {
            if (longList == shortList) {
                return longList.data;
            }

            shortList = shortList.next;
            longList = longList.next;
        }

        return -1;
    }
}
