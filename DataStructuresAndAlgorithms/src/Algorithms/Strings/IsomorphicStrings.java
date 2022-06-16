/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author yasir
 */
public class IsomorphicStrings {
    public static boolean areIsomorphic(String str1,String str2)
    {
        int n = str1.length();
        int m = str2.length();
        if(n != m) return false;
        
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> values = new HashSet<>();
        
        for(int i=0;i<str1.length();i++) {
            if(map.containsKey(str1.charAt(i))) {
                if(map.get(str1.charAt(i)) != str2.charAt(i))
                    return false;
            } else if(values.contains(str2.charAt(i))) {
                return false;
            } else {
                map.put(str1.charAt(i),str2.charAt(i));
                values.add(str2.charAt(i));
            }
        }
        
        return true;
    }
}
