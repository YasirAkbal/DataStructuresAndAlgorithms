/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author yasir
 */
public final class GenerateSubsets {
    private GenerateSubsets() { }
    
    public static void solution(String s)  {
        //_solution1(s,"",0);
        _solution2(s,0,new ArrayList<String>());
    }
    
    //BigTheta((2^n)*n)
    private static void _solution1(String str, String current, int charIndex)  {
        if(charIndex == str.length()) { 
            System.out.println(current);
            return;
        }
         
        _solution1(str,current,charIndex+1);
        //Yeni string olusturuluyor. BigTheta(n)
        _solution1(str,current+str.charAt(charIndex),charIndex+1);
    }
    
    //BigTheta((2^n)*n)
    private static void _solution2(String str, int charIndex, ArrayList<String> branch)  {
        if(charIndex == str.length()) {
            String subset = branch.stream()
                  .collect(Collectors.joining());
            System.out.println(subset);
            return;
        }
        
        //her dallanma için bu işlem dizisi yapılacak. döngü ile de yapılabilirdi.
        branch.add("");
        _solution2(str, charIndex+1, branch);
        branch.remove(charIndex);
        
        branch.add(Character.toString(str.charAt(charIndex)));
        _solution2(str, charIndex+1, branch);
        branch.remove(charIndex);
    }
}
