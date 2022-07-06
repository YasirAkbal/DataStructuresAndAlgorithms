/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

/**
 *
 * @author yasir
 * Tek arrayde 2 stack olması cache friendly olması açısından önemli
 * https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/0
 */
public class ImplementTwoStacks {  
    class TwoStack
    {
        int size;
        int top1,top2;
        int arr[] = new int[100];

        TwoStack()
        {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }
    
    boolean isFull(TwoStack sq) {
        return sq.top2-sq.top1 == 1;
    }
    
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq)
    {
        //if(isFull(sq)) return;
        sq.arr[++sq.top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        //if(isFull(sq)) return;
        sq.arr[--sq.top2] = x;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        int deleted = -1;
        
        if(sq.top1 > -1) {
            deleted = sq.arr[sq.top1];
            sq.top1--;
        }
        
        return deleted;
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        int deleted = -1;
        
        if(sq.top2 < sq.size) {
            deleted = sq.arr[sq.top2];
            sq.top2++;
        }
        
        return deleted;
    }
}
