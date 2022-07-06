/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/0
 */
public class InfixToPostfix {
    static final HashMap<Character, Integer> precedences = new HashMap<>();
    static final HashMap<Character, Boolean> isLeftToRight = new HashMap<>(); //associativity durumu soz konusu olmadıgı icin bunu bu soruda kullanmadım
    
    static {
        precedences.put('^', 2);
        isLeftToRight.put('^', false);
        
        precedences.put('*', 1);
        isLeftToRight.put('*', true);

        precedences.put('/', 1);
        isLeftToRight.put('/', true);
        
        precedences.put('+', 0);
        isLeftToRight.put('+', true);

        precedences.put('-', 0);
        isLeftToRight.put('-', true);
        
        precedences.put('(', -1);
        isLeftToRight.put('(', true);
    }
    
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder(exp.length());
        
        for(Character c: exp.toCharArray()) {
            if(Character.isLetter(c)) {
                res.append(c);
            } else {
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    while(stack.peek() != '(') {
                        res.append(stack.pop());
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    stack.push(c);
                } else if(precedences.get(c) > precedences.get(stack.peek())) {
                    stack.push(c);
                } else if(precedences.get(c) <= precedences.get(stack.peek())) {
                    while(!stack.isEmpty() && precedences.get(c) <= precedences.get(stack.peek())) {
                        res.append(stack.pop());
                    }
                    stack.push(c);
                } 
            }
        }
        
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.toString();
    }
}
