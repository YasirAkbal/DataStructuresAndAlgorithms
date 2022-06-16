/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.HashMap;

/**
 *
 * @author yasir
 */
public class KeypadTyping {
    private static HashMap<Character, Integer> map;
    static {
        map = new HashMap<>();
        String[] allLetters = { "abc", "def" ,"ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int key = 2;
        for(String letters: allLetters) {
            for(char c: letters.toCharArray()) {
                map.put(c,key);
            }
            key++;
        }
    }
    
    //Function to find matching decimal representation of a string as on the keypad.
    public static String printNumber(String s, int n) 
    {
        StringBuilder sbf = new StringBuilder(n);
        
        for(Character c: s.toCharArray()) {
            sbf.append(map.get(c));
        }
        
        return sbf.toString();
    }
}
