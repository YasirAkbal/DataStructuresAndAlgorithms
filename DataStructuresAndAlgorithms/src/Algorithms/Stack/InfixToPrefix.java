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
 * Infix to postfixe çok benziyor. Ondan farklı olarak verilen ifade sağdan sola doğru taranıyor ve tarama bitince hesaplanan ifade reverse ediliyor. 
 * Ayrıca parantez kontrolü ve precedences eşitlik kontrolü kısmında farklılıklar var. 
 */
public class InfixToPrefix {
    static final HashMap<Character, Integer> precedences = new HashMap<>();
    static final HashMap<Character, Boolean> isLeftToRight = new HashMap<>();
    
    static {  
        precedences.put('^', 3);
        isLeftToRight.put('^',false);
        
        precedences.put('*', 2);
        isLeftToRight.put('*',true);
        precedences.put('/', 2);
        isLeftToRight.put('/',true);
        
        precedences.put('+', 1);
        isLeftToRight.put('+',true);
        precedences.put('-', 1);
        isLeftToRight.put('-',true);
        
        precedences.put(')', 0);
        isLeftToRight.put(')',true);
    }
    
    
    public static String infixToPrefix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder(exp.length());
        
        char c;
        for(int i=exp.length()-1;i>=0;i--) {
            c = exp.charAt(i);
            if(Character.isLetter(c)) {
                res.append(c);
            } else {
                if(c == ')') {
                    stack.push(c);
                } else if(c == '(') {
                    while(stack.peek() != ')') {
                        res.append(stack.pop());
                    }
                    stack.pop();
                } else if(stack.isEmpty()) {
                    stack.push(c);
                } else if(precedences.get(c) > precedences.get(stack.peek())) {
                    stack.push(c);
                } else if(precedences.get(c) < precedences.get(stack.peek())) {
                    while(!stack.isEmpty() && precedences.get(c) < precedences.get(stack.peek())) {
                        res.append(stack.pop());
                    }
                    stack.push(c);
                } else { //eşitlik varsa associativity'lere bakılır.
                    if(!isLeftToRight.get(c)) {
                        res.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.reverse().toString();
    }
}
