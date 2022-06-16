/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yasir
 */
public class CaseSpecificSortingOfStrings {
    public static String caseSort(String str) {
        int n = str.length();
        ArrayList<Character> uppers = new ArrayList<>();
        ArrayList<Character> lowers = new ArrayList<>();
        StringBuilder sb = new StringBuilder(n);
        
        for(int i=0;i<n;i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                uppers.add(str.charAt(i));
            } else {
                lowers.add(str.charAt(i));
            }
        }
        
        Collections.sort(uppers);
        Collections.sort(lowers);
        
        int i=0, j=0;
        for(int k=0;k<n;k++) {
            if(Character.isUpperCase(str.charAt(k))) {
                sb.append(uppers.get(i)); i++;
            } else {
                sb.append(lowers.get(j)); j++;
            }
        }
        
        return sb.toString();
    }
}
