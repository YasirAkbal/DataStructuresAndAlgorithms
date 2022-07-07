/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

import java.util.ArrayDeque;

/**
 *
 * @author yasir
 * Elemanları boşlukla ayrılmış prefix notasyonundaki işlemin sonucunu bulan program
 */
public class EvaluationOfPrefix {
    public static int calculate(String exp) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] tokens = exp.split(" ", exp.length());
        
        int sum;
        for(int i=tokens.length-1;i>=0;i--) {
            String token = tokens[i];
            if(Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(token) {
                    case "+" -> sum = num1+num2;
                    case "-" -> sum = num1-num2;
                    case "*" -> sum = num1*num2;
                    case "/" -> sum = num1+num2;
                    case "^" -> sum = (int)Math.pow(num1,num2);
                    default -> {
                            System.out.println("invalid operator");
                            sum = 0;
                    }
                }
                stack.push(sum);
            }
        }
        
        return stack.peek();
    }
}
