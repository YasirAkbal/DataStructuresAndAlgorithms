/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author yasir
 * https://leetcode.com/problems/online-stock-span/
 */
public class OnlineStockSpan {
    ArrayDeque<Integer> stack;
    ArrayList<Integer> priceArr;
    int i;
    
    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
        priceArr = new ArrayList<>();
        i = 0;
    }
    
    public int next(int price) {
        priceArr.add(price);
        if(i == 0) {
            stack.push(0);
            
            i++;
            return 1;
        } else {
            while(!stack.isEmpty() && priceArr.get(stack.peek()) <= price) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
            
            i++;
            return span;
        }
    }
}
