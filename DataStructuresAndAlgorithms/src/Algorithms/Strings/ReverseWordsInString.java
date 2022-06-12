/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.Stack;

/**
 *
 * @author yasir
 */
public class ReverseWordsInString {     
    public static String solution(String s) {
        Stack<String> words = new Stack<>();
        String result = "";
        
        for(String word: s.split(" ")) {
            words.add(word);
        }
        
        while(!words.isEmpty()) {
            if(words.size() == 1) {
                result += words.pop();
            } else {
                result += words.pop() + " ";
            }
        }
        
        return result;
    }
    
    private static void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /*
    Onceki kelimeleri ayrı ayrı reverse et. Sonrasında düm diziyi reverse et.
    */
    public static void efficientSolution(char[] s) {
        int start = 0;
        
        for(int i=0;i<s.length;i++) {
            if(s[i] == ' ') {
                reverse(s, start, i-1);
                start = i+1;
            }
        }
        reverse(s,start,s.length-1);
        
        reverse(s, 0, s.length-1);
    }
}
