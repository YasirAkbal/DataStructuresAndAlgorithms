/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Bu problemin Priority Queue ve dinamik programalama ile de çözümü var. İleride bu şekilde de çözmeye çalışacağım.
 */
public class MergeKSortedLists {
    SinglyNode merge2List(SinglyNode head1, SinglyNode head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        SinglyNode newHead = null;
        SinglyNode tail;
        if(head1.data < head2.data) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }
        tail = newHead;
        
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null) {
            tail.next = head1;
        } else if(head2 != null) {
            tail.next = head2;
        }
        
        return newHead;
    }
 
    /*
    Time Complexity -> O(n*k)
    Auxiliary Space -> O(1)
    n -> en uzun listenin boyutu
    */
    public SinglyNode solution1(SinglyNode[] lists) {
        if(lists.length == 0) return null;
        else if(lists.length == 1) return lists[0];
        SinglyNode merged = lists[0];
        
        for(int i=1;i<lists.length;i++) {
            merged = merge2List(merged,lists[i]);
        }
        
        return merged;
    }
    
    /*
    Time Complexity -> O(n*(k^2))
    Auxiliary Space -> O(1)
    n -> en uzun listenin boyutu
    Bu çözüm baya kötü
    */
    public SinglyNode solution2(SinglyNode[] lists) {
        if(lists.length == 0) return null;
        else if(lists.length == 1) return lists[0];
        
        SinglyNode newHead;
        SinglyNode tail;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<lists.length;i++) {
            if(lists[i] != null && lists[i].data <= min) {
                min = lists[i].data;
                minIndex = i;
            }
        }
        
        if(minIndex == -1)
            return null;
        
        newHead = lists[minIndex];
        tail = newHead;
        lists[minIndex] = lists[minIndex].next;
        
        int count = 0;
        while(count != lists.length) {
            min = Integer.MAX_VALUE;
            minIndex = -1;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] != null && lists[i].data <= min) {
                    min = lists[i].data;
                    minIndex = i;
                }
            }
            
            if(minIndex == -1)
                break;
            
            tail.next = lists[minIndex];
            tail = tail.next;
            lists[minIndex] = lists[minIndex].next;
            
            if(lists[minIndex] == null)
                count++;
        }
        
        
        return newHead;
    }
}
