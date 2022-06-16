/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.HashSet;

/**
 *
 * @author yasir
 * Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.
 */
public class PangramCheck {
    private static HashSet<Character> constructAlphabetSet() {
        HashSet<Character> set = new HashSet<>();
        
        for(char c: "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            set.add(c);
        }
        
        return set;
    }
    
    public static boolean checkPangram  (String str) {
        HashSet<Character> set = constructAlphabetSet();
        
        for(char c: str.toCharArray()) {
            if(set.contains(Character.toLowerCase(c))) {
                set.remove(Character.toLowerCase(c));
            }
        }
        
        return set.isEmpty();
    }
}
