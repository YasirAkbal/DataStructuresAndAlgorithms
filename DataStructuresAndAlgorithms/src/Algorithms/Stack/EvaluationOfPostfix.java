/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Stack;

import java.util.ArrayDeque;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/0
 */
public class EvaluationOfPostfix {
    public static int evaluatePostFix(String S) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum;
        for(Character c: S.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(c) {
                    case '+' -> sum = num2+num1;
                    case '-' -> sum = num2-num1;
                    case '*' -> sum = num2*num1;
                    case '/' -> sum = num2/num1;
                    default -> {
                            sum = 0;
                            System.out.println("invalid operator");
                    }
                }
                stack.push(sum);
            }
        }
        
        return stack.pop();
    }
}
