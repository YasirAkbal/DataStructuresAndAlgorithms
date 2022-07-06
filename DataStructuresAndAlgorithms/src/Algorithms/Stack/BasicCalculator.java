/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author yasir
 * Bu çözüme güzel bir optimizasyon lazım.
 */
public class BasicCalculator {
    static final HashMap<Character, Integer> precedences = new HashMap<>();
    static {
        precedences.put('*', 1);

        precedences.put('+', 0);

        precedences.put('-', 0);
        
        precedences.put('(', -1);
    }
    
    String parseInt(String exp, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<exp.length();i++) {
            if(Character.isDigit(exp.charAt(i)))
            {
                sb.append(exp.charAt(i));
            }
            else
               break;
        }
        return sb.toString();
    }
    
    public ArrayList<String> toPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayList<String> res = new ArrayList<>();

        int i;
        for(i=0;i<exp.length();) {
             char c = exp.charAt(i);        
            
             if(Character.isDigit(c)) {
                String numS = parseInt(exp,i);
                i+=numS.length();
                res.add(numS);
            } else {
                if(c == '-' && (i == 0 || 
                                (i > 1 && exp.charAt(i-2) != '(' && precedences.containsKey(exp.charAt(i-2))) && !Character.isDigit(exp.charAt(i-1)))) {
                    res.add("-1");
                    stack.push('*');
                }
                else if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    while(stack.peek() != '(') {
                        res.add(Character.toString(stack.pop()));
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    stack.push(c);
                } else if(precedences.get(c) > precedences.get(stack.peek())) {
                    stack.push(c);
                } else if(precedences.get(c) <= precedences.get(stack.peek())) {
                    while(!stack.isEmpty() && precedences.get(c) <= precedences.get(stack.peek())) {
                        res.add(Character.toString(stack.pop()));
                    }
                    stack.push(c);
                } 
                i++;
            }
        }
        
        while(!stack.isEmpty()) {
            res.add(Character.toString(stack.pop()));
        }
        
        return res; 
    }
    
    
    public int doCalc(int x, int y, char op) {
        int result=0;
        
        switch(op) {
            case '+' -> result = x+y;
            case '-' -> result = x-y;
            case '*' -> result = x*y;
            default -> System.out.println("invalid operator");
        }
        
        return result;
    }
    
    public int calculate(String exp) {
        exp = exp.replaceAll("\\s+","");
        ArrayList<String> postfix = toPostfix(exp);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int sum;
        for(String s: postfix) {
            if(Character.isDigit(s.charAt(0)) || (s.length() > 1 && Character.isDigit(s.charAt(1)))) { 
                stack.push(Integer.parseInt(s));
            } else { //operator
                int num1 = stack.pop();
                int num2 = stack.pop();
                sum = doCalc(num2, num1, s.charAt(0));
                
                stack.push(sum);
            }
        }
        
        return stack.pop();
    }
}
