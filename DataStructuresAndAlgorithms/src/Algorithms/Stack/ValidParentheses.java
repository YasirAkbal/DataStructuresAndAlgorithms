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
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    static final HashMap<Character, Character> brackets = new HashMap<>();
    
    static {
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put('(',')');
    }
    
    public boolean isValid(String s) {
        char c;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(brackets.containsKey(c)) {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return false;
            } else if(brackets.getOrDefault(stack.peek(),null) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
